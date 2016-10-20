<!DOCTYPE html> 
<html> 
<head> 
    <meta name="layout" content="main"/> 
    <title>Simple Chat</title> 
    <asset:javascript src="jquery-2.2.0.min.js"/>
</head> 
<body> 
<div id="chatMessages"></div> 
<input type="text" id="messageBox" name="message" onkeypress="messageKeyPress(this,event);"/> 
<div id="temp"></div> 
<script> 
    function messageKeyPress(field,event) { 
        var theCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode; 
        var message = $('#messageBox').val(); 
        if (theCode == 13){ 
            <g:remoteFunction action="submitMessage" params="\'message=\'+message" update="temp"/> 
            $('#messageBox').val(''); 
            return false; 
        } else { 
            return true; 
        } 
    } 
    function retrieveLatestMessages() { 
        <g:remoteFunction action="retrieveLatestMessages" update="chatMessages"/> 
    } 
    function pollMessages() { 
        retrieveLatestMessages(); 
        setTimeout('pollMessages()', 5000); 
    } 
    pollMessages(); 
</script> 
</body> 
</html>