<%@include file="tagLib.jsp" %>
<f:view>
    <c:if test="${QuebraFaces.selectedQuebra.queQuantidade == null}">
        <b id="titulo">Cadastro de Quebra de Produto!</b>
    </c:if>
    <c:if test="${QuebraFaces.selectedQuebra.queQuantidade != null}">
        <b id="titulo">Atualizar Quebra de Produto!</b>
    </c:if>
    <div>
        <h:form>
            Usuário:<h:selectOneMenu value="#{QuebraFaces.selectedQuebra.usuCodigo}">
                <f:selectItems value="#{UsuarioFaces.usuarios}"/>
                <f:converter converterId="UsuarioConverter"/>
            </h:selectOneMenu>
            Produto:<h:selectOneMenu value="#{QuebraFaces.selectedQuebra.proCodigo}">
                <f:selectItems value="#{ProdutoFaces.produto}"/>
                <f:converter converterId="ProdutoConverter"/>
            </h:selectOneMenu>
            Data: <h:inputText value="#{QuebraFaces.selectedQuebra.queData}">
                <f:convertDateTime pattern="dd/MM/yyyy"/>
            </h:inputText>
            <br/> <br/>
            Quantidade:<h:inputText id="quantidade" size="10" maxlength="10" required="true" requiredMessage="Informe a quantidade" value="#{QuebraFaces.selectedQuebra.queQuantidade}"/>
            <b id="obrigatorio"><h:message for="quantidade" /> </b>
            Peso Unitário:<h:inputText id="peso" size="10" maxlength="10" required="true" requiredMessage="Informe o pedo unitário" value="#{QuebraFaces.selectedQuebra.quePesoUnitario}">
                <f:convertNumber pattern="#,###,##0.000"/>
            </h:inputText>
            <b id="obrigatorio"><h:message for="peso" /> </b>
            <br/><br/>
            <h:commandButton action="#{QuebraFaces.chamaQuebra}" value="Cancelar" immediate="true"/>
            <h:commandButton action="#{QuebraFaces.finishAddQuebra}" value="Salvar"/>
        </h:form>
    </div>
</f:view>