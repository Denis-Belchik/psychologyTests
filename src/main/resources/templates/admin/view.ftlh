<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Тестирование</title>
</head>
<style>
    table {
        border-collapse: collapse;
        border-spacing: 0;
        /*width: 100%;*/
        border: 1px solid #ddd;
    }

    th, td {
        text-align: left;
        padding: 10px;
        border: 1px solid #ddd;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2
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
<div style = "float: right">
    <a href="/">К тестам</a>
    <a href="/auth/logout">Выйти</a>
</div>

<form method="post" action="/admin/view-person-post">

                <input class="button" type="submit" name="button" value="Пользователи">
                <br>
                <br>

                <#if infoperson?has_content>

                <table>
                            <tr>
                                <th>Логин</th>
                                <th>Имя</th>
                                <th>Фамилия</th>
                                <th>Почта</th>
                                <th>Роль</th>
                                <th>Активный</th>
                                <th>Дата регистации</th>
                            </tr>
                                <#list infoperson as info>

                                    <tr>
                                        <td>${info.username}</td>
                                        <td>${info.firstName}</td>
                                        <td>${info.lastName}</td>
                                        <td>${info.email}</td>
                                        <td>${info.role}</td>
                                        <td>${info.enabled?c}</td>
                                        <td>${info.dateTime}</td>
                                    </tr>

                                </#list>
                </table>

                </#if>

</form>
</body>
</html>