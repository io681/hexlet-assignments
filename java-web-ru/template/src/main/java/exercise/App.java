package exercise;


import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import java.util.Collections;
//import java.util.Map;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN

        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParam("id");

            var user = USERS.stream()
                    .filter(c -> c.getId() == Long.parseLong(id))
                    .findFirst()
                    .orElse(null);
            if (user == null) {
                throw new NotFoundResponse("User not found");
            }
            var userPage = new UserPage(user);
            ctx.render("users/show.jte", Collections.singletonMap("userPage", userPage));
        });

        app.get("/users", ctx -> {
            var users = new ArrayList<>(USERS);
            var header = "Список пользователей";
            var usersPage = new UsersPage(header, users);
            ctx.render("users/index.jte", Collections.singletonMap("usersPage", usersPage));
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
