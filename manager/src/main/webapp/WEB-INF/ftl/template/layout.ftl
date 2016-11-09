<#macro layoutHead title >
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>${title!""} - 管理平台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" type="text/css" href="${ctx.getContextPath()}/resources/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx.getContextPath()}/resources/css/bootstrap-theme.css"/>
    <style>
        body {
            height: 100%;
            margin: 0;
            background-size: 1440px 800px;
            background: url("${ctx.getContextPath()}/resources/books.jpg") no-repeat;
            display: compact;
        }
    </style>
    <#nested>

</head>
</#macro>

<#macro layoutBody>
<body>
    <#include "header.ftl" >
    <@header></@header>

    <#nested>
</#macro>

<#macro layoutFooter>
    <#include "footer.ftl" >
    <@footer></@footer>

    <#nested>

<script type="text/javascript" src="${ctx.getContextPath()}/resources/js/jquery-2.1.3.js"></script>
<script type="text/javascript" src="${ctx.getContextPath()}/resources/js/bootstrap.js"></script>
</body>
</html>
</#macro>