
<%@include file="tagLib.jsp" %>

<f:view>            
    <b id="titulo">Produtos da Ordem!</b>
    <h:form>
        <h:commandButton action="#{OrdemFaces.chamaOrdem}" value="Voltar"/>
        <h:commandButton action="#{OrdemProdutoFaces.addOrdemProduto}" value="Novo Registro"/>
        <div id="scroll">
            <h:dataTable border="1" styleClass="cinza" value="#{OrdemProdutoFaces.cachedOrdemProduto}" var="item">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{item.ordProCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Ordem"/>
                    </f:facet>
                    <h:outputText value=" #{item.ordCodigo.pesCatCodigo.pesCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Produto"/>
                    </f:facet>
                    <h:commandLink action="#{OrdemProdutoFaces.updateOrdemProduto}" value=" #{item.proCodigo}">
                        <f:setPropertyActionListener target="#{OrdemProdutoFaces.selectedOrdemProduto}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Quantidade"/>
                    </f:facet>
                    <h:outputText value=" #{item.ordProQuantidade}"/>
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
                    <h:outputText value="#{item.ordProValorUnitario}">
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Valor Total"/>
                    </f:facet>
                    <h:outputText value="#{item.ordProValorTotal}">
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Usuário"/>
                    </f:facet>
                    <h:outputText value=" #{item.usuCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Excluir"/>
                    </f:facet>
                    <h:commandLink action="#{OrdemProdutoFaces.removeOrdemProduto}" value="Excluir">
                        <f:setPropertyActionListener target="#{OrdemProdutoFaces.selectedOrdemProduto}" value="#{item}"/>
                    </h:commandLink>
                </h:column>

            </h:dataTable>
        </div>
    </h:form>
</f:view>
