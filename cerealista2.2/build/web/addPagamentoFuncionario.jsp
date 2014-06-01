<%@include file="tagLib.jsp" %>
<f:view>
    <c:if test="${PagamentoFuncionarioFaces.selectedPagamentoFuncionario.pagFunValor == null}">
        <b id="titulo">Cadastro de Pagamento de Funcionários!</b>
    </c:if>
    <c:if test="${PagamentoFuncionarioFaces.selectedPagamentoFuncionario.pagFunValor != null}">
        <b id="titulo">Atualizar Pagamento de Funcionário!</b>
    </c:if>
    <div id="corFundo" style="width:50%">
        <h:form>
            <h:messages/>

            Usuário: <h:selectOneMenu value="#{PagamentoFuncionarioFaces.selectedPagamentoFuncionario.usuCodigo}">
                <f:selectItems value="#{UsuarioFaces.usuarios}"/>
                <f:converter converterId="UsuarioConverter"/>
            </h:selectOneMenu>
            <br/><br/>
            Funcionário: <h:selectOneMenu value="#{PagamentoFuncionarioFaces.selectedPagamentoFuncionario.pesCatCodigo}">
                <f:selectItems value="#{PessoaCategoriafaces.pessoaCategoriaFuncionarios}"/>
                <f:converter converterId="PessoaCategoriaConverter"/>
            </h:selectOneMenu>
            Valor Pago: <h:inputText id="valor" required="true" size="8" maxlength="10" requiredMessage="Informe o valor pago" value="#{PagamentoFuncionarioFaces.selectedPagamentoFuncionario.pagFunValor}">
                <f:convertNumber pattern="#,###,##0.00"/>
            </h:inputText>
            <b id="obrigatorio"><h:message for="valor"/></b>
            <br/><br/>
            Data: <h:inputText size="10" disabled="true" value="#{PagamentoFuncionarioFaces.selectedPagamentoFuncionario.pagFunData}">
                <f:convertDateTime pattern="dd/MM/yyyy"/>
            </h:inputText>
            <br/><br/>
            <h:commandButton action="#{PagamentoFuncionarioFaces.chamaPagamentoFuncionario}" value="Cancelar" immediate="true"/>
            <h:commandButton action="#{PagamentoFuncionarioFaces.finishAddPagamentoFuncionario}" value="Salvar"/>
        </h:form>
    </div>
</f:view>
