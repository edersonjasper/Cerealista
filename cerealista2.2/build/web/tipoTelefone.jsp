<%@include file="tagLib.jsp" %>
<f:view>
    <b id="titulo">Tipos de Telefones!</b>
    <h:form>
        <h:commandButton action="#{TipoTelefoneFaces.addTipoTelefone}" value="Novo Registro"/>
        <div id="scroll">
            <h:dataTable border="1" styleClass="cinza" value="#{TipoTelefoneFaces.cacheTipoTelefone}" var="tipTel">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{tipTel.tipCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Descrição"/>
                    </f:facet>
                    <h:commandLink action="#{TipoTelefoneFaces.updateTipoTelefone}" value=" #{tipTel.tipDescricao}">
                        <f:setPropertyActionListener target="#{TipoTelefoneFaces.selectedTipoTelefone}" value="#{tipTel}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Excluir"/>
                    </f:facet>
                    <h:commandLink action="#{TipoTelefoneFaces.removeTipoTelefone}" value="Excluir">
                        <f:setPropertyActionListener target="#{TipoTelefoneFaces.selectedTipoTelefone}" value="#{tipTel}"/>
                    </h:commandLink>
                </h:column>
            </h:dataTable>
        </div>
    </h:form>
</f:view>