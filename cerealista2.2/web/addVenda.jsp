
<%@include file="tagLib.jsp" %>
<f:view>
    <c:if test="${UsuarioFaces.selectedUsuario.usuUsuario == null}">
        <b id="titulo">Cadastro de Vendas!</b>
    </c:if>
    <c:if test="${UsuarioFaces.selectedUsuario.usuUsuario != null}">
        <b id="titulo">Atualizar Venda!</b>
    </c:if>
    <div>
        <h:form>
            <h:messages/>
            <%--c:if test="${VendaFaces.selectedVenda.venFechada == 'A'}"--%>

            Cliente: <h:selectOneMenu value="#{VendaFaces.selectedVenda.pesCatCodigo}">
                <f:selectItems value="#{PessoaCategoriafaces.pessoaCategoriaClientes}"/>
                <f:converter converterId="PessoaCategoriaConverter"/>
            </h:selectOneMenu>

            Usuario: <h:selectOneMenu value="#{VendaFaces.selectedVenda.usuCodigo}">
                <f:selectItems value="#{UsuarioFaces.usuarios}"/>
                <f:converter converterId="UsuarioConverter"/>
            </h:selectOneMenu>
            <br/><br/>
            Veiculo: <h:selectOneMenu value="#{VendaFaces.selectedVenda.veiCodigo}">
                <f:selectItems value="#{VeiculoFaces.veiculo}"/>
                <f:converter converterId="VeiculoConverter"/>
            </h:selectOneMenu>
            Data: <h:inputText disabled="true" size="10" value="#{VendaFaces.selectedVenda.venData}">
                <f:convertDateTime pattern="dd/MM/yyyy"/>
            </h:inputText>
            Data de Entrega: <h:inputText id="entrega" size="10" onkeyup="formatar(this,'##/##/####')" required="true" requiredMessage="Informe a data de entrega" value="#{VendaFaces.selectedVenda.venDAtaEntrega}">
                <f:convertDateTime pattern="dd/MM/yyyy"/>
            </h:inputText>
            <b id="obrigatorio"><h:message for="entrega"/></b>
            <br/><br/>
            ICMS: <h:inputText id="ICSM" size="8" maxlength="10" value="#{VendaFaces.selectedVenda.venIcms}">
                <f:convertNumber pattern="#,###,##0.00"/>
            </h:inputText>

            Seguro: <h:inputText id="seguro" size="8" maxlength="10" value="#{VendaFaces.selectedVenda.venSeguro}">
                <f:convertNumber pattern="#,###,##0.00"/>
            </h:inputText>

            Frete: <h:inputText id="frete" size="8" maxlength="10" value="#{VendaFaces.selectedVenda.venValorFrete}">
                <f:convertNumber pattern="#,###,##0.00"/>
            </h:inputText>
            <br/><br/>
            Fechada: <h:selectOneRadio value="#{VendaFaces.selectedVenda.venFechada}">
                <f:selectItem itemValue="A" itemLabel="Aberta" escape="true"/>
                <f:selectItem itemValue="F" itemLabel="Fechada"/>
            </h:selectOneRadio>
            <br/><br/>
            <h:commandButton action="#{VendaFaces.chamaVenda}" value="Cancelar" immediate="true"/>
            <h:commandButton action="#{VendaFaces.finishAddVenda}" value="Salvar"/>
            <%--/c:if>
            <c:if test="${VendaFaces.selectedVenda.venFechada == 'F'}">
                <h:commandButton action="gotoListVenda" value="Voltar" immediate="true"/>
                <b style="width:150%">Esta Venda já esta fechada, portanto não poderá ser alterada!</b>
            </c:if --%>
        </h:form>
    </div>
</f:view>
