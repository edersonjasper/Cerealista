<%@include file="tagLib.jsp" %>
<f:view>
    <b id="titulo">Formas de Pagamento!</b>
    <h:form>
        <h:commandButton action="#{FormaPagamentoFaces.addFormaPagamento}" value="Novo Registro"/>
        <div id="scroll">
            <h:dataTable border="1" styleClass="cinza" value="#{FormaPagamentoFaces.cachedFormaPagamento}" var="item">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{item.forPagCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Descrição"/>
                    </f:facet>
                    <h:commandLink action="#{FormaPagamentoFaces.updateFormaPagamento}" value=" #{item.forPagDescricao}">
                        <f:setPropertyActionListener target="#{FormaPagamentoFaces.selectedFormaPagamento}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Excluir"/>
                    </f:facet>
                    <h:commandLink action="#{FormaPagamentoFaces.removeFormaPagamento}" value="Excluir">
                        <f:setPropertyActionListener target="#{FormaPagamentoFaces.selectedFormaPagamento}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
            </h:dataTable>
        </div>
    </h:form>
</f:view>