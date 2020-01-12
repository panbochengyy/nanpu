<!DOCTYPE html>
<html>
<head lang="en">
    <title>Spring Boot Demo - FreeMarker</title>
    <script type="text/javascript" src="/js/index.js"></script>
    <link href="/css/base.css" rel="stylesheet">
    
</head>
<body>
<h2>首页<h2>
 ${error}
     <br>
   <#list  userList as u>

      ${u.id}
       ${u.realname}
       ${u.username}
       ${u.password}

   </#list>
</body>
</html>