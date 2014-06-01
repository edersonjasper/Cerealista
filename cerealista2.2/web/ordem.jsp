<%@include file="tagLib.jsp" %>
<f:view>
    <b id="titulo">Ordens de Compra!</b>
    <div id="scroll">
        <div id="pesquisa">
            <br/>
            <form name="formRel" action="relOrdemProdutoComprado" method="post">
                Data:<input type="text" onkeyup="formatar(this,'##/##/####')" name="dataIni" value="" size="8"/>
                até <input type="text" onkeyup="formatar(this,'##/##/####')" name="dataFin" value="" size="8"/>
                <br/>
                <br/>
                <input type="submit" value="Relatório" name="bntRel"/>
            </form>
        </div>
        <h:form>
            <h:commandButton action="#{OrdemFaces.addOrdem}" value="Novo registro"/>
            <h:commandButton action="#{OrdemFaces.chamaPesqOrdem}" value="Pesquisar Ordens"/>

            <h:dataTable border="1" styleClass="cinza" value="#{OrdemFaces.cachedOrdem}" var="item" >
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{item.ordCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Pessoa"/>
                    </f:facet>
                    <h:commandLink action="#{OrdemFaces.updateOrdem}" value=" #{item.pesCatCodigo}">
                        <f:setPropertyActionListener target="#{OrdemFaces.selectedOrdem}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Data"/>
                    </f:facet>
                    <h:outputText value="#{item.ordData}">
                        <f:convertDateTime pattern="dd/MM/yyyy" />
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Dt. Vencimento"/>
                    </f:facet>
                    <h:outputText value="#{item.ordDataVencimento}">
                        <f:convertDateTime pattern="dd/MM/yyyy" />
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Peso Total"/>
                    </f:facet>
                    <h:outputText value="#{item.ordPesoTotal}">
                        <f:convertNumber pattern="###,##0.000"/>
                    </h:outputText>

                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Valor Total"/>
                    </f:facet>
                    <h:outputText value="#{item.ordValorTotal}">
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Desconto"/>
                    </f:facet>
                    <h:outputText value="#{item.ordDesconto}">
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="fundo Rural"/>
                    </f:facet>
                    <h:outputText value="#{item.ordFundoRural}">
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Adiantemento"/>
                    </f:facet>
                    <h:outputText value="#{item.ordAdiantemento}">
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Valor Restante"/>
                    </f:facet>
                    <h:outputText value="#{item.ordValorRestante}">
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Aberta/Fechada"/>
                    </f:facet>
                    <h:outputText value="#{item.ordAberta}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Nota For."/>
                    </f:facet>
                    <h:outputText value=" #{item.ordNotaFornecedor}"/>&nbsp;
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Itens"/>
                    </f:facet>
                    <h:commandLink action="#{OrdemProdutoFaces.chamaOrdemProduto}" value="Itens">
                        <f:setPropertyActionListener target="#{OrdemProdutoFaces.selectedOrdem}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Usuário"/>
                    </f:facet>
                    <h:outputText value=" #{item.usuCodigo}"/>
                </h:column>
            </h:dataTable>      
        </h:form>
    </div>
</f:view>
