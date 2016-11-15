<!DOCTYPE html>
<html>
    <html>
	<head>
	    <meta name="layout" content="maintrp"/>
	    <title>TRP</title>
	<asset:link rel="icon" href="logo_2_1.svg" type="image/x-ico" />
	<asset:javascript src="jquery" />
    <asset:javascript src="spring-websocket" />

	<script defer type="text/javascript">

	 function setTextHistori() {
        document.getElementById("historys").value =  document.getElementById("historys").value + "\n"+document.getElementById("chat").value;
        document.getElementById("chat").value ="";
        document.getElementById("historys").scrollTop = document.getElementById("historys").scrollHeight;
     }

	 //Create a new SockJS socket - this is what connects to the server
	 $(function() {
         //(preferably using WebSockets).
         var socket = new SockJS("${createLink(uri: '/stomp')}");
         //Build a Stomp client to send messages over the socket we built.
         var client = Stomp.over(socket);
         //Track the subscription so we can unsubscribe later.
         var quoteSubscription;



                         //When the user clicks the 'subscribe' button...
                         $("#startButton").click(function(){
                             //Toggle button states
                             $("#stopButton").prop('disabled', false);
                             $("#startButton").prop('disabled', true);
                             //Initiate a subscription to stockQuote messages.
                             quoteSubscription = client.subscribe("/topic/stockQuote", function(message) {
                                 var quote = JSON.parse(message.body).content;
                                 $("#symbol").text(quote.symbol);
                                 $("#price").text(quote.price.toFixed(2));
                                 $("#timestamp").text(new Date(quote.timestamp).toLocaleString());
                             });
                             //Since the user could subscribe between quotes put up 'waiting'
                             //to indicate the subscription succeeded and we're just waiting for the
                             //first message.
                             $("#symbol").text('Waiting...');
                         });

                         //When the user clicks the 'unsubscribe' button...
                         $("#stopButton").click(function(){
                             //Toggle button states
                             $("#stopButton").prop('disabled', true);
                             $("#startButton").prop('disabled', false);
                             //Unsubscribe so we don't get any more messages
                             quoteSubscription.unsubscribe();
                             quoteSubscription = null;
                             $("#symbol").text('Unsubscribed');
                             $("#price").text('');
                             $("#timestamp").text('');
                         });
         //Have SockJS connect to the server.
         client.connect({}, function() {
            //Subscribe to the 'chat' topic and define a function that is executed
            //anytime a message is published to that topic by the server or another client.
            client.subscribe("/topic/chat", function(message) {
                console.log(message)
                   var chatMsg = JSON.parse(JSON.parse(message.body))
                   var time = '<strong>' + new Date(chatMsg.timestamp).toLocaleTimeString() + '</strong>'
                        $("#chatDiv").append(time + ': ' + chatMsg.message + "<br/>");
                             });
          });
	     //When the user sends a chat message publish it to the chat topic
        $("#sendButton").click(function() {
            client.send("/app/chat", {}, JSON.stringify($("#chatMessage").val()));
            });
             });
	</script>
    </head>
    <body>

	<div class="form"  align="center" >
	    History:<br/><textarea id="historys" name="History" form="usrform" readonly></textarea><br/>
	    
	    <div class="form"  align="center" >
		<textarea id="chat" name="comment" form="usrform" disable="true" enable="false"></textarea></br>
		<li class="buttons" aling="center">
		    <button id="sendButton" type="button" name="Enviar" onclick="setTextHistori()">Click</button>
		</li>
	    </div>
	</div>
    </body>
</html>