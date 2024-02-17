package exercise.controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void index(Context ctx) {

        var pageIndex = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);

        var previousPage = pageIndex == 1 ? 1 : pageIndex - 1;
        var nextPage = pageIndex + 1;
        var posts = PostRepository.getEntities().subList((pageIndex - 1) * 5, (pageIndex - 1) * 5 + 5);
        var page = new PostsPage(posts, pageIndex, previousPage, nextPage);
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));

    }

    public static void show(Context ctx) {
        var id = ctx.pathParam("id");
        var posts = PostRepository.getEntities();
        var post = posts.stream()
                .filter(p -> p.getId().toString().equals(id))
                .findAny()
                .orElse(null);
        if (post == null) {throw new NotFoundResponse("Page not found");}
        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
    // END
}
