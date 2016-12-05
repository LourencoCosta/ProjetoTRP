<!DOCTYPE html>
<html>
    <html>
	<head>
	    <meta name="layout" content="maintrp"/>
	    <title>TRP</title>
	<asset:link rel="icon" href="logo_2_1.svg" type="image/x-ico" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://stc.sandbox.pagseguro.uol.com.br/pagseguro/api/v2/checkout/pagseguro.lightbox.js">F</script>
	<script defer type="text/javascript">

	    function ajustahistorico() {
	    document.getElementById("historys").scrollTop = document.getElementById("historys").scrollHeight;
            }

            $(document).ready(function(){
	    enviaMensagem(${menssagem.id});
            });

	    function carregarMenssagens(){
	    location.reload();
	    }

            function enviaMensagem(id){
	    var s = document.getElementById("chat").value;

	    $.ajax({
	    method: "POST",
	    url: '${g.createLink( controller:'chat', action:'enviarMensagem')}',
	    data: {"id":id, "menssagem":s},
	    success: function (data){
	    console.log(data)
	    $("textarea#historys").text(data.corpoMenssagem);
	    ajustahistorico();
	    }
	    });
	    document.getElementById("chat").value ="";	
            }

	</script>
    </head>
    <body>
        <div id="todoConteudo">
	    <div id="historia" class="form"  align="center" >
		History:<br/><textarea id="historys" name="history" form="usrform" readonly></textarea><br/>
	    </div>
	    <input type="hidden" name="menssagem" value="${menssagem.id}"/>
	    <textarea id="chat" name="sendChat" disable="true" enable="false"></textarea></br>
	    <input align="center" class="buttons" align="center" type="submit" value="Enviar" id="sendButton" name="Enviar" onclick="enviaMensagem(${menssagem.id})"/>
	</div>
</html> 













