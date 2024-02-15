@import exercise.dto.users.UsersPage
@param UsersPage usersPage


@template.layout.page(content = @`
        <form action="/users" method="get">
            <input type="search" name="term" value="${usersPage.getTerm()}" />
            <input type="submit" value="Search" />
        </form>
        <div class="mx-auto p-4 py-md-5">
            @if(usersPage.getUsers().isEmpty())
                <p>Результаты не найдены</p>
            @else
                <table>
                    @for(var user : usersPage.getUsers())
                        <tr>
                            <td><p><a href="/users/${user.getId()}">${user.getFirstName()}</a></p></td>
                            <td><p>${user.getLastName()}</p></td>
                            <td><p>${user.getEmail()}</p></td>
                        </tr>
                    @endfor
                </table>
            @endif
        </div>
`)