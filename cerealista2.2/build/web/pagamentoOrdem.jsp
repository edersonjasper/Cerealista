

<%@include file="tagLib.jsp" %>
<f:view>
    <b id="titulo">Pagamentos de Ordens!</b>
    <h:form>
        <h:commandButton action="#{OrdemFaces.chamaPesqOrdem}" value="Voltar a Pesquisa de Ordens"/>
        <c:if test="${PagamentoOrdemFaces.selectedOrdem.ordAberta == 'A'}">
            <br/>
            <b style="font-size:150%;">A Ordem deverá estar fechada para pagamento!</b>
        </c:if>
        <c:if test="${PagamentoOrdemFaces.selectedOrdem.ordAberta == 'F'}">
            <h:commandButton action="#{PagamentoOrdemFaces.addPagamentoOrdem}" value="Novo Registro"/>
            <div id="scroll">
                <h:dataTable border="1" styleClass="cinza" value="#{PagamentoOrdemFaces.cachedPagamentoOrdem}" var="item">
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Código"/>
                        </f:facet>
                        <h:outputText value=" #{item.pagOrdCodigo}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Ordem"/>
                        </f:facet>
                        <h:outputText value=" #{item.ordCodigo.pesCatCodigo.pesCodigo}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Forma Pag."/>
                        </f:facet>
                        <h:outputText value=" #{item.forPagCodigo}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Data"/>
                        </f:facet>
                        <h:outputText value="#{item.pagOrdData}">
                            <f:convertDateTime pattern="dd/MM/yyyy" />
                        </h:outputText>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Valor"/>
                        </f:facet>
                        <h:outputText value="#{item.pagOrdValor}">
                            <f:convertNumber type="currency" currencySymbol="R$"/>
                        </h:outputText>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Valor Acumulado"/>
                        </f:facet>
                        <h:outputText value="#{item.pagOrdValorAcumulado}">
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
            </c:if>
        </div>
    </h:form>
</f:view>

