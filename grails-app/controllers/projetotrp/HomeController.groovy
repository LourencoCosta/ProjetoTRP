package projetotrp
import grails.converters.JSON
import Enuns.*

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
	
    def detalheProfissional(){
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
    
    def carregarContrato(){
	def messagem = Menssagem.get(params.id)
	render ([template:gerarContrato, model:[menssagem:menssagem]])
    }
    
    def contratarServico(){
	def menssagem = Menssagem.get(params.idMenssagem)
	
	def profissional = usuarioSistema.get(menssagem.profissional.id)
	
	def contratante = usuarioSistema.get(menssagem.usuarioSistema.id)
        
	def contrato = new Contrato()
	contrato.setDataEmissao(new Date())
	contrato.setContratante(contratante)
	contrato.setProfissional(profissional)
	contrato.setTermos(menssagem.texto + "\nTermos adicionais .../n"+ "Assinatura TRP profissional " + profissional.getAssinaturaTrp() +"\n" + "Assinatura Contratante " + usuarioSistema.getAssinaturaTrp())
	println contrato
	
	def servico = new Servico()
	servico.setProfissionalOperante(contrato.profissional)
	servico.setNotaQualidadeServico(0.0)
	servico.setComentarios("Serviço ainda nao avaliado")
	servico.setStatusServico("EM ANDAMENTO")
	servico.setContrato(contrato)
	println servico
	
	def pagamento = new Pagamento()
	pagamento.setStatusPagamento("Pago")
	pagamento.setValor(Float.parseFloat(params.idPagamento))
	pagamento.setServico(servico)
	println pagamento
	
	render contrato
    }
}
