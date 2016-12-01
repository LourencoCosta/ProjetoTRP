<g:form action="save">
                <fieldset class="form">
                    
		    <div class="buttons">
			<f:field bean="usuarioSistema" property="nome"/>
		    </div>
		    <div class="buttons">
			<f:field bean="usuarioSistema" property="email"/>
		    </div>
		    <div class="buttons">
			<f:field bean="usuarioSistema" property="cpf"/>
		    </div>
		    <div class="buttons">
			<f:field bean="usuarioSistema" property="login"/>
		    </div>
		    <div class="buttons">
			<f:field bean="usuarioSistema" property="foto"/>
		    </div>
		    <div class="buttons">
			<f:field bean="usuarioSistema" property="senha"/>
		    </div>

                    <f:field bean="usuarioSistema" label=" " property="termoDeUsuAceito"><a href="#"><input type="checkbox" name="teste" id="teste"/>Li e Aceito com os termos de uso</a></f:field>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>