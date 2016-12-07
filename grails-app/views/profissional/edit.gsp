<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'profissional.label', default: 'Profissional')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-profissional" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
		</ul>
	    </div>
	    <div id="edit-profissional" class="content scaffold-edit" role="main">
		<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
		<div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.profissional}">
		<ul class="errors" role="alert">
		    <g:eachError bean="${this.profissional}" var="error">
			<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
			</g:eachError>
		</ul>
            </g:hasErrors>
            <g:form resource="${this.profissional}" method="PUT">
                <g:hiddenField name="version" value="${this.profissional?.version}" />
                <fieldset class="form">
                    <f:all bean="profissional"/>
		    <fieldset class="form">
			<f:field bean="profissional" property="nome"><input class="buttons" type="hidden" name="nome" id="nome" size="50" value="${session.usuarioSistema.nome}"/></f:field>
			<f:field bean="profissional" property="email"><input class="buttons" type="hidden" name="email" id="email"  size="50" value="${session.usuarioSistema.email}"/></f:field>
			<f:field bean="profissional" property="cpf" lable="CPF"><input class="buttons" type="hidden" name="cpf" id="cpf" value="${session.usuarioSistema.cpf}"/></f:field>
			<f:field bean="profissional" property="login"><input class="buttons" type="hidden" name="login" id="login" value="${session.usuarioSistema.login}"/></f:field>
			<f:field bean="profissional" property="senha"><input class="buttons" type="hidden" name="senha" id="senha" value="${session.usuarioSistema.senha}"/></f:field>
			<f:field bean="profissional" property="cep"><input class="buttons" type="hidden" name="cep" id="cep" value="${session.usuarioSistema.cep}"/></f:field>
			<f:field bean="profissional" property="rua"><input class="buttons"type="hidden" name="rua" id="rua"  size="50" value="${session.usuarioSistema.rua}"/></f:field>
			<f:field bean="profissional" property="bairro"><input class="buttons" type="hidden" name="bairro" id="bairro"  size="50" value="${session.usuarioSistema.bairro}"/></f:field>
			<f:field bean="profissional" property="numero"><input class="buttons" type="hidden" name="numero" id="numero" value="${session.usuarioSistema.numero}"/></f:field>
			<f:field bean="profissional" property="cidade"><input class="buttons" type="hidden" name="cidade" id="cidade" size="50" value="${session.usuarioSistema.cidade}"/></f:field>
			<f:field bean="profissional" property="estado"><input class="buttons" type="hidden" name="estado" id="estado" value="${session.usuarioSistema.estado}"/></f:field>
		    </fieldset>

                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
