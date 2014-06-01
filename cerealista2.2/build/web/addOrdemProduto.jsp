<%@include file="tagLib.jsp" %>
<f:view>
    <c:if test="${OrdemProdutoFaces.selectedOrdemProduto.ordProQuantidade == null}">
        <b id="titulo">Cadastro de Itens para Ordem!</b>
    </c:if>
    <c:if test="${OrdemProdutoFaces.selectedOrdemProduto.ordProQuantidade != null}">
        <b id="titulo">Atualizar Item da Ordem!</b>
    </c:if>
    <div id="corFundo" style="width:75%">
        <h:form>

            Ordem: <h:inputText size="20" disabled="true" value="#{OrdemProdutoFaces.selectedOrdemProduto.ordCodigo.pesCatCodigo.pesCodigo}"/>
            Usuário: <h:selectOneMenu value="#{OrdemProdutoFaces.selectedOrdemProduto.usuCodigo}">
                <f:selectItems value="#{UsuarioFaces.usuarios}"/>
                <f:converter converterId="UsuarioConverter"/>
            </h:selectOneMenu>
            <br/><br/>
            Produto: <h:selectOneMenu value="#{OrdemProdutoFaces.selectedOrdemProduto.proCodigo}">
                <f:selectItems value="#{ProdutoFaces.produto}"/>
                <f:converter converterId="ProdutoConverter"/>
            </h:selectOneMenu>
            Quantidade: <h:inputText id="quantidade" maxlength="10" required="true" requiredMessage="Informe a quantidade" size="7" value="#{OrdemProdutoFaces.selectedOrdemProduto.ordProQuantidade}">
                <f:convertNumber pattern="#,###,##0.###"/>
            </h:inputText>
            <b id="obrigatorio"><h:message for="quantidade"/> </b>

            Peso Unitário: <h:inputText id="peso" maxlength="10" required="true" requiredMessage="Informe o peso" size="10" value="#{OrdemProdutoFaces.selectedOrdemProduto.ordProPesoUnitario}">
                <f:convertNumber pattern="#,###,##0.000"/>
            </h:inputText>
            <b id="obrigatorio"><h:message for="peso"/> </b>

            Valor Unitário: <h:inputText id="valor" maxlength="10" required="true" requiredMessage="Informe o valor unitário" size="7" value="#{OrdemProdutoFaces.selectedOrdemProduto.ordProValorUnitario}">
                <f:convertNumber pattern="#,###,##0.00"/>
            </h:inputText>
            <b id="obrigatorio"><h:message for="valor"/> </b>

            <br/> <br/>
            <h:commandButton action="#{OrdemProdutoFaces.chamaOrdemProduto}" value="Cancelar" immediate="true"/>
            <h:commandButton action="#{OrdemProdutoFaces.finishAddOrdemProduto}" value="Salvar"/>
        </h:form>
    </div>
</f:view>
