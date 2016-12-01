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

	    function setTextHistori() {
	    document.getElementById("historys").value =  document.getElementById("historys").value + "\n"+document.getElementById("chat").value;
	    document.getElementById("chat").value ="";
	    document.getElementById("historys").scrollTop = document.getElementById("historys").scrollHeight;
            }

            $(document).ready(function(){
            });

            function enviaMensagem(){
	    $.ajax({
	    method: "POST",
                            url: '${g.createLink( controller:'chat', action:'enviarMensagem')}',
	    data: {},
	    success: function (data){
	    $("#retornoTeste").html(data);
	    }
	    });

            }

	</script>
    </head>
    <body>

	<div class="form"  align="center" >
	    History:<br/><textarea id="historys" name="History" form="usrform" readonly></textarea><br/>
	</div>


	<g:form controller="chat" action="escreve" method="post" >
	    <textarea id="chat" name="sendChat" disable="true" enable="false"></textarea></br>
	    <input class="buttons" align="center" type="submit" value="Enviar" id="sendButton" name="Enviar" "/>
	</g:form>
	<input type="submit" name="testess" value="CHAMACONTROLER" onclick="enviaMensagem()"/>

	<div id="retornoTeste"></div>

    </body>
</html>













