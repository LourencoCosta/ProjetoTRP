<!doctype html>
<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta name="layout" content="maintrp"/>
        <title>TRP</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sample title</title>
</head>
<h1>ConCot</h1>
<g:form action="autenticar" controller="autenticacao">
    Login:<br/>
    <input type="text" name="login"/><br/>
    Senha:<br/>
    <input type="password" name="senha"/><br/>
    <input type="submit" value="Entrar"/>
</g:form>
</html>
