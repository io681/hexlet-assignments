@import exercise.dto.users.UsersPage;
@param UsersPage usersPage

<html>
    <head>
        <title>${usersPage.getHeader()}</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="app.css">
    </head>
    <body>
        <h1>${usersPage.getHeader()}</h1>
        @if(usersPage.getUsers().isEmpty())
            <p>Пока не добавлено ни одного пользователя</p>
        @else
            <table>
            @for(var user : usersPage.getUsers())
              <tr>
                <td><p><a href="/courses/${user.getId()}">${user.getFirstName()}</a></p></td>
                <td><p>${user.getLastName()}</p></td>
                <td><p>${user.getEmail()}</p></td>
              </tr>
            @endfor
            </table>
        @endif
    </body>
</html>
