<div>
    <table>
	<thead > <p align="center">Foram encontrados ${profissionais.size()} resultados para sua Busca</p></thead>
	<g:each in = "${profissionais}" var="profissional">
	    <tr>
		<td>
		    <b>Nome:</b> ${profissional[0]} <br>
		    <b>Media das Avaliacoes:</b> "${profissional[2]} <br>
		    <b>Preco Media da Hora:</b> ${profissional[3]} <br>
		    <b>Descricao:</b> ${profissional[1]} <br>
		</td>
		<td>
		    <input align="center" class="buttons" value="Negociar"type="button" name="iniciarChat${profissional[0]}"/><br/>
		    <input align="center" class="buttons" value="Ver detalhes" type="button" name="verDetalhes${profissional[0]}"/><br/>
		</td>    
	    </tr>
	</g:each>
    </table>
</div>
