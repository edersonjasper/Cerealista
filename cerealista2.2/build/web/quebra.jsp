<%@include file="tagLib.jsp" %>
<f:view>
    <b id="titulo">Quebra!</b>
    <h:form>
        <h:commandButton action="#{QuebraFaces.addQuebra}" value="Novo Registro"/>
        <div id="scroll">
            <h:dataTable border="1" styleClass="cinza" value="#{QuebraFaces.cachedQuebra}" var="item">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{item.queCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Produto"/>
                    </f:facet>
                    <h:commandLink action="#{QuebraFaces.updateQuebra}" value=" #{item.proCodigo}">
                        <f:setPropertyActionListener target="#{QuebraFaces.selectedQuebra}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Data"/>
                    </f:facet>
                    <h:outputText value="#{item.queData}">
                        <f:convertDateTime pattern="dd/MM/yyyy" />
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Quantidade"/>
                    </f:facet>
                    <h:outputText value=" #{item.queQuantidade}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Peso Unitário"/>
                    </f:facet>
                    <h:outputText value="#{item.quePesoUnitario}">
                        <f:convertNumber pattern="###,##0.000"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Peso Total"/>
                    </f:facet>
                    <h:outputText value="#{item.quePesoTotal}">
                        <f:convertNumber pattern="###,##0.000"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Usuário"/>
                    </f:facet>
                    <h:outputText value=" #{item.usuCodigo}"/>
                </h:column>
            </h:dataTable>
        </div>
    </h:form>
</f:view>
