@import exercise.dto.users.UserPage;
@param UserPage userPage

<html>
    <head>
        <title>Пользователь</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="app.css">
    </head>
    <body>
        <div>
            <h2>${userPage.getUser().getId()}</h2>
            <h2>${userPage.getUser().getFirstName()}</h2>
            <h2>${userPage.getUser().getLastName()}</h2>
            <h2>${userPage.getUser().getEmail()}</h2>
        </div>
    </body>
</html>