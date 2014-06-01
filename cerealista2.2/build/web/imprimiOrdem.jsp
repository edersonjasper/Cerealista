<%@include file="tagLib.jsp" %>
<f:view>
    <h:form>
        <h:commandButton action="gotoPesqOrdem" value="Voltar"/><br/>
        <div id="border">
            <h1>Ordem de Compra</h1>
            <b> Nome:</b> <h:outputText value="#{OrdemFaces.selectedOrdem.pesCatCodigo}"/> &nbsp;&nbsp;&nbsp;
            <b> Endereço:</b> <h:outputText value="#{OrdemFaces.selectedOrdem.pesCatCodigo.pesCodigo.pesEndereco}"/><br/>
            <b> Bairro:</b> <h:outputText value="#{OrdemFaces.selectedOrdem.pesCatCodigo.pesCodigo.pesBairro}"/> &nbsp;&nbsp;&nbsp;
            <b> Cidade:</b> <h:outputText value="#{OrdemFaces.selectedOrdem.pesCatCodigo.pesCodigo.cidCodigo.cidNome}"/> &nbsp;&nbsp;&nbsp;
            <b> UF:</b> <h:outputText value="#{OrdemFaces.selectedOrdem.pesCatCodigo.pesCodigo.cidCodigo.cidUf}"/><br/>
            <b>Telefone:</b>
            <c:set var="telefone" value="${OrdemFaces.cachedTelefone}"/>
            <c:forEach var="tel" items="${telefone}">
                <c:out value="${tel.telNumero} -"/>
            </c:forEach>
            <br/>
            <b>Data:</b> <h:outputText value="#{OrdemFaces.selectedOrdem.ordData}">
                <f:convertDateTime pattern="dd/MM/yyyy"/>
            </h:outputText>

            <b>Data de Venc.: </b><h:outputText value="#{OrdemFaces.selectedOrdem.ordDataVencimento}">
                <f:convertDateTime pattern="dd/MM/yyyy"/>
            </h:outputText>
            <h:dataTable border="1" styleClass="cinza" value="#{OrdemFaces.cachedOrdemProduto}" var="item">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Produto"/>
                    </f:facet>
                    <h:outputText value=" #{item.proCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Quantidade"/>
                    </f:facet>
                    <h:outputText value="#{item.ordProQuantidade}">
                        <f:convertNumber pattern="###,##0.000"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Peso Unitário"/>
                    </f:facet>
                    <h:outputText value="#{item.ordProPesoUnitario}">
                        <f:convertNumber pattern="###,##0.000"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Peso Total"/>
                    </f:facet>
                    <h:outputText value="#{item.ordProPesoTotal}">
                        <f:convertNumber pattern="#,###,##0.000"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Valor Unitário"/>
                    </f:facet>
                    <h:outputText value="#{item.ordProValorUnitario}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Valor Total"/>
                    </f:facet>
                    <h:outputText value="#{item.ordProValorTotal}">
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText>
                </h:column>
            </h:dataTable>
            <b> Peso total: </b> <h:outputText value="#{OrdemFaces.selectedOrdem.ordPesoTotal}">
                <f:convertNumber pattern="###,##0.00"/>
            </h:outputText> <br/>
            <b>  Valor total:</b><h:outputText value="#{OrdemFaces.selectedOrdem.ordValorTotal}">
                <f:convertNumber type="currency" currencySymbol="R$"/>
            </h:outputText><br/>
            <b> Fundo Rural:</b> <h:outputText value="#{OrdemFaces.selectedOrdem.ordFundoRural}">
                <f:convertNumber type="currency" currencySymbol="R$"/>
            </h:outputText><br/>
            <b> Desconto:</b><h:outputText value="#{OrdemFaces.selectedOrdem.ordDesconto}">
                <f:convertNumber type="currency" currencySymbol="R$"/>
            </h:outputText><br/>
            <b> Adiantamento:</b>  <h:outputText value="#{OrdemFaces.selectedOrdem.ordAdiantemento}">
                <f:convertNumber type="currency" currencySymbol="R$"/>
            </h:outputText><br/>
            <b> Valor Restante:</b><h:outputText value="#{OrdemFaces.selectedOrdem.ordValorRestante}">
                <f:convertNumber type="currency" currencySymbol="R$"/>
            </h:outputText><br/>
        </div>
    </h:form>
</f:view>
