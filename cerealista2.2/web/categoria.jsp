<%@include file="tagLib.jsp" %>
<f:view>
    <b id="titulo">Categorias!</b>
    <h:form>
        <h:commandButton action="#{CategoriaFaces.addCategoria}" value="Novo Registro"/>
        <div id="scroll">
            <h:dataTable border="1" styleClass="cinza" value="#{CategoriaFaces.cachedCategoria}" var="item">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{item.catCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Descrição"/>
                    </f:facet>
                    <h:commandLink action="#{CategoriaFaces.updateCategoria}" value=" #{item.catDescricao}">
                        <f:setPropertyActionListener target="#{CategoriaFaces.selectedCategoria}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Excluir"/>
                    </f:facet>
                    <h:commandLink action="#{CategoriaFaces.removeCategoria}" value="Excluir">
                        <f:setPropertyActionListener target="#{CategoriaFaces.selectedCategoria}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
            </h:dataTable>
        </div>
    </h:form>
</f:view>
