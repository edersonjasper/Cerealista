<%@include file="tagLib.jsp" %>
<f:view>
    <b id="titulo">Bancos!</b>
    <h:form>
        <h:commandButton action="#{BancoFaces.addBanco}" value="Novo Registro"/>
        <div id="scroll">
            <h:dataTable border="1" styleClass="cinza" value="#{BancoFaces.cachedBanco}" var="item">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{item.banCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Banco"/>
                    </f:facet>
                    <h:commandLink action="#{BancoFaces.updateBanco}" value=" #{item.banNome}">
                        <f:setPropertyActionListener target="#{BancoFaces.selectedBanco}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Excluir"/>
                    </f:facet>
                    <h:commandLink action="#{BancoFaces.removeBanco}" value="Excluir">
                        <f:setPropertyActionListener target="#{BancoFaces.selectedBanco}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
            </h:dataTable>
        </div>
    </h:form>
</f:view>
