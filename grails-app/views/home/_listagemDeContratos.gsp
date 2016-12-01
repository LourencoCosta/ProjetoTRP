<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<table>
    <thead > Contratos</thead>
    <td><b>Data de Emissão </b> </td>
    <td><b>Nome do Profissional </b> </td>
    <td><b>Nome do Contratante </b> </td>

        <g:each in = "${contratos}" var="contrato">
            <tr>
                    <td>${contrato.dataEmissao}</td>
		    <td>${contrato.profissional.nome}</td>
		    <td>${contrato.contratante.nome}</td>

            </tr>
        </g:each>
	    
</table>
<p align="center">Foram encontrados ${contratos.size} contratos vinculados a você</p>