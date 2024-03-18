package exercise.controller;

import java.util.List;

import exercise.dto.TaskCreateDTO;
import exercise.dto.TaskDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.mapper.TaskMapper;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.TaskRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    // BEGIN
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private TaskMapper taskMapper;
    @GetMapping(path = "")
    public List<TaskDTO> index() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::map)
                .toList();
    }

    @GetMapping(path = "/{id}")
    public TaskDTO show(@PathVariable Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        return taskMapper.map(task);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO create(@Valid @RequestBody TaskCreateDTO taskCreateDTO) {
        var task = taskMapper.map(taskCreateDTO);
        var assigneeId = task.getAssignee().getId();

        var user = userRepository.findById(assigneeId)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found User with id: " + assigneeId));;

        user.addTask(task);
        taskRepository.save(task);

        return taskMapper.map(task);

    }

    @PutMapping(path = "/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody TaskUpdateDTO taskUpdateDTO) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));

        taskMapper.update(taskUpdateDTO, task);

        var assigneeId = taskUpdateDTO.getAssigneeId();
        var user = userRepository.findById(assigneeId)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found User with id: " + assigneeId));

        task.setAssignee(user);
        taskRepository.save(task);

    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));

        var assigneeId = task.getAssignee().getId();
        var user = userRepository.findById(assigneeId)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found User with id: " + assigneeId));

        user.removeTask(task);

        taskRepository.delete(task);
    }
    // END
}
