@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <link href="/style.css" rel="stylesheet">
    <title>Hexlet Javalin Example</title>
</head>
<body>
<header>
    <div class="header-link"><a href="/">Main page</a></div>
    <div class="header-link"><a href="/users">Users</a></div>
</header>
${content}
<footer>
    <a> text of footer</a>
</footer>
</body>
</html>