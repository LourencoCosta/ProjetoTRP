<!DOCTYPE html>
<html xmlns:g="http://www.w3.org/1999/XSL/Transform">
    <head>
        <meta name="layout" content="maintrp" />
        <g:set var="entityName" value="${message(code: 'usuarioSistema.label', default: 'UsuarioSistema')}" />
        <title><g:message code="default.create.usuario.label" args="[entityName]" /></title>
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
	</script>


    </head>
    <body>
        <a href="#create-usuarioSistema" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                </ul>
            </div>
            <div id="create-usuarioSistema" class="content scaffold-create" role="maintrp">
                <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.usuarioSistema}">
                <ul class="errors" role="alert">
                    <g:eachError bean="${this.usuarioSistema}" var="error">
                        <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                        </g:eachError>
                </ul>
            </g:hasErrors>

            <g:form action="save">
                <fieldset class="form">

		    <f:field bean="usuarioSistema" property="nome"/>
		    <f:field bean="usuarioSistema" property="email"/>

		    <f:field bean="usuarioSistema" property="login"/>
		    <f:field bean="usuarioSistema" property="senha"/>
                    <f:field bean="usuarioSistema" label=" " property="termoDeUsuAceito"><a href="#" class="lightbox"><input type="checkbox" name="teste" id="teste"  />Li e Aceito com os termos de uso</a></f:field>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
	    <div class="background"></div>
	    <div class="box">
		<div class="close">X</div>
		<h1>TERMO DE CONFIDENCIALIDADE E SIGILO</h1>
		<p align="justify">
		    Eu nome, nacionalidade, estado civil, cargo (Técnicou ou Analista), inscrito(a) no CPF sob o nº 000.000.000-00,  assumo o compromisso de manter a confidencialidade e sigilo sobre todas as informações jurídicas e técnicas relacionadas ao cargo, função ou atividade que exercer no âmbito do Tribunal Regional do Trabalho da 14ª Região ou fora dele.
		    Por este termo de confidencialidade e sigilo comprometo-me:
		    1. A não utilizar as informações confidenciais a que tiver acesso, para gerar benefício próprio exclusivo e/ou unilateral, presente ou futuro, ou para o uso de terceiros;
		    2. A não efetuar nenhuma gravação ou cópia da documentação confidencial a que tiver acesso;
		    3. A não apropriar-se para si ou para outrem de material confidencial e/ou sigiloso da tecnologia que venha a ser disponível;
		    4. A não repassar o conhecimento das informações confidenciais, responsabilizando-se por todas as pessoas que vierem a ter acesso às informações, por seu intermédio, e obrigando-se, assim, a ressarcir a ocorrência de qualquer dano e / ou prejuízo oriundo de uma eventual quebra de sigilo das informações fornecidas.
		    Neste Termo, as seguintes expressões serão assim definidas:
		    Informação Confidencial significará toda informação revelada através da apresentação da tecnologia, a respeito de, ou, associada com a Avaliação, sob a forma escrita, verbal ou por quaisquer outros meios.
		    Informação Confidencial inclui, mas não se limita, à informação relativa às operações, processos, planos ou intenções, informações sobre produção, instalações, equipamentos, sistemas, dados, habilidades especializadas, projetos, métodos e metodologia, fluxogramas, especializações, componentes, fórmulas, produtos e questões relativas ao desempenho das atividades laborais.
		    Avaliação significará todas e quaisquer discussões, conversações ou negociações entre, ou com as partes, de alguma forma relacionada ou associada com a apresentação da tecnologia, projetos ou produto
		    A vigência da obrigação de confidencialidade e sigilo, assumida pela minha pessoa por meio deste termo, terá a validade enquanto a informação não for tornada de conhecimento público por qualquer outra pessoa, ou mediante autorização escrita, concedida à minha pessoa pelas partes interessadas neste termo.
		    Pelo não cumprimento do presente Termo de Confidencialidade e Sigilo, fica o abaixo assinado ciente de todas as sanções judiciais que poderão advir.
		    Campinas,  ${new Date()}
		</p>
	    </div>

    </body>
</html>
<f:field bean="usuarioSistema" property="cpf"/>