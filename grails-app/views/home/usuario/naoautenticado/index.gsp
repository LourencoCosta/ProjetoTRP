<!--<!doctype html>-->
<html>
    <head>
        <meta name="layout" content="maintrp"/>
        <title>TRP</title>
    <asset:link rel="icon" href="logo_trp_final_barra.gif" type="image/x-ico" />
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
	<asset:image src="logo_trp_final.gif" class="grails-logo"/>
    </div>
</div>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>The Rigth Professional</h1>
	<hr>
        <p align="justify">
            Bem Vindo Ao TRP - The Right Professional uma ferramenta que permite uma experiência mais agradável na contratação de serviços<br>
            de profissionais Liberais e Autonomos.<br><br><br>
        </p>
        <div id="controllers" role="navigation">

            <ul align="center">
		<asset:image align="center" src="transicao_3.png" class="grails-logo" height="1000" width="900"/><br> <br>
		<h1><b>Contrate os melhores profissionais autonomos disponíveis no mercado</b></h1><hr><br><br>
		<asset:image align="center" src="transicao_1.jpg" class="grails-logo" height="1000" width="600"/><br> <br>
		<h1><b>Tenha Garantia do Serviço executado</b></h1><hr><br><br>
		<asset:image align="center" src="transicao_2.jpg" class="grails-logo"height="1000" width="600"/><br><br>
		<h1><b>Efetue o pagamento via TRP</b></h1><hr><br><br>

            </ul>
        </div>
    </section>
</div>
</body>
</html>
