package projetotrp

class RedirectChatTagLib {
    def redirectChatTagLib = {
	redirect([controller:"chat", action:"retrieveLatestMessages"])
	
    }
}
