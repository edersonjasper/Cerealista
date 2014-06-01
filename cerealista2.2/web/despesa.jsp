<%@include file="tagLib.jsp" %>
<f:view>
    <b id="titulo">Despesas!</b>
    <div id="pesquisa">
        <br/>
        <form name="formRel" action="relDespesa" method="post">
            Data:<input type="text" onkeyup="formatar(this,'##/##/####')" name="dataIni" value="" size="8"/>
            at� <input type="text" onkeyup="formatar(this,'##/##/####')" name="dataFin" value="" size="8"/>
            <br/>
            <br/>
            <input type="submit" value="Relat�rio" name="bntRel"/>
        </form>
    </div>
    <h:form id="form">
        <h:commandButton action="gotoMain" value="Voltar"/>
        <h:commandButton action="#{DespesaFaces.addDespesa}" value="Novo Registro"/>



        <div id="scroll">
            <h:dataTable border="1" styleClass="cinza" value="#{DespesaFaces.cachedDespesa}" var="item">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="C�digo"/>
                    </f:facet>
                    <h:outputText value=" #{item.desCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Despesa"/>
                    </f:facet>
                    <h:commandLink action="#{DespesaFaces.updateDespesa}" value=" #{item.catDesCodigo}">
                        <f:setPropertyActionListener target="#{DespesaFaces.selectedDespesa}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Data"/>
                    </f:facet>
                    <h:outputText value="#{item.desData}">
                        <f:convertDateTime pattern="dd/MM/yyyy" />
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Descri��o"/>
                    </f:facet>
                    <h:outputText value=" #{item.desDescricao}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Valor"/>
                    </f:facet>
                    <h:outputText value="#{item.desValor}">
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Usu�rio"/>
                    </f:facet>
                    <h:outputText value=" #{item.usuCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Excluir"/>
                    </f:facet>
                    <h:commandLink action="#{DespesaFaces.removeDespesa}" value="Excluir">
                        <f:setPropertyActionListener target="#{DespesaFaces.selectedDespesa}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
            </h:dataTable>
        </div>
    </h:form>
</f:view>
