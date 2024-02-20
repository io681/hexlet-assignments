@import exercise.util.NamedRoutes
@import exercise.dto.BasePage
@import gg.jte.Content
@param Content content
@param BasePage page = null

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <link href="/style.css" rel="stylesheet">
    <title>Hexlet Javalin Example</title>
</head>
<body>
<header>
    <h1>Header</h1>
</header>
@if(page != null && page.getFlash() != null)
    @if(page.getFlash().contains("Error!"))
        <p class="alert alert-danger" role="alert">${page.getFlash()}</p>
    @else
        <p class="alert alert-success" role="alert">${page.getFlash()}</p>
    @endif
@endif
${content}
<footer>
</footer>
</body>
</html>

