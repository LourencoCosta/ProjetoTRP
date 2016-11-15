package projetotrp

import groovy.json.JsonBuilder

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
class ChatController {

    def index() { }
   
    def join(String nickname) {
        if ( nickname.trim() == '' ) {
            redirect(view:'/index')
        } else {
            session.nickname = nickname
            render (view: '/chat/chat')
        }
    }
    def retrieveLatestMessages() {
        def messages = Message.listOrderByDate(order: 'desc', max:10)
        [messages:messages.reverse()]
    }
    def submitMessage(String message) {
        new Message(nickname: session.nickname, message:message).save()
        render "<script>retrieveLatestMessages()</script>"
    }

    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    protected String chat(String chatMsg) {
        /**w
         * Use the awesome Groovy JsonBuilder to convert a dynamically-defined
         * data structure to JSON.
         **/
        def builder = new JsonBuilder()
        builder {
            message(chatMsg)
            timestamp(new Date().getTime())
        }
        builder.toString()
    }
    
    
}
