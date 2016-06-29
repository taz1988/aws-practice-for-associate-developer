<#include "include/header.ftl">
<link rel="stylesheet" href="/css/registration.css" >
<body>
    <div class="container">

        <div class="starter-template">
            <h1>Successful registration! We will redirect you to the dashboard...</h1>
        </div>
    </div>
<script>
    setTimeout(function () {
        location.href = "/dashboard";
    }, 3000);
</script>
</body>
<#include "include/footer.ftl">