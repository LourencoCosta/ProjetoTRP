<!DOCTYPE html>
<html>
    <head>
        <g:set var="entityName" value="${message(code: 'usuarioSistema.label', default: 'UsuarioSistema')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-usuarioSistema" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
        </div>
        <div id="show-usuarioSistema" class="content scaffold-show" role="main">
            <h1Seus dados</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
	     Nome: <f:display bean="usuarioSistema" property="nome"/>
            <f:display bean="usuarioSistema" property="rua"/>
	    <input class="delete" type="submit" value="Editar" onclick="editarRegistro()"/>
            <g:form resource="${this.usuarioSistema}" method="DELETE">
               
		<fieldset class="buttons">
		    
                    <g:link class="edit" action="edit" resource="${this.usuarioSistema}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
