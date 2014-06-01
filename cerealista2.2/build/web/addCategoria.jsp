<%@include file="tagLib.jsp" %>
<f:view>
    <c:if test="${CategoriaFaces.selectedCategoria.catDescricao == null}">
        <b id="titulo">Cadastro de Categorias de Pessoas!</b>
    </c:if>
    <c:if test="${CategoriaFaces.selectedCategoria.catDescricao != null}">
        <b id="titulo">Atualizar Categoria de Pessoas!</b>
    </c:if>
    <div>
        <h:form>
            Descrição: <h:inputText id="descricao" maxlength="30" required="true" requiredMessage="Informe a descrição" value="#{CategoriaFaces.selectedCategoria.catDescricao}"/>
            <b id="obrigatorio"> <h:message for="descricao"/> </b>
            <br/><br/>
            <h:commandButton action="#{CategoriaFaces.chamaCategoria}" value="Cancelar" immediate="true"/>
            <h:commandButton action="#{CategoriaFaces.finishAddCategoria}" value="Salvar"/>
        </h:form>
    </div>
</f:view>
