<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<table>
    <thead><h1 align="center"> <b>Contratos</b></h1></thead>
    <g:each in = "${contratos}" var="contrato">
    <tr>
	<td>
	    <b>Data de Emissão: </b>${contrato.dataEmissao}<br>
	    <b>Nome do Profissional: </b> ${contrato.profissional.nome}<br>
	    <b>Nome do Contratante: </b>${contrato.contratante.nome}<br>
	    <b>Termos do Contrato: </b><br>
	    <div id="termosContrato"></div>
	    <b>Estado do Servico: </b><br>
	    <div id="estadoDoServico"></div>
	    <b>Pagamento: </b><br>
	    <div id="pagamento"></div>

	</td>
	<td>
	    <div id="botaoDetalhe+${contrato.dataEmissao}"> <input align="center" class="buttons" value="Termos do Contrato" type="button" name="verDetalhes${contrato.dataEmissao}" onclick="trazerDetalhesProfissional(${contrato.dataEmissao})"/><br/></div>
	    
	    <div id="botaoDetalhe+${contrato.dataEmissao}"> <input align="center" class="buttons" value="Estado do Servico" type="button" name="verDetalhes${contrato.dataEmissao}" onclick="trazerDetalhesProfissional(${contrato.dataEmissao})"/><br/></div>
	    <div id="botaoNegociar+${contrato.dataEmissao}">
		<g:form controller="chat" action="criaMensagem">
		    <input type="hidden" name="profissional" value="${contrato.dataEmissao}"/>
		    <g:actionSubmit value="Consultar Pagamento" action="criaMensagem" class="buttons"/>
		</g:form>
	    </div>
	</td>
    </tr>
    <hr>
</g:each>

</table>
<p align="center">Foram encontrados ${contratos.size} contratos vinculados a você</p>