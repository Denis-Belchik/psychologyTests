<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
    font-family: Arial, Helvetica, sans-serif;
    background-color:#214c84;
}

* {
    box-sizing: border-box;
}

/* Add padding to containers */
.container {
    padding: 5px;
    background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 5px;
    margin: 5px 0 10px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}

/* Overwrite default styles of hr */
hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 10px;
}

/* Set a style for the submit button */
.registerbtn {
    background-color: #4CAF50;
    color: white;
    padding: 5px 10px;
    margin: 4px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}

.registerbtn:hover {
    opacity: 1;
}

/* Add a blue text color to links */
a {
    color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
    background-color: #f1f1f1;
    text-align: center;
}
</style>
</head>
<body>
<div style="width: 40%; margin-left: auto; margin-right: auto">
<form method="post" action="<@spring.url '/auth/registration'/>">
  <div class="container">
    <h1>Регистрация</h1>
    <p>Пожалуйста заполните все поля.</p>
    <hr>

        <@spring.bind 'personForRegDTO.username'/>
          <#list spring.status.errorMessages as error>
              <span class="error">${error}</span>
              <br>
          </#list>
     <label for="text"><b>Логин</b></label>
     <input type="text" placeholder="Логин" name="username" required>

        <@spring.bind 'personForRegDTO.firstName'/>
          <#list spring.status.errorMessages as error>
              <span class="error">${error}</span>
              <br>
          </#list>
     <label for="text"><b>Имя</b></label>
     <input type="text" placeholder="Имя" name="firstName" required>

        <@spring.bind 'personForRegDTO.lastName'/>
          <#list spring.status.errorMessages as error>
              <span class="error">${error}</span>
              <br>
          </#list>
     <label for="text"><b>Фамилия</b></label>
     <input type="text" placeholder="Имя" name="lastName" required>

        <@spring.bind 'personForRegDTO.email'/>
          <#list spring.status.errorMessages as error>
              <span class="error">${error}</span>
              <br>
          </#list>
     <label for="text"><b>Email</b></label>
     <input type="text" placeholder="Email" name="email" required>


        <@spring.bind 'personForRegDTO.password'/>
          <#list spring.status.errorMessages as error>
              <span class="error">${error}</span>
              <br>
          </#list>
    <label for="psw"><b>Пароль</b></label>
    <input type="password" placeholder="Пароль" name="password" required>

        <@spring.bind 'personForRegDTO.confirmPassword'/>
          <#list spring.status.errorMessages as error>
              <span class="error">${error}</span>
              <br>
          </#list>
    <label for="psw"><b>Повторите пароль</b></label>
    <input type="password" placeholder="Пароль" name="confirmPassword" required>

    <button type="submit" class="registerbtn">Регистрация</button>
  </div>

  <div class="container signin">
    <p>У вас уже есть аккаунт? <a href="/auth/login">Войти</a>.</p>
    <p><a href="/">Вернуться</a>.</p>
  </div>
</form>
</div>
</body>
</html>
