
<%@include file="tagLib.jsp" %>
<f:view>
    <c:if test="${ContaFaces.selectedConta.conNumeroConta == null}">
        <b id="titulo">Cadastro de Contas de Pessoas!</b>
    </c:if>
    <c:if test="${ContaFaces.selectedConta.conNumeroConta != null}">
        <b id="titulo">Atualizar Conta da Pessoa!</b>
    </c:if>
    <h:form>
        <div>
            Pessoa: <h:inputText disabled="true" value="#{ContaFaces.selectedConta.pesCodigo}"/>

            Nome Conta:<h:inputText id="nome" required="true" maxlength="40" requiredMessage="Informe o nome da conta" value="#{ContaFaces.selectedConta.conNomeDeposito}"/>
            <b id="obrigatorio"><h:message for="nome"/></b>
            <br/> <br/>
            Banco:<h:selectOneMenu value="#{ContaFaces.selectedConta.banCodigo}">
                <f:selectItems value="#{BancoFaces.bancos}"/>
                <f:converter converterId="BancoConverter"/>
            </h:selectOneMenu>
            Número Conta:<h:inputText id="numero" size="10" maxlength="10" required="true" requiredMessage="Informe o número da conta" value="#{ContaFaces.selectedConta.conNumeroConta}"/>
            <b id="obrigatorio"><h:message for="numero"/></b>

            Agência:<h:inputText id="agencia" required="true" size="7" maxlength="7" requiredMessage="Informe a agência" value="#{ContaFaces.selectedConta.conAgencia}"/>
            <b id="obrigatorio"><h:message for="agencia"/></b>
            <br/> <br/>
            Número do Banco:<h:inputText id="banco" required="false" maxlength="6" size="6" requiredMessage="Informe o banco" value="#{ContaFaces.selectedConta.conNumeroBanco}"/>
            <b id="obrigatorio"><h:message for="banco"/></b>

            Operação:<h:inputText id="operacao" required="true" maxlength="20" size="20" requiredMessage="Informe a operação" value="#{ContaFaces.selectedConta.conOperacao}"/>
            <b id="obrigatorio"><h:message for="operacao"/></b>
            <br/> <br/>
            <h:commandButton action="#{ContaFaces.chamaConta}" value="Cancelar" immediate="true"/>
            <h:commandButton action="#{ContaFaces.finishAddConta}" value="Salvar"/>
        </div>
    </h:form>
</f:view>
