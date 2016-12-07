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
            <h1>Seus dados</h1>
            <g:if test="${flash.message}">
		<div class="message" role="status">${flash.message}</div>
            </g:if>

	    <div id="apresentacao">
		<div id="nome" ><b>Nome Completo:</b>  ${this.usuarioSistema.nome}</div>
		<div id="email" ><b>Email:</b>  ${this.usuarioSistema.email}</div>
		<div id="cpf" ><b>CPF:</b>  ${this.usuarioSistema.cpf}</div>
		<div id="login" ><b>Login:</b>  ${this.usuarioSistema.login}</div>
		<div id="senha" ><b>Senha:</b> <input type="password" value="XXXXXX" readonly/></div>
		<div id="cep"> <b>CEP: </b>${this.usuarioSistema.cep}</div>
		<div id="rua"> <b>Rua: </b>${this.usuarioSistema.rua}</div>
		<div id="cidade"><b>Cidade: </b>${this.usuarioSistema.cidade}</div>
		<div id="estado"><b>Estado: </b>${this.usuarioSistema.estado}</div>
		<div id="numero"><b>Numero: </b>${this.usuarioSistema.numero}</div>
		<div id="bairro"><b>Bairro: </b>${this.usuarioSistema.bairro}</div>
	    </div>
	    <hr>
	    <div align="center">
		<input class="buttons" align="center" type="submit" value="Editar Conta" onclick="editarUsuarioSistema()"/>
		<input class="buttons" align="center" class="delete" type="submit" value="Excluir Conta" onclick="exluirRegistro()"/>
		<input class="buttons" align="center" class="criarPerfilProfissional" type="submit" value="Perfil Profissional" onclick="carregarPerfilProfissional()"/></div>
        </div>
    </body>
</html>