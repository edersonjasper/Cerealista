<%@include file="tagLib.jsp" %>
<f:view>
    <c:if test="${CaixaFaces.selectedCaixa.caiValorDepositado == null}">
        <b id="titulo">Cadastro de Entradas de Caixa!</b>
    </c:if>
    <c:if test="${CaixaFaces.selectedCaixa.caiValorDepositado != null}">
        <b id="titulo">Atualizar Entrada de Caixa!</b>
    </c:if>
    <div>
        <h:form>
            Valor Depositado: <h:inputText id="valor" maxlength="10" required="true" size="8" requiredMessage="Informe o valor deposiado" value="#{CaixaFaces.selectedCaixa.caiValorDepositado}">
                <f:convertNumber pattern="#,###,##0.000"/>
            </h:inputText>
            <b id="obrigatorio"><h:message for="valor"/></b>
            Cliente:<h:selectOneMenu value="#{CaixaFaces.selectedCaixa.pesCatCodigo}">
                <f:selectItems value="#{PessoaCategoriafaces.pessoaCategoriaClientes}"/>
                <f:converter converterId="PessoaCategoriaConverter"/>
            </h:selectOneMenu>
            Data: <h:inputText size="10" disabled="true" value="#{CaixaFaces.selectedCaixa.caiData}">
                <f:convertDateTime pattern="dd/MM/yyyy"/>
            </h:inputText>
            Usuário: <h:selectOneMenu value="#{CaixaFaces.selectedCaixa.usuCodigo}">
                <f:selectItems value="#{UsuarioFaces.usuarios}"/>
                <f:converter converterId="UsuarioConverter"/>
            </h:selectOneMenu>
            <br/><br/>
            <h:commandButton action="#{CaixaFaces.chamaCaixa}" value="Cancelar" immediate="true"/>
            <h:commandButton action="#{CaixaFaces.finishAddCaixa}" value="Salvar"/>
        </h:form>
    </div>
</f:view>
