<%@include file="tagLib.jsp" %>
<f:view>
    <c:if test="${ProdutoFaces.selectedProduto.proNome == null}">
        <b id="titulo">Cadastro de Produtos!</b>
    </c:if>
    <c:if test="${ProdutoFaces.selectedProduto.proNome != null}">
        <b id="titulo">Atualizar Produto!</b>
    </c:if>
    <div>
        <h:form>
            Produto: <h:inputText id="nome" maxlength="40" required="true" requiredMessage="Informe o nome" value="#{ProdutoFaces.selectedProduto.proNome}"/>
            <b id="obrigatorio"><h:message for="nome"/> </b> <br/> <br/>
            Unidade de Medida: <h:selectOneMenu value="#{ProdutoFaces.selectedProduto.uniMedCodigo}">
                <f:selectItems value="#{UnidadeMedidaFaces.unidadeMedida}"/>
                <f:converter converterId="UnidadeMedidaConverter"/>
            </h:selectOneMenu>
            Estoque: <h:inputText id="estoque" disabled="true" size="15" value="#{ProdutoFaces.selectedProduto.proEstoque}">
                <f:convertNumber pattern="#,###,##0.000"/>
            </h:inputText>
            <br/><br/>
            <h:commandButton action="#{ProdutoFaces.chamaProduto}" value="Cancelar" immediate="true"/>
            <h:commandButton action="#{ProdutoFaces.finishAddProduto}" value="Salvar"/>
        </h:form>
    </div>
</f:view>
