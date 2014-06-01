
<%@include file="tagLib.jsp" %>

<script type="text/javascript">
    function minimo(){
        texto = document.getElementById("form:senha").value;
        tam = texto.length;
        if( tam < 6 || tam > 10){
            alert("A senha deve conter de 6 a 20 digitos!");
            document.getElementById("form:senha").value = "";
            document.getElementById("form:senha").focus();
        }
    }
</script>
<f:view>
    <h:form id="form">
        <c:if test="${UsuarioFaces.atu == 1}">
            <c:if test="${UsuarioFaces.selectedUsuario.usuUsuario == null}">
                <b id="titulo">Cadastro de Usuários!</b>
            </c:if>
            <c:if test="${UsuarioFaces.selectedUsuario.usuUsuario != null}">
                <b id="titulo">Atualizar Usuário!</b>
            </c:if>
            <div>

                Nome:<h:inputText id="nome" required="true" maxlength="40" requiredMessage="Informe o nome!" value="#{UsuarioFaces.selectedUsuario.usuNome}"/> <br/>
                <h:message for="nome"/><br/>
                Usuário:<h:inputText id="usuario" required="true" maxlength="20" requiredMessage="Informe o usuário!" value="#{UsuarioFaces.selectedUsuario.usuUsuario}"/>
                <h:message for="usuario"/>
                Senha:<h:inputText id="senha" onblur="minimo()" maxlength="20" required="true" requiredMessage="Informe a senha (6 a 20 digitos)!" value="#{UsuarioFaces.selectedUsuario.usuSenha}">
                    <f:validateLength minimum="6" maximum="20"/>
                </h:inputText> <br/>
                <b id="obrigatorio"> <h:message for="senha"/> </b> <br/>
                Status:<h:selectOneMenu value="#{UsuarioFaces.selectedUsuario.usuStatus}">
                    <f:selectItems value="#{UsuarioFaces.status}"/>
                </h:selectOneMenu> <br/><br/>
                <h:commandButton action="#{UsuarioFaces.chamaUsuario}" immediate="true" value="Cancelar"/>
                <h:commandButton action="#{UsuarioFaces.finshAddUser}" value="salvar"/>
            </div>
        </c:if>
        <c:if test="${UsuarioFaces.atu != 1}">
            <h:commandButton action="#{UsuarioFaces.chamaUsuario}" immediate="true" value="Voltar"/>
            <b style="font-size:150%;">Só o Usuário administrador pode cadastrar novos usuários!</b>
        </c:if>
    </h:form>
</f:view>