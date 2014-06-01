
<%@include file="tagLib.jsp" %>

<f:view>
    <b id="titulo">Itens da Venda!</b>
    <h:form>
        <h:commandButton action="#{VendaFaces.chamaVenda}" value="Voltar"/>
        <c:if test="${ProdutoVendaFaces.selectedVenda.venFechada == 'A'}">
            <h:commandButton action="#{ProdutoVendaFaces.addProdutoVenda}" value="Novo Registro"/>
        </c:if>
        <div id="scroll">
            <h:dataTable border="1" styleClass="cinza" value="#{ProdutoVendaFaces.cachedProdutoVenda}" var="item">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{item.proVenCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Fornecedor"/>
                    </f:facet>
                    <h:outputText value=" #{item.proVenNomeFornecedor}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Venda"/>
                    </f:facet>
                    <h:outputText value=" #{item.venCodigo.pesCatCodigo.pesCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Produto"/>
                    </f:facet>
                    <h:commandLink action="#{ProdutoVendaFaces.updateProdutoVenda}" value=" #{item.proCodigo}">
                        <f:setPropertyActionListener target="#{ProdutoVendaFaces.selectedProdutoVenda}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Quatidade"/>
                    </f:facet>
                    <h:outputText value=" #{item.proVenQuatidade}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Peso Unitário"/>
                    </f:facet>
                    <h:outputText value="#{item.proVenPesoUnitario}">
                        <f:convertNumber pattern="###,##0.000"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Peso Total"/>
                    </f:facet>
                    <h:outputText value="#{item.proVenPesoTotal}">
                        <f:convertNumber pattern="###,##0.000"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Valor Unitário"/>
                    </f:facet>
                    <h:outputText value="#{item.proVenValorUnitario}">
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Valor Total"/>
                    </f:facet>
                    <h:outputText value="#{item.proVenValorTotal}">
                        <f:convertNumber type="currency" currencySymbol="R$"/>
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
