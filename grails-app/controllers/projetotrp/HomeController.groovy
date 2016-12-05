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
	    contratos = Contrato.executeQuery(sql)
	    render (template:"listagemDeContratos.gsp", model:[contratos:contratos])
	}
    }
	
    def listagemDeProfissionais(){
	def profissionais = [:]
	if (session.usuarioSistema){
	    Integer id = session.usuarioSistema.id;
	    def usuarioSistema = UsuarioSistema.get(id)
	    String sql = """select u.id, u.nome, p.mediaDasAvaliacoes, p.precoMedioHora from Profissional p, UsuarioSistema u, CategoriaProfissional cp, Categoria c
                          where u.id = p.id and p.id = cp.profissional.id and cp.categoria.id = c.id and c.id = 2"""
	    profissionais = Profissional.executeQuery(sql)
	    render (template:"listagemProfissionais.gsp", model:[profissionais:profissionais])
	}
    }
	
    def listagemCategorias(){
	def categorias = [:]
	categorias = Categoria.executeQuery("select c.nome from Categoria c");
	render categorias 
    }
	
    def detalheprofissional(){
	if(session.usuarioSistema){
	    Integer id = session.usuarioSistema.id
	    def usuarioSistema = UsuarioSistema.get(id)
	    String sql = """select u.id, u.endereco, p.descricao from Profissional p, UsuarioSistema u, CategoriaProfissional cp, Categoria c
                          where u.id = p.id and p.id = cp.profissional.id and cp.categoria.id = c.id and c.id = 2 and p.id = ${params.id}"""
	    def profissionalDetalhe = Profissional.executeQuery(sql)
	    render (template:"listagemDetalheProfissional.gsp", model:[profissionalDetalhe:profissionalDetalhe])
	}
    }
    
    def listarMenssagens (){
	if(session.usuarioSistema){
	    def id = session.usuarioSistema.id
	    String sql = "select m from Menssagem m where m.profissional.id = "+id+ " or m.contratante = " + id 
	    def menssagens = Menssagem.executeQuery(sql)
	    render (template:"listagemDeMenssagens.gsp", model:[menssagens:menssagens])
	}
    }
    def criarContrato (){
	if(session.usuarioSistema){
	    def messagem = Menssagem.get(params.idMenssagem)
	    
	    def idContratante = menssagem.contratante.id 
	    def contratante = UsuarioSistema.get(idContratante)
	    
	    def idProfissional = menssagem.contratante.id
	    def profissional = UsuarioSistema.get(idProfissional)
	    
	    def contrato = new Contrato()
	    
	    contrato.setDataEmissao(new Date())
	    contrato.setProfissional(profissional)
	    contato.setContratante(contratante)
	    contrato.setTermos(params.termos)
	    
	    contrato.save (flush:true, failOnError: true)
	    
	    
	}
    }
}
