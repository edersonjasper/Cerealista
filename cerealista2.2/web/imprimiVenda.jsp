<%@include file="tagLib.jsp" %>
<f:view>
    <h:form>
        <h:commandButton action="gotoListVenda" value="Voltar"/>
        <div id="border">
            <h1>Ordem de Venda</h1>
            <b> Veiculo: </b> <h:outputText value="#{VendaFaces.selectedVenda.veiCodigo.veiPlaca}"/><br/>
            <b> Destinatário: </b> <h:outputText value="#{VendaFaces.selectedVenda.pesCatCodigo.pesCodigo.pesNome}"/><br/>
            <b> Data: </b> <h:outputText value="#{VendaFaces.selectedVenda.venData}"/><br/>
            <b> Data Entrega: </b> <h:outputText value="#{VendaFaces.selectedVenda.venDAtaEntrega}"/>

            <h:dataTable border="1" styleClass="cinza" value="#{VendaFaces.cachedProdutoVenda}" var="item">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Produto"/>
                    </f:facet>
                    <h:outputText value="#{item.proCodigo.proNome}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Quatidade"/>
                    </f:facet>
                    <h:outputText value="#{item.proVenQuatidade}">
                        <f:convertNumber pattern="#,###,##0.00"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Peso Unitário"/>
                    </f:facet>
                    <h:outputText value="#{item.proVenPesoUnitario}">
                        <f:convertNumber pattern="#,###,##0.00"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Peso Total"/>
                    </f:facet>
                    <h:outputText value="#{item.proVenPesoTotal}">
                        <f:convertNumber pattern="#,###,##0.00"/>
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
                        <h:outputText value="Fornecedor"/>
                    </f:facet>
                    <h:outputText value="#{item.proVenNomeFornecedor}"/>
                </h:column>
            </h:dataTable>
            <b> Peso total:</b> <h:outputText value="#{VendaFaces.selectedVenda.venPesoTotal}">
                <f:convertNumber pattern="#,###,##0.00"/>
            </h:outputText>
            <br/>
            <b> Valor Total:</b> <h:outputText value="#{VendaFaces.selectedVenda.venValorTotal}">
                <f:convertNumber type="currency" currencySymbol="R$"/>
            </h:outputText>
            <br/>
            <b> ICMS:</b> <h:outputText value="#{VendaFaces.selectedVenda.venIcms}">
                <f:convertNumber type="currency" currencySymbol="R$"/>
            </h:outputText>
            <br/>
            <b> Frete: </b> <h:outputText value="#{VendaFaces.selectedVenda.venValorFrete}">
                <f:convertNumber type="currency" currencySymbol="R$"/>
            </h:outputText>
            <br/>
            <b> Seguro:</b> <h:outputText value="#{VendaFaces.selectedVenda.venSeguro}">
                <f:convertNumber type="currency" currencySymbol="R$"/>
            </h:outputText>
            <br/>
            <b> Valor Líquido:</b> <h:outputText value="#{VendaFaces.selectedVenda.venValorLiquido}">
                <f:convertNumber type="currency" currencySymbol="R$"/>
            </h:outputText>
            <br/>
        </div>
    </h:form>
</f:view>
