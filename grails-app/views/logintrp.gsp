<!doctype html>
<html>
    <head>
        <meta name="layout" content="maintrp"/>
        <title>TRP</title>

    <asset:link rel="icon" href="logo_trp_final_barra.gif" type="image/x-ico" />
</head>
<body>
<content tag="nav">
    <li class="buttons">
        <g:form controller="HomeController" action="index">
            <g:actionSubmit value="Inicio" action="index"/>
        </g:form>
    </li>
    <li class="buttons">
        <g:form controller="usuarioSistema" action="crete">
            <g:actionSubmit value="CADASTRAR-SE" action="create"/>
        </g:form>
    </li>
    <li class="dropdown">


    </li>

    <li class="dropdown">

    </li>
    <li class="dropdown">

    </li>




</content>

<div class="svg" role="presentation">
    <div class="grails-logo-container">
        <asset:image src="logo_trp_final.gif" class="grails-logo"/>
    </div>
</div>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>The Rigth Professional</h1>
        <div align="center">
            <g:form controller="autenticacao" action="autenticar" method="post">
                Login:<br/>
                <input class="buttons" type="text" name="login"/><br/>
                Senha:<br/>
                <input class="buttons" type="password" name="senha"/><br/>
	    <input class="buttons" type="submit" value="Entrar"/>
            </g:form>

         <g:actionSubmit class="buttons"   action="update" id="facebook" value="Facebook"/>

            <g:if test="${flash.message}">
                <div class="message">${flash.message}</div>
            </g:if>
        </div>
    </section>
</div>

</body>
</html>