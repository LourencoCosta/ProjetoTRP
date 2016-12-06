
<input type="text" class="buttons" name="nomeUsuario" id="nomeUsuario" value="${usuarioSistema.nome}" disabled="true"/>
<input type="text" class="buttons" name="emailUsuario" id="emailUsuario" value="${usuarioSistema.email}" disabled="true"/>
<input type="text" class="buttons" name="cpfUsuario" id="cpfUsuario" value="${usuarioSistema.cpf}" disabled="true"/>
<input type="text" class="buttons" name="cepUsuario" id="cepUsuario" value="${usuarioSistema.cep}" disabled="true"/>
<input type="text" class="buttons" name="ruaUsuario" id="ruaUsuario" value="${usuarioSistema.rua}" disabled="true"/>
<input type="text" class="buttons" name="bairroUsuario" id="bairroUsuario" value="${usuarioSistema.bairro}" disabled="true"/>
<input type="text" class="buttons" name="cidadeUsuario" id="cidadeUsuario" value="${usuarioSistema.cidade}" disabled="true"/>
<input type="text" class="buttons" name="estadoUsuario" id="estadoUsuario" value="${usuarioSistema.estado}" disabled="true"/>
<input type="text" class="buttons" name="numeroUsuario" id="numeroUsuario" value="${usuarioSistema.numero}" disabled="true"/>
<input type="text" class="buttons" name="loginUsuario" id="loginUsuario" value="${usuarioSistema.login}" disabled="true"/>
<input type="password" class="buttons" name="senhaUsuario" id="senhaUsuario" value="${usuarioSistema.senha}" disabled="true"/>    
<hr>    

<h1 align="center"><b>Cadastro de Profissional</b></h1>   
<input type="text" class="buttons" name="descricaoProfissional" id="descricaoProfissional" value="${profissional.descricao}" disabled="true"/>
<input type="text" class="buttons" name="precoMedioHoraProfissional" id="precoMedioHoraProfissional" value="${profissional.precoMedioHora}" disabled="true"/>
<input type="password" class="buttons" name="mediaDasAvaliacoesProfissional" id="mediaDasAvaliacoesProfissional" value="${usuarioSistema.mediaDasAvaliacoes}" disabled="true"/>    
 
    String descricao
    Integer mediaDasAvaliacoes
    Float precoMedioHora
	
    //para Profissional
    static hasMany = [cursos: CursosDoProfissional, midia:Midia]