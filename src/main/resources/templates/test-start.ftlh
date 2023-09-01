<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Тестирование</title>
</head>
<style>
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

    a {
    	font-family: Arial, Helvetica, sans-serif;
    	font-size: 15px;
    	color: #fafafa;
    	padding: 8px 18px;
    	display: inline-block;
    	text-decoration: none;
    	border-radius: 3px;
    	box-shadow: 0px 6px #27ae60;
    	background: #2ecc71;
    }
    a:hover {
    	background: #36d479;
    }
    a:active {
    	position: relative;
    	top: 6px;
    	box-shadow: 0px 0px #23a33d;
    	background: #23a33d;
    }

</style>
<body>

<#if !attribute.personForMainPageDTO.firstName?has_content>
<div style = "float: right">
    <a href="/auth/login">Войти</a>
    <a href="/auth/registration">Зарегистрироваться</a>
</div>
<#else>
<div style = "float: right">
    <a href="/admin/view">Админка</a>
    <a href="/auth/logout">Выйти</a>
</div>
</#if>

<#if !attribute.personForMainPageDTO.firstName?has_content>
 <h2>Чтобы пройти тесты, вы должны войти</h2>
 <#assign type = "disabled">
 <#assign clazz = "">
<#else>
 <h2>Здравствуйте ${attribute.personForMainPageDTO.firstName} ${attribute.personForMainPageDTO.lastName}. Вы можете пройти тесты:</h2>
 <#assign type = "">
 <#assign clazz = "button">

</#if>

<#list attribute.testForMainPageDTOList as test>

    <form method="post" action="/test-post-start">
        <fieldset>
            <input type="hidden" name="id" value=${test.id}>
            <input class="${clazz}" type="submit" name="button" value="Начать" ${type} >
            ${test.title}
            <br>
            ${test.description}
        </fieldset>
    </form>
    <br>

</#list>

</body>
</html>
