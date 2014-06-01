<%@include file="tagLib.jsp" %>
<f:view>            
    <b id="titulo">Cidades!</b>
    <h:form>
        <h:commandButton action="#{CidadeFaces.addCidade}" value="Novo Registro"/>
        <div id="scroll">
            <h:dataTable border="1" styleClass="cinza" var="cid" value="#{CidadeFaces.cacheCidade}">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{cid.cidCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Cidade"/>
                    </f:facet>
                    <h:commandLink action="#{CidadeFaces.updateCidade}" value=" #{cid.cidNome}">
                        <f:setPropertyActionListener target="#{CidadeFaces.selectedCidade}" value="#{cid}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="UF"/>
                    </f:facet>
                    <h:outputText value=" #{cid.cidUf}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Excluir"/>
                    </f:facet>
                    <h:commandLink action="#{CidadeFaces.removeCidade}" value="Excluir">
                        <f:setPropertyActionListener target="#{CidadeFaces.selectedCidade}" value="#{cid}"/>
                    </h:commandLink>
                </h:column>
            </h:dataTable>
        </div>
    </h:form>
</f:view>
