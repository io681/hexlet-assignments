package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;


// BEGIN
@AllArgsConstructor
@Getter
public class PostsPage {
    private List<Post> posts;
    private Integer pageIndex;
    private Integer previousPage;
    private Integer nextPage;
}
// END


