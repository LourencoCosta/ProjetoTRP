package projetotrp
import grails.converters.JSON

class HomeController {

    def index() {
        if(session.usuarioSistema){
            render (view:"/home/usuario/autenticado/homeusuario.gsp")
        }else{
            render (view:"/home/usuario/naoautenticado/index.gsp")
        }
    }

    def homeLogin(){
        if(!session.usuarioSistema){
            render (view:"/logintrp.gsp")
        }else{
            render (view:"/home/usuario/autenticado/homeusuario.gsp")
        }
    }
    
    def listagemDeContratos(){
	def contratos
	if (session.usuarioSistema){
	    Integer id = session.usuarioSistema.id;
	    def usuarioSistema = UsuarioSistema.get(id)
	    
	    String sql = "select c from Contrato c where c.profissional.id =" + "${id} " + "or " + "c.contratante.id =" + " ${id}"
	    println sql
	    contratos = Contrato.executeQuery(sql)
	    println contratos.toString()
	    render (template:"listagemDeContratos.gsp", model:[contratos:contratos])
	    }
	}
	
       def listagemDeProfissionais(){
	def profissionais = [:]
	if (session.usuarioSistema){
	    Integer id = session.usuarioSistema.id;
	    def usuarioSistema = UsuarioSistema.get(id)
	    
	    String sql = """select u.nome, p.descricao, p.mediaDasAvaliacoes, p.precoMedioHora from Profissional p, UsuarioSistema u, CategoriaProfissional cp, Categoria c
                          where u.id = p.id and p.id = cp.profissional.id and cp.categoria.id = c.id and c.id = 2"""
	    
	    profissionais = Profissional.executeQuery(sql)
	    println profissionais
//	    render profissionais
	    render (template:"listagemProfissionais.gsp", model:[profissionais:profissionais])
	    }
	}
	
    def listagemCategorias(){
	def categorias = [:]
	categorias = Categoria.executeQuery("select c.nome from Categoria c");
	render categorias 
    }
	
    
    
}
