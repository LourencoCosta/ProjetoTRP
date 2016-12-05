<!doctype html>
<html>
    <head>
        <meta name="layout" content="maintrp"/>
        <title>TRP</title>
    <asset:link rel="icon" href="logo_trp_final_barra.gif" type="image/x-ico" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <script defer type="text/javascript">

	$(document).ready(function () {
	$('.lightbox').click(function () {
	$('.background, .box').animate({'opacity':'.60'}, 500, 'linear');
	$('.box').animate({'opacity':'1.00'}, 500, 'linear');
	$('.background, .box').css('display', 'block');
	define();
	});

	$('.close').click(function () {
	$('.background, .box').animate({'opacity':'.0'}, 500, 'linear');
	$('.background, .box').css('display', 'none');
	});

	$('.background').click(function () {
	$('.background, .box').animate({'opacity':'.0'}, 500, 'linear');
	$('.background, .box').css('display', 'none');
	});
	});


	$(document).ready(function(){
	});

	function listarProfissionais(){
	$.ajax({
	method: "POST",
	url: '${g.createLink( controller:'home', action:'listagemDeProfissionais')}',
	data: {},
	success: function (data){
	$("#todoConteudo").html(data);
	}
	});
	}

	function listarMensagens(){
	$.ajax({
	method: "POST",
        url: '${g.createLink( controller:'menssagem', action:'listagemDeMensagens')}',
	data: {},
	success: function (data){
	$("#todoConteudo").html(data);
	}
	});
	}

	function listarContratos(){
	$.ajax({
	method: "POST",
        url: '${g.createLink( controller:'home', action:'listagemDeContratos')}',
	data: {},
	success: function (data){
	$("#todoConteudo").html(data);
	}
	});
	}

	function listarCategorias(){
	$.ajax({
	method: "POST",
        url: '${g.createLink( controller:'home', action:'listagemCategorias')}',
	data: {},
	success: function (data){
	console.log(data);
	}
	});
	}

	function trazerDetalhesProfissional(id){
	$.ajax({
	method: "POST",
        url: '${g.createLink( controller:'home', action:'detalheprofissional')}',
	data: {"id":id},
	success: function (data){
	console.log(data);
	$("#detalheProfissional"+id).html(data);
	}
	});
	}

	function ocultarDetalhesProfissional(id){
	$("#detalheProfissional"+id).html("");
	}

	function listarMenssagens(){
	$.ajax({
	method: "POST",
        url: '${g.createLink( controller:'home', action:'listarMenssagens')}',
	data: {},
	success: function (data){
	console.log(data);
	$("#todoConteudo").html(data);

	}
	});
	}

	function criarContrato(id){
	$.ajax({
	method: "POST",
        url: '${g.createLink( controller:'home', action:'criarContrato')}',
	data: {"id":id},
	success: function (data){
	console.log(data);
	$("#detalheProfissional"+id).html(data);
	}
	});
	}
    </script>
</head>
<body>

<content tag="nav">
    <li class="buttons">

	<input type="submit" name="contratoslistador" value="Contratos" onclick="listarContratos()" />
    </li>
    <li class="buttons">
	<input type="submit" name="menssagemlistador" value="Menssagens" onclick="listarMenssagens()"/>
    </li>

    <li class="buttons">
        <g:form controller="autenticacao" action="index">
            <g:actionSubmit value="Cadastro" action="index"/>
        </g:form>
    </li>

    <li class="buttons">
        <g:form controller="autenticacao" action="logout">
            <g:actionSubmit value="Logout" action="logout"/>
        </g:form>
    </li>



</content>

<div class="svg" role="presentation">

    <div align="center">
	Busca Rápida
        <g:form controller="chat" action="escreve" method="post" >

            <g:textField class="buttons" name="profissionais" value="Profissionals" />
            <g:textField class="buttons" type="combo" name="myField" value="Áreas" />
            <input class="buttons" align="center" type="submit" value="Pesquisar" id="sendButton" name="Pesquisar"/>
        </g:form>
    </div>

    <div id="content" role="main">
	<section class="row colset-2-its">
	    <div id="controllers" role="navigation">


		<ul>
		    <hr>
		    <div id="todoConteudo" ><h1 align="center"><b>The Rigth Professional - O seu problema em boas mãos <br></b></h1></div>
		    <hr>
		</ul>
		<input type="submit" name="prof" value="Profissionais" onclick="listarProfissionais()"/>
		<input type="submit" name="catego" value="Categorias" onclick="listarCategorias()"/>
	    </div>
    </div>
</section>
</div>

</body>
</html>


<li>
    <div id="loginHeader">
        <g:loginControl />
    </div>
</li>

/home/rlc/Área de Trabalho/workspace/ProjetoTRP/grails-app/assets/images/contratoTeste.gif