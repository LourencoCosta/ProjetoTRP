package projetotrp

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {

            }

        }

        "/"(controller: "home", action: "index")
        "/logintrp" (controller: "home", action: "homeLogin")
        "500"(view:'/error')
        "404"(view:'/notFound')
        "/indexchat" (view:'/chat/index')
        "/homeController/index"(controller: "home", action: "index")
        "/homeController"(controller: "home", action: "index")

        
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

        "/teste" (view:"/teste")
        
        "/autenticacao"(view: "/logintrp")
       
    }
}
