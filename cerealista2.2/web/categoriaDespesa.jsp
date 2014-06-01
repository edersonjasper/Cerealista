<%@include file="tagLib.jsp" %>
    <f:view>
        <b id="titulo">Categoria das Despesas!</b>
        <h:form>
            <h:commandButton action="#{CategoriaDespesaFaces.addCategoriaDespesa}" value="Novo Registro"/>
            <div id="scroll">
            <h:dataTable border="1" styleClass="cinza" value="#{CategoriaDespesaFaces.cachedCategoriaDespesa}" var="item">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{item.catDesCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Descrição"/>
                    </f:facet>
                    <h:commandLink action="#{CategoriaDespesaFaces.updateCategoriaDespesa}" value=" #{item.catDesDescricao}">
                        <f:setPropertyActionListener target="#{CategoriaDespesaFaces.selectedCategoriaDespesa}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Excluir"/>
                    </f:facet>
                    <h:commandLink action="#{CategoriaDespesaFaces.removeCategoriaDespesa}" value="Excluir">
                        <f:setPropertyActionListener target="#{CategoriaDespesaFaces.selectedCategoriaDespesa}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
            </h:dataTable>
            </div>
        </h:form>
    </f:view>
