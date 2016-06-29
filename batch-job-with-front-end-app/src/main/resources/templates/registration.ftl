<#include "include/header.ftl">
<link rel="stylesheet" href="/css/registration.css" >
<body>
    <div class="container">
        <form class="form-registration" method="POST">
            <h2 class="form-registration-heading">Registration</h2>
            <label for="inputUserName" class="sr-only">User name></label>
            <input type="text" id="inputUserName" name="userName" class="form-control" placeholder="User name" required autofocus>
            <label for="inputEmail" class="sr-only">Email address</label>
            <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
        </form>
    </div>
</body>
<#include "include/footer.ftl">