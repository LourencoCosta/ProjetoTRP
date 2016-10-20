package projetotrp

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                
            }
        }
        
        "/"(view:"/index")
        "/logintrp" (view:"/logintrp")
        "500"(view:'/error')
        "404"(view:'/notFound')
        "/indexchat" (view:'/chat/index')
        
        
        
//        //verificar a necessidade do uso disso aqui
//        "/login/Experimente" {
//            controller = "login"
//            action = "index"
//        }
//        
//       "/login/teste" {
//            controller = "login"
//            action = "test"
//        }
        
        "/autenticacao"(view: "/logintrp")
       
    }
}
