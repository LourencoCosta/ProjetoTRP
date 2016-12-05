<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<table>
    <thead > <p align="center"> Suas Menssagens</p></thead>

    <g:each in = "${menssagens}" var="menssagem">
	<tr>
	    <td>
		<b>Nome do Contratante: </b> ${menssagem.contratante.nome} <br>
		<b>Nome do Profissional: </b> ${menssagem.profissional.nome}<br>
		<b>Conversa: </b> ${menssagem.texto.substring(0, 50)} ...<br>
		<hr>
	    </td>
	    <td>
		<div id="botaoRetomarConversa+${menssagem.id}}">
		    <g:form controller="chat" action="retornarMensagem">
			<input type="hidden" name="menssagemAtual" value="${menssagem.id}"/>
			<g:actionSubmit value="Retomar conversa" action="retornarMensagem" class="buttons"/>
		    </g:form>
		</div>
	    </td> 
	</tr>
    </g:each>

</table>
<p align="center">Foram encontradas ${menssagens.size} conversas vinculadas a você</p>