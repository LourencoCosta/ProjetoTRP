<!-- Declaração do formulário -->  
<form method="post" target="pagseguro" action="https://pagseguro.uol.com.br/v2/checkout/payment.html">  
          
        <!-- Campos obrigatórios -->  
        <input name="receiverEmail" type="hidden" value="therightprofessional@gmail.com.br">  
        <input name="currency" type="hidden" value="BRL">  
  
        <!-- Itens do pagamento (ao menos um item é obrigatório) -->  
        <input name="itemId1" type="hidden" value="0001">  
        <input name="itemDescription1" type="hidden" value="Servico">  
        <input name="itemAmount1" type="hidden" value=${pagamento.valor}>  
        <input name="itemQuantity1" type="hidden" value="1">  
        <input name="itemWeight1" type="hidden" value="1">  
        
        <!-- Código de referência do pagamento no seu sistema (opcional) -->  
        <input name="reference" type="hidden" value="REF1234">  
          
        <!-- submit do form (obrigatório) -->  
        <input alt="Pague com PagSeguro" name="submit"  type="image" src="https://p.simg.uol.com.br/out/pagseguro/i/botoes/pagamentos/120x53-pagar.gif"/>  
</form>  
