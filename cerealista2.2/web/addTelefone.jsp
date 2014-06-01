<%@include file="tagLib.jsp" %>

<f:view>
    <c:if test="${TelefoneFaces.selectedTelefone.telNumero == null}">
        <b id="titulo">Cadastro de Telefones!</b>
    </c:if>
    <c:if test="${TelefoneFaces.selectedTelefone.telNumero != null}">
        <b id="titulo">Atualizar Telefone!</b>
    </c:if>
    <div>
        <h:form>
            <h:messages/>
            Pessoa: <h:inputText disabled="true" value="#{TelefoneFaces.selectedTelefone.pesCodigo}"/>
            Telefone:<h:selectOneMenu value="#{TelefoneFaces.selectedTelefone.tipCodigo}">
                <f:selectItems value="#{TipoTelefoneFaces.tipoTelefones}"/>
                <f:converter converterId="TipoTelefoneConverter"/>
            </h:selectOneMenu> <br/><br/>
            Nome do Contato:<h:inputText id="contato" maxlength="30" requiredMessage="Informa o contato" value="#{TelefoneFaces.selectedTelefone.telContato}"/>
            <b id="obrigatorio"><h:message for="contato"/></b>
            Número:<h:inputText id="numero" required="true" maxlength="20" onkeypress="formatar(this,'##-####-####-##')" requiredMessage="Informe o número do telefone" value="#{TelefoneFaces.selectedTelefone.telNumero}"/>
            <b id="obrigatorio"><h:message for="numero"/></b> <br/><br/>

            <h:commandButton action="#{TelefoneFaces.chamaTelefone}" value="Cancelar" immediate="true"/>
            <h:commandButton action="#{TelefoneFaces.finishAddTelefone}" value="Salvar"/>
        </h:form>
    </div>
</f:view>
