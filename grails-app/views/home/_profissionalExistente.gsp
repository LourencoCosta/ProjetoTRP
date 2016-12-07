<script>
    function adicionarCursos(id){
    $.ajax({
    method: "POST",
    url: '${g.createLink( controller:'cursosDoProfissional', action:'adicionarCursos')}',
    data: {"id":id},
    success: function (data){
    $("#todoConteudo").html(data);
    }
    });
    }

    function excluirCursos(id){
    $.ajax({
    method: "POST",
    url: '${g.createLink( controller:'cursosDoProfissional', action:'excluirCursos')}',
    data: {"id":id},
    success: function (data){
    $("#todoConteudo").html(data);
    }
    });
    }

    function adicionarCategorias(id){
    $.ajax({
    method: "POST",
    url: '${g.createLink( controller:'categoriaProfissional', action:'adicionarCategoria')}',
    data: {"id":id},
    success: function (data){
    $("#todoConteudo").html(data);
    }
    });
    }
</script>
<g:if test="${profissional != null}">
    <g:select name="categoria.id"
    from="${categoria.list()}"
    value="${categoria?.nome}"
	optionKey="id" />
    <<input type="submit" class="buttons" name="adicionarCategoria" value="Inserir Categoria" onclick="adicionarCategoria()" />
    <div>Categorias:</div><div id="categorias"></div>

    <div>Nome do Curso:</div><input type="text" name="nomeCurso"/>
    <div>Nome da Instituicao:</div><input type="text" name="nomeInstiuicao"/>
    <g:datePicker name="dateInicio" value="${new Date()}"
	noSelection="['':'-Choose-']"/>
    <g:datePicker name="dateFim" value="${new Date()}"
	noSelection="['':'-Choose-']"/>
    <<input type="submit" class="buttons" name="adicionarCursos" value="Adicionar Cursos" onclick="adicionarCursos()" />
    <div>Categorias:</div><div id="categorias"></div>
</g:if>
<g:else>

</g:else>