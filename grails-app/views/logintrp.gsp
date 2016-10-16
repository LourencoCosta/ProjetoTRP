<!doctype html>
<html>
    <head>
        <meta name="layout" content="maintrp"/>
        <title>TRP</title>

    <asset:link rel="icon" href="logo_2.gif" type="image/x-ico" />
</head>
<body>
<content tag="nav">
    <li class="dropdown">


    </li>

    <li class="dropdown">

    </li>
    <li class="dropdown">

    </li>
</content>

<div class="svg" role="presentation">
    <div class="grails-logo-container">
        <asset:image src="logo_2.gif" class="grails-logo"/>
    </div>
</div>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>The Rigth Professional</h1>
        <div align="center">
            <g:form controller="autenticacao" action="autenticar" method="post">
                Login:<br/>
                <input type="text" name="login"/><br/>
                Senha:<br/>
                <input type="password" name="senha"/><br/>
                <input type="submit" value="Entrar"/>
            </g:form>
            <g:if test="${flash.message}">
                <div class="message">${flash.message}</div>
            </g:if>
        </div>
    </section>
</div>

</body>
</html>