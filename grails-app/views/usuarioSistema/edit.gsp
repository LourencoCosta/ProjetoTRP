<!DOCTYPE html>
<html>
    <head>
        <g:set var="entityName" value="${message(code: 'usuarioSistema.label', default: 'UsuarioSistema')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
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


        	    jQuery(function($){
        	    $("#cep").change(function(){
        	    var cep_code = $(this).val();
        	    if( cep_code.length <= 0 ) return;
        	    $.get("http://apps.widenet.com.br/busca-cep/api/cep.json", { code: cep_code },
        	    function(result){
        	    if( result.status!=1 ){
        	    alert(result.message || "Houve um erro desconhecido");
        	    return;
        	    }
        	    $("input#cep").val( result.code );
        	    $("input#estado").val( result.state );
        	    $("input#cidade").val( result.city );
        	    $("input#bairro").val( result.district );
        	    $("input#rua").val( result.address );
        	    });
        	    });
        	    });

        	</script>
    </head>
    <body>
        <a href="#edit-usuarioSistema" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
            </ul>
        </div>
        <div id="edit-usuarioSistema" class="content scaffold-edit" role="main">
            <h1>Editar Cadastro</h1>
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
            <g:form resource="${this.usuarioSistema}" method="PUT">
                <g:hiddenField name="version" value="${this.usuarioSistema?.version}" />
                <fieldset class="form">
                <f:field bean="usuarioSistema" property="nome"><input class="buttons" type="text" name="nome" id="nome" size="50" value="${this.usuarioSistema?.nome}"/></f:field>
                				    <f:field bean="usuarioSistema" property="email"><input class="buttons" type="text" name="email" id="email"  size="50" value="${this.usuarioSistema?.email}"/></f:field>
                				    <f:field bean="usuarioSistema" property="cpf" lable="CPF"><input class="buttons" type="text" name="cpf" id="cpf" value="${this.usuarioSistema?.cpf}"/></f:field>
                				    <f:field bean="usuarioSistema" property="login"><input class="buttons" type="text" name="login" id="login" value="${this.usuarioSistema?.login}"/></f:field>
                				    <f:field bean="usuarioSistema" property="senha"><input class="buttons" type="password" name="senha" id="senha" value="${this.usuarioSistema?.senha}"/></f:field>
                				    <f:field bean="usuarioSistema" property="cep"><input class="buttons" type="text" name="cep" id="cep" value="${this.usuarioSistema?.cep}"/></f:field>
                				    <f:field bean="usuarioSistema" property="rua"><input class="buttons"type="text" name="rua" id="rua"  size="50" value="${this.usuarioSistema?.rua}"/></f:field>
                				    <f:field bean="usuarioSistema" property="bairro"><input class="buttons" type="text" name="bairro" id="bairro"  size="50" value="${this.usuarioSistema?.bairro}"/></f:field>
                				    <f:field bean="usuarioSistema" property="numero"><input class="buttons" type="text" name="numero" id="numero" value="${this.usuarioSistema?.numero}"/></f:field>
                				    <f:field bean="usuarioSistema" property="cidade"><input class="buttons" type="text" name="cidade" id="cidade" size="50" value="${this.usuarioSistema?.cidade}"/></f:field>
                				    <f:field bean="usuarioSistema" property="estado"><input class="buttons" type="text" name="estado" id="estado" value="${this.usuarioSistema?.estado}"/></f:field>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
