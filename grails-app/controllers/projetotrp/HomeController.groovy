package projetotrp

import grails.converters.JSON

class HomeController {

    def index() {
        if (session.usuarioSistema) {
            render(view: "/home/usuario/autenticado/homeUsuario.gsp")
        } else {
            render(view: "/home/usuario/naoAutenticado/index.gsp")
        }
    }

    def homeLogin() {
        if (!session.usuarioSistema) {
            render(view: "/logintrp.gsp")
        } else {
            render(view: "/home/usuario/autenticado/homeusuario.gsp")
        }
    }

    def listagemDeContratos() {
        def contratos
        if (session.usuarioSistema) {
            Integer id = session.usuarioSistema.id;
            def usuarioSistema = UsuarioSistema.get(id)
            String sql = "select c from Contrato c where c.profissional.id =" + "${id} " + "or " + "c.contratante.id =" + " ${id}"
            contratos = Contrato.executeQuery(sql)
            render(template: "listagemDeContratos.gsp", model: [contratos: contratos])
        }else{
	    redirect (uri:"/logintrp")
	}
    }

    def listagemDeProfissionais() {
        def profissionais = [:]
        if (session.usuarioSistema) {
            Integer id = session.usuarioSistema.id;
            def usuarioSistema = UsuarioSistema.get(id)
            String sql = """select u.id, u.nome, p.mediaDasAvaliacoes, p.precoMedioHora from Profissional p, UsuarioSistema u, CategoriaProfissional cp, Categoria c
                          where u.id = p.id and p.id = cp.profissional.id and cp.categoria.id = c.id and c.id = 2"""
            profissionais = Profissional.executeQuery(sql)
            render(template: "listagemProfissionais.gsp", model: [profissionais: profissionais])
        }else{
	    redirect (uri:"/logintrp")
	}
    }

    def listagemCategorias() {
	if (session.usuarioSistema) {
	    def categorias = [:]
	    categorias = Categoria.executeQuery("select c.nome from Categoria c");
	    render categorias
	}else{
	    redirect (uri:"/logintrp")
	}
    }

    def detalheProfissional() {
        if (session.usuarioSistema) {
            Integer id = session.usuarioSistema.id
            def usuarioSistema = UsuarioSistema.get(id)
            String sql = """select u.id, u.endereco, p.descricao from Profissional p, UsuarioSistema u, CategoriaProfissional cp, Categoria c
                          where u.id = p.id and p.id = cp.profissional.id and cp.categoria.id = c.id and c.id = 2 and p.id = ${
                params.id
            }"""
            def profissionalDetalhe = Profissional.executeQuery(sql)
            render(template: "listagemDetalheProfissional.gsp", model: [profissionalDetalhe: profissionalDetalhe])
        }else{
	    redirect (uri:"/logintrp")
	}
    }

    def listarMenssagens() {
        if (session.usuarioSistema) {
            def id = session.usuarioSistema.id
            String sql = "select m from Menssagem m where m.profissional.id = " + id + " or m.contratante = " + id
            def menssagens = Menssagem.executeQuery(sql)
            render(template: "listagemDeMenssagens.gsp", model: [menssagens: menssagens])
        }else{
	    redirect (uri:"/logintrp")
	}
    }

    def criarContrato() {
        if (session.usuarioSistema) {
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

            contrato.save(flush: true, failOnError: true)
        }else{
	    redirect (uri:"/logintrp")
	}
    }

    def carregarContrato() {
	if (session.usuarioSistema) {
	    def messagem = Menssagem.get(params.id)
	    render([template: gerarContrato, model: [menssagem: menssagem]])
	}else{
	    redirect (uri:"/logintrp")
	}
    }

    def contratarServico() {
	if (session.usuarioSistema){

	}else{
	    redirect (uri:"/logintrp")
	}
    }
    
    def criarPerfilProfissional(){
	if (session.usuarioSistema){
	    def usuarioSistema = UsuarioSistema.get(params.idUsuarioSistema)
	    def profissional = new Profissional(["id":"usuarioSistema.id"])
	    profissional.setDescricao(params.descricao)
	    profissional.setMediaDasAvaliacoes(0.0)
	    profissional.setPrecoMedioHora(params.precoMedioHora)
	
	    def menssagem = [:]
	    menssagem["sucesso"]= profissional
	    render menssagem as JSON
	}else{
	    redirect (uri:"/logintrp")
	}
    }
    
    def carregarPerfilProfissional(){
	if (session.usuarioSistema){
	    
	    def profissional = Profisisonal.get(sessioin.usuarioSistema.id)
	    
	    if (profissional != null){
		def sqlCategoria = """Select c.nome from Categorias c, CategoriaProfissional cp Profissional p\n\
			    where c.id = cp.categoria.id and p.id = cp.profissional.id"""
		def categoria = Categoria.executeQuery(sqlCategoria)
		
		def sqlCursosProfissional = """Select cup from CursosProfissional cup, Profissional p \n\
					    where cup.profissional.id = p.id"""
		def cursoDoProfissional = CursosDoProfissional.executeQuery(sqlCursosProfissional)
		render ([template:"profissionalExistente", model:[profissional: profissinal, categoria:categoria, cursoDoProfissional:cursoDoProfissional]])
	    }else{
		render([template:"profissionalACriar"])
	    }
	    
	}else{
	    redirect (uri:"/logintrp")
	}
    }
}
