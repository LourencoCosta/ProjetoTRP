<!DOCTYPE html> 
<html> 
    <head> 
        <meta name="layout" content="main"/> 
        <title>Simple Chat</title> 
    <asset:javascript src="jquery-2.2.0.min.js"/>
</head> 
<body> 
    <div id="chatMessages"></div> 
    <g:each in="${messages}" var="message">
        <div>
            <span class="nickname">${message.nickname}</span> - <span class="msg">${message.message}</span>
        </div>
    </g:each>
</body> 
</html>