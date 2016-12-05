<div>
    <table>
	<thead > <p align="center">Foram encontrados ${profissionais.size()} resultados para sua Busca</p></thead>
	<g:each in = "${profissionais}" var="profissional">
	    <tr>
		<td>
		    <b>Nome:</b> ${profissional[1]} <br>
		    <b>Media das Avaliacoes:</b> ${profissional[2]} <br>
		    <b>Preco Media da Hora:</b> ${profissional[3]} <br>
		    <div id="detalheProfissional${profissional[0]}"></div>
		    <hr>
		</td>
		<td>
		    <div id="botaoNegociar+${profissional[0]}">
			<g:form controller="chat" action="criaMensagem">
			    <input type="hidden" name="profissional" value="${profissional[0]}"/>
			    <g:actionSubmit value="Negociar" action="criaMensagem" class="buttons"/>
			</g:form>
		    </div>
		    <!--<div id="botaoNegociar+${profissional[0]}"> <input align="center" class="buttons" value="Negociar"type="button" name="iniciarChat${profissional[0]}" onclick="chatNegociacao(${profissional[0]})"/><br/></div>-->
		    <div id="botaoDetalhe+${profissional[0]}"> <input align="center" class="buttons" value="Ver detalhes" type="button" name="verDetalhes${profissional[0]}" onclick="trazerDetalhesProfissional(${profissional[0]})"/><br/></div>
		</td>    
	    </tr>
	</g:each>
    </table>
</div>
