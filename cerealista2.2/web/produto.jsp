
<%@include file="tagLib.jsp" %>

<f:view>
    <b id="titulo">Produto!</b>
    <br/>
    <div id="pesquisa">
        <br/>
        <form name="formRel" action="relProdutoOrdem" method="post">
            Data:<input type="text" onkeyup="formatar(this,'##/##/####')" name="dataIni" value="" size="8"/>
            até <input type="text" onkeyup="formatar(this,'##/##/####')" name="dataFin" value="" size="8"/>
            <br/>
            <br/>
            <input type="submit" value="Relatório" name="bntRel"/>
        </form>
    </div>
    <h:form>
        <h:commandButton action="#{ProdutoFaces.addProduto}" value="Novo Registro"/>
        <div id="scroll">
            <h:dataTable border="1" styleClass="cinza" value="#{ProdutoFaces.cachedProduto}" var="item">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{item.proCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Produto"/>
                    </f:facet>
                    <h:commandLink action="#{ProdutoFaces.updateProduto}" value=" #{item.proNome}">
                        <f:setPropertyActionListener target="#{ProdutoFaces.selectedProduto}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Estoque"/>
                    </f:facet>
                    <h:outputText value="#{item.proEstoque}">
                        <f:convertNumber pattern="#,###,##0.000"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Uni. Med."/>
                    </f:facet>
                    <h:outputText value=" #{item.uniMedCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Quebra"/>
                    </f:facet>
                    <h:commandLink action="#{QuebraFaces.chamaQuebra}" value="Quebra">
                        <f:setPropertyActionListener target="#{QuebraFaces.selectedProduto}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
            </h:dataTable>
        </div>
    </h:form>
</f:view>
