<#macro layoutHead title >
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="SHIELD - Free Bootstrap 3 Theme">
    <meta name="author" content="Carlos Alvarez - Alvarez.is - blacktie.co">

    <title> SHIELD - Free Bootstrap 3 Theme</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" type="text/css" href="${ctx.getContextPath()}/resources/css/bootstrap.min.css" />

    <!-- Custom styles for this template -->
    <link href="${ctx.getContextPath()}/resources/css/main.css" rel="stylesheet">
    <link href="${ctx.getContextPath()}/resources/css/icomoon.css" rel="stylesheet">
    <link href="${ctx.getContextPath()}/resources/css/animate-custom.css" rel="stylesheet">

    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,300,700' rel='stylesheet' type='text/css'>

    <script type="text/javascript" src="${ctx.getContextPath()}/resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx.getContextPath()}/resources/js/modernizr.custom.js"></script>
  </head>
</#macro>

<#macro layoutBody>
<body data-spy="scroll" data-offset="0" data-target="#navbar-main">
    <#include "header.ftl" >
    <@header></@header>

    <#nested>
</#macro>

<#macro layoutFooter>
    <#include "footer.ftl" >
    <@footer></@footer>

    <#nested>
<script type="text/javascript" src="${ctx.getContextPath()}/resources/js/retina.js"></script>
<script type="text/javascript" src="${ctx.getContextPath()}/resources/js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="${ctx.getContextPath()}/resources/js/smoothscroll.js"></script>
<script type="text/javascript" src="${ctx.getContextPath()}/resources/js/jquery-func.js"></script>
</body>
</html>
</#macro>