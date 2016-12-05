<g:each in = "${profissionalDetalhe}" var="detalhe">
<div>${detalhe[0]}</div>
<div>${detalhe[2]}</div>
<div id="botaoDetalheExibindo"> <input align="center" class="buttons" value="Ocultar Detalhes" type="button" name="verDetalhes${detalhe[0]}" onclick="ocultarDetalhesProfissional(${detalhe[0]})"/><br/></div>
</g:each>