package exercise.controller.users;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    private List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    public ResponseEntity<List<Post>> indexByUser(@PathVariable String id) {
        return ResponseEntity.ok()
                .body(posts.stream().filter(p -> p.getUserId() == Integer.parseInt(id)).toList());
    }

    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post createByUser(@PathVariable String id, @RequestBody Post dataPost) {
        var post = new Post();

        post.setUserId(Integer.parseInt(id));
        post.setBody(dataPost.getBody());
        post.setTitle(dataPost.getTitle());
        post.setSlug(dataPost.getSlug());

        posts.add(post);
        return post;
    }
}
// END
