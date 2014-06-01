<%@include file="tagLib.jsp" %>
<f:view>
    <c:if test="${CidadeFaces.selectedCidade.cidNome == null}">
        <b id="titulo">Cadastro de Cidades!</b>
    </c:if>
    <c:if test="${CidadeFaces.selectedCidade.cidNome != null}">
        <b id="titulo">Atualizar Cidade!</b>
    </c:if>
    <div id="corFundo" style="width:30%">
        <h:form>
            Cidade:<h:inputText id="nome" maxlength="40" required="true" requiredMessage="Informe o nome!" value="#{CidadeFaces.selectedCidade.cidNome}"/> <br/>
            <h:message for="nome"/><br/>
            UF:<h:inputText id="uf" required="true" maxlength="2" size="2" requiredMessage="Informe o usuário!" value="#{CidadeFaces.selectedCidade.cidUf}"/> <br/>
            <h:message for="uf"/><br/>
            <h:commandButton action="#{CidadeFaces.chamaCidade}" immediate="true" value="Cancelar"/>
            <h:commandButton action="#{CidadeFaces.finishAddCidade}" value="salvar"/>
        </h:form>
    </div>
</f:view>
