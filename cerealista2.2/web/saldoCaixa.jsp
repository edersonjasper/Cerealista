<%@include file="tagLib.jsp" %>
<f:view>
    <h:form>
        <h4 align="right">
            Usuário: <h:outputText value="#{UsuarioFaces.usuario}"/>
        </h4>
        <b id="titulo">Saldo em Caixa!</b>
        <br/>
        <div id="scroll">
            <h:dataTable border="1" styleClass="cinza" value="#{SaldoCaixaFaces.cachedSaldoCaixa}" var="item">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{item.salCaiCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Data"/>
                    </f:facet>
                    <h:outputText value="#{item.salCaiData}">
                        <f:convertDateTime pattern="dd/MM/yyyy" />
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Valor"/>
                    </f:facet>
                    <h:outputText value="#{item.salCaiValor}">
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Ação"/>
                    </f:facet>
                    <h:outputText value="#{item.salCaiTabela}"/>&nbsp;
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Excluir"/>
                    </f:facet>
                    <h:commandLink action="#{SaldoCaixaFaces.removeSaldoCaixa}" value="Excluir">
                        <f:setPropertyActionListener target="#{SaldoCaixaFaces.selectedSaldoCaixa}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
            </h:dataTable>
        </div>
    </h:form>
</f:view>
