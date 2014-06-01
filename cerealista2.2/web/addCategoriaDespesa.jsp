<%@include file="tagLib.jsp" %>

<f:view>
    <c:if test="${CategoriaDespesaFaces.selectedCategoriaDespesa.catDesDescricao == null}">
        <b id="titulo">Cadastro de Categorias de Despesa!</b>
    </c:if>
    <c:if test="${CategoriaDespesaFaces.selectedCategoriaDespesa.catDesDescricao != null}">
        <b id="titulo">Atualizar Categoria de Despesa!</b>
    </c:if>
    <div id="corFundo" style="width:40%">
        <h:form>
            Descrição: <h:inputText id="descricao" required="true" maxlength="30" requiredMessage="Informe a descrição" value="#{CategoriaDespesaFaces.selectedCategoriaDespesa.catDesDescricao}"/>
            <b id="obrigatorio"><h:message for="descricao"/></b>
            <br/><br/>
            <h:commandButton action="#{CategoriaDespesaFaces.chamaCategoriaDespesa}" value="Cancelar" immediate="true"/>
            <h:commandButton action="#{CategoriaDespesaFaces.finishAddCategoriaDespesa}" value="Salvar"/>
        </h:form>
    </div>
</f:view>
