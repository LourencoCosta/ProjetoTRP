<!--<!doctype html>-->
<html>
    <head>
        <meta name="layout" content="maintrp"/>
        <title>TRP</title>
    <asset:link rel="icon" href="logo_2_1.svg" type="image/x-ico" />
</head>
<body>

<content tag="nav">
    <li class="buttons">
        <g:form controller="usuarioSistema" action="crete">
            <g:actionSubmit value="CADASTRAR-SE" action="create"/>
        </g:form>
    </li>
    <li class="buttons">
        <g:form controller="autenticacao" action="index">
            <g:actionSubmit value="Login" action="index"/>
        </g:form>
    </li>
</content>

<div class="svg" role="presentation">
    <div class="grails-logo-container">
            <asset:image src="logo_2_1.svg" class="grails-logo"/>
    </div>
</div>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>The Rigth Professional</h1>
        <p >
            Bem Vindo Ao TRP - The Right Professional uma ferramenta que permite uma experiência mais agradável na contratação de serviços<br>
            de profissionais Liberais e Autonomos.<br>
        </p>
        <div id="controllers" role="navigation">
           
            <ul>
                
            </ul>
        </div>
    </section>
</div>
</body>
</html>
