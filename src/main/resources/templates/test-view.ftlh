<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Тестирование</title>
</head>
<style>
    /* The container */
    .containerCheckbox {
        display: block;
        position: relative;
        padding-left: 35px;
        margin-bottom: 12px;
        cursor: pointer;
        font-size: 22px;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
    }

    /* Hide the browser's default checkbox */
    .containerCheckbox input {
        position: absolute;
        opacity: 0;
        cursor: pointer;
    }

    /* Create a custom checkbox */
    .checkmarkCheckbox {
        position: absolute;
        top: 0;
        left: 0;
        height: 25px;
        width: 25px;
        background-color: #B3B3B3;
    }

    /* On mouse-over, add a grey background color */
    .containerCheckbox:hover input ~ .checkmarkCheckbox {
        background-color: #ccc;
    }

    /* When the checkbox is checked, add a blue background */
    .containerCheckbox input:checked ~ .checkmarkCheckbox {
        background-color: #2196F3;
    }

    /* Create the checkmark/indicator (hidden when not checked) */
    .checkmarkCheckbox:after {
        content: "";
        position: absolute;
        display: none;
    }

    /* Show the checkmark when checked */
    .containerCheckbox input:checked ~ .checkmarkCheckbox:after {
        display: block;
    }

    /* Style the checkmark/indicator */
    .containerCheckbox .checkmarkCheckbox:after {
        left: 9px;
        top: 5px;
        width: 5px;
        height: 10px;
        border: solid white;
        border-width: 0 3px 3px 0;
        -webkit-transform: rotate(45deg);
        -ms-transform: rotate(45deg);
        transform: rotate(45deg);
    }


    .button {
        position: relative;
        background-color: #4CAF50;
        border: none;
        font-size: 15px;
        color: #FFFFFF;
        padding: 10px;
        width: 130px;
        text-align: center;
        -webkit-transition-duration: 0.4s; /* Safari */
        transition-duration: 0.4s;
        text-decoration: none;
        overflow: hidden;
        cursor: pointer;
    }

    .button:after {
        content: "";
        background: #90EE90;
        display: block;
        position: absolute;
        padding-top: 300%;
        padding-left: 350%;
        margin-left: -20px !important;
        margin-top: -120%;
        opacity: 0;
        transition: all 0.8s
    }

    .button:active:after {
        padding: 0;
        margin: 0;
        opacity: 1;
        transition: 0s
    }

    .containerForm {
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 20px;
    }

    /* The container */
    .container {
        display: block;
        position: relative;
        padding-left: 35px;
        margin-bottom: 12px;
        cursor: pointer;
        font-size: 22px;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
    }

    /* Hide the browser's default radio button */
    .container input {
        position: absolute;
        opacity: 0;
        cursor: pointer;
    }

    /* Create a custom radio button */
    .checkmark {
        position: absolute;
        top: 0;
        left: 0;
        height: 25px;
        width: 25px;
        background-color: #B3B3B3;
        border-radius: 50%;
    }

    /* On mouse-over, add a grey background color */
    .container:hover input ~ .checkmark {
        background-color: #ccc;
    }

    /* When the radio button is checked, add a blue background */
    .container input:checked ~ .checkmark {
        background-color: #2196F3;
    }

    /* Create the indicator (the dot/circle - hidden when not checked) */
    .checkmark:after {
        content: "";
        position: absolute;
        display: none;
    }

    /* Show the indicator (dot/circle) when checked */
    .container input:checked ~ .checkmark:after {
        display: block;
    }

    /* Style the indicator (dot/circle) */
    .container .checkmark:after {
        top: 9px;
        left: 9px;
        width: 8px;
        height: 8px;
        border-radius: 50%;
        background: white;
    }
</style>

<body>
<h1>${title}</h1>
<form class="containerForm" method="post" action="/test-post-view">
    <fieldset>
        <p>${position + 1}/${sizeTest}</p>
        <h1>${quest}</h1>

        <#if type == "RADIO">

            <#list answers as answer>
                <label class="container">${answer.possibleAnswer}
                    <input type="radio" name="id" value="${answer.ID}">
                    <span class="checkmark"></span>
                </label>
            </#list>

        <#else>

            <#list answers as answer>
                <label class="containerCheckbox">${answer.possibleAnswer}
                    <input type="checkbox" name="id" value="${answer.ID}">
                    <span class="checkmarkCheckbox"></span>
                </label>
            </#list>

        </#if>

        <#if position != 0>
            <input class="button" type="submit" name="button" value="Предыдущий">
        </#if>

        <#if position == sizeTest - 1>
            <input class="button" type="submit" name="button" value="Закончить">
        <#else>
            <input class="button" type="submit" name="button" value="Следующий">
        </#if>

    </fieldset>
</form>
</body>
</html>