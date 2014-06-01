<%@include file="tagLib.jsp" %>

<f:view>
    <b id="titulo">Vendas!</b>
    <br/>
    <div id="scroll">
        <div id="pesquisa">
            Relatório de Produtos!
            <br/>
            <form name="formRel1" action="relVendaProduto" method="post">
                Data:<input type="text" onkeyup="formatar(this,'##/##/####')" name="dataIni" value="" size="8"/>
                até <input type="text" onkeyup="formatar(this,'##/##/####')" name="dataFin" value="" size="8"/>
                <br/>
                <br/>
                <input type="submit" value="Relatório" name="bntRel"/>
            </form>
        </div>
        <br/>
        <div id="pesquisa">
            <br/>
            <form name="formRel" action="relVenda" method="post">
                Código:<input type="text" name="venCodigo" value="" size="8"/>
                <input type="submit" value="Imprimir" name="bntRel"/>
                <br/>
                <br/>
            </form>
        </div>
        <h:form>
            <h:commandButton action="gotoMain" value="Voltar"/>
            <h:commandButton action="#{VendaFaces.addVenda}" value="NovoRegistro"/>

            <h:dataTable border="1" styleClass="cinza" value="#{VendaFaces.cachedVenda}" var="item">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{item.venCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Pessoa"/>
                    </f:facet>
                    <h:commandLink action="#{VendaFaces.updateVenda}" value=" #{item.pesCatCodigo.pesCodigo}">
                        <f:setPropertyActionListener target="#{VendaFaces.selectedVenda}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Data"/>
                    </f:facet>
                    <h:outputText value="#{item.venData}">
                        <f:convertDateTime pattern="dd/MM/yyyy" />
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Data Entrega"/>
                    </f:facet>
                    <h:outputText value="#{item.venDAtaEntrega}">
                        <f:convertDateTime pattern="dd/MM/yyyy" />
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Peso Total"/>
                    </f:facet>
                    <h:outputText value="#{item.venPesoTotal}">&nbsp;
                        <f:convertNumber pattern="###,##0.000"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Valor Total"/>
                    </f:facet>
                    <h:outputText value="#{item.venValorTotal}">&nbsp;
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Seguro"/>
                    </f:facet>
                    <h:outputText value="#{item.venSeguro}">&nbsp;
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Icms"/>
                    </f:facet>
                    <h:outputText value="#{item.venIcms}">&nbsp;
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Valor Frete"/>
                    </f:facet>
                    <h:outputText value="#{item.venValorFrete}">&nbsp;
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Valor Liquido"/>
                    </f:facet>
                    <h:outputText value="#{item.venValorLiquido}">&nbsp;
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Veículo"/>
                    </f:facet>
                    <h:outputText value=" #{item.veiCodigo} - #{item.veiCodigo.veiVeiculo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Fechada"/>
                    </f:facet>
                    <h:outputText value=" #{item.venFechada}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Usuário"/>
                    </f:facet>
                    <h:outputText value=" #{item.usuCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Itens"/>
                    </f:facet>
                    <h:commandLink action="#{ProdutoVendaFaces.chamaProdutoVenda}" value="Itens">
                        <f:setPropertyActionListener target="#{ProdutoVendaFaces.selectedVenda}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
            </h:dataTable>
        </h:form>
    </div>
</f:view>