<table>
    <thead> Nome usuario</thead>
        <g:each in = "${usuarioSistema}" var="usuario">
            <tr>
                    <td>${usuario.nome}</td>
            </tr>
        </g:each>
</table>