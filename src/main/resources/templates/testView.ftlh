<!DOCTYPE html>
<html lang="ru">

<head>
    <title>Тестирование</title>
</head>

<body>

<h2>Проба тестирования</h2>
<br>
<div>${title}</div>
<br>

<div>
    <h1>${quest}</h1><br>
    <#list answers as answer>
        <tr>
            <td>${answer}</td><br>
        </tr>
    </#list>
</div>

</body>

</html>