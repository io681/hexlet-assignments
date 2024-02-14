@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
        </main>
    </div>
`)