<%@include file="tagLib.jsp" %>
<f:view>
    <b id="titulo">Caixa!</b>
    <h:form>
        <div id="pesquisa">
            <br/>
           
            Data Inicial:<h:inputText size="10" onkeyup="formatar(this,'##/##/####')" maxlength="10" value="#{CaixaFaces.dataIni}">
                <f:convertDateTime pattern="dd/MM/yyyy"/>
            </h:inputText>
            Data Final:<h:inputText size="10" onkeyup="formatar(this,'##/##/####')" maxlength="10" value="#{CaixaFaces.dataFin}">
                <f:convertDateTime pattern="dd/MM/yyyy"/>
            </h:inputText>
            <h:commandButton action="#{CaixaFaces.chamaCaixa}" value="Pesquisar"/>
            <br/>
            <br/>
        </div>
        <h:commandButton action="#{CaixaFaces.addCaixa}" value="Novo Registro"/>
        <div id="scroll">
            <h:dataTable border="1" styleClass="cinza" value="#{CaixaFaces.cachedCaixa}" var="item">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{item.caiCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Data"/>
                    </f:facet>
                    <h:outputText value="#{item.caiData}">
                        <f:convertDateTime pattern="dd/MM/yyyy" />
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Valor Depositado"/>
                    </f:facet>
                    <h:commandLink action="#{CaixaFaces.updateCaixa}" value="R$ #{item.caiValorDepositado}">
                        <f:setPropertyActionListener target="#{CaixaFaces.selectedCaixa}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Cliente"/>
                    </f:facet>
                    <h:outputText value="#{item.pesCatCodigo.pesCodigo.pesNome}"/>&nbsp;
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Usuário"/>
                    </f:facet>
                    <h:outputText value=" #{item.usuCodigo}"/>
                </h:column>
            </h:dataTable>
            <div id="resultado">
                <b> Total:</b><h:outputText value="#{CaixaFaces.total}">
                    <f:convertNumber type="currency" currencySymbol="R$"/>
                </h:outputText>

            </div>
        </div>
    </h:form>
</f:view>