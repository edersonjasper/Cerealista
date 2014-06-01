<%@include file="tagLib.jsp" %>
<b id="titulo">Veículos!</b>
<f:view>
    <h:form>
        <h:commandButton action="#{VeiculoFaces.addVeiculo}" value="Novo Registro"/>
        <div id="scroll">
            <h:dataTable border="1" styleClass="cinza" value="#{VeiculoFaces.cachedVeiculo}" var="item">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{item.veiCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Pessoa"/>
                    </f:facet>
                    <h:outputText value=" #{item.pesCatCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Veículo"/>
                    </f:facet>
                    <h:outputText value=" #{item.veiVeiculo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Placa"/>
                    </f:facet>
                    <h:commandLink action="#{VeiculoFaces.updateVeiculo}" value=" #{item.veiPlaca}">
                        <f:setPropertyActionListener target="#{VeiculoFaces.selectedVeiculo}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Cidade"/>
                    </f:facet>
                    <h:outputText value=" #{item.cidCodigo} - #{item.cidCodigo.cidUf}"/>
                </h:column>
            </h:dataTable>
        </div>
    </h:form>
</f:view>