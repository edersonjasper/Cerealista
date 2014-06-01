<%@include file="tagLib.jsp" %>

<f:view>
    <c:if test="${PagamentoOrdemFaces.selectedPagamentoOrdem.pagOrdValor == null}">
        <b id="titulo">Cadastro de Pagamento de Ordens!</b>
    </c:if>
    <c:if test="${PagamentoOrdemFaces.selectedPagamentoOrdem.pagOrdValor != null}">
        <b id="titulo">Atualizar Pagamento de Ordem!</b>
    </c:if>
    <div>
        <h:form>
            Ordem cód.: <h:inputText size="20" disabled="true" value="#{PagamentoOrdemFaces.selectedPagamentoOrdem.ordCodigo.pesCatCodigo}"/>
            Usuário:<h:selectOneMenu value="#{PagamentoOrdemFaces.selectedPagamentoOrdem.usuCodigo}">
                <f:selectItems value="#{UsuarioFaces.usuarios}"/>
                <f:converter converterId="UsuarioConverter"/>
            </h:selectOneMenu>
            <br/> <br/>
            forma Pagto:<h:selectOneMenu value="#{PagamentoOrdemFaces.selectedPagamentoOrdem.forPagCodigo}">
                <f:selectItems value="#{FormaPagamentoFaces.formaPagamento}"/>
                <f:converter converterId="FormaPagamentoConverter"/>
            </h:selectOneMenu>
            Data: <h:inputText disabled="true" value="#{PagamentoOrdemFaces.selectedPagamentoOrdem.pagOrdData}">
                <f:convertDateTime pattern="dd/MM/yyyy"/>
            </h:inputText>

            Valor: <h:inputText id="valor" required="true" size="8" maxlength="10" requiredMessage="Informe o valor" value="#{PagamentoOrdemFaces.selectedPagamentoOrdem.pagOrdValor}">
                <f:convertNumber pattern="#,###,##0.00"/>
            </h:inputText>
            <b id="obrigatorio"><h:message for="valor"/></b>
            <br/> <br/>
            <h:commandButton action="#{PagamentoOrdemFaces.chamaPagamentoOrdem}" value="Cancelar" immediate="true"/>
            <h:commandButton action="#{PagamentoOrdemFaces.finishAddPagamentoOrdem}" value="Salvar"/>
        </h:form>
    </div>
</f:view>
