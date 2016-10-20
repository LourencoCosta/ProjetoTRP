package projetotrp

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
}
