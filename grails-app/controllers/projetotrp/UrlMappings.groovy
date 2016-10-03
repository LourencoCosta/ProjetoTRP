package projetotrp

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        
        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
        
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
