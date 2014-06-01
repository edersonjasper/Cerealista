<%@include file="tagLib.jsp" %>
<f:view>
    <b id="titulo">Unidade de Medidas!</b>
    <h:form>
        <h:commandButton action="#{UnidadeMedidaFaces.addUnidadeMedida}" value="Novo Registro"/>
        <div id="scroll">
            <h:dataTable border="1" styleClass="cinza" value="#{UnidadeMedidaFaces.cachedUniMed}" var="item">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{item.uniCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Descrição"/>
                    </f:facet>
                    <h:commandLink action="#{UnidadeMedidaFaces.updateUnidadeMedida}" value=" #{item.uniDescricao}">
                        <f:setPropertyActionListener target="#{UnidadeMedidaFaces.selectedUniMed}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Excluir"/>
                    </f:facet>
                    <h:commandLink action="#{UnidadeMedidaFaces.removeUnidadeMedida}" value="Excluir">
                        <f:setPropertyActionListener target="#{UnidadeMedidaFaces.selectedUniMed}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
            </h:dataTable>
        </div>
    </h:form>
</f:view>