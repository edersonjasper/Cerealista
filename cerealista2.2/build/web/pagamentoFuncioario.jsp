<%@include file="tagLib.jsp" %>
<f:view>
    <b id="titulo">Pagamento de Funcionários!</b>

    <div id="scroll">
        <div id="pesquisa">
            <br/>
            <form name="formRel" action="relPagamentoFuncionario" method="post">
                Data:<input type="text" onkeyup="formatar(this,'##/##/####')" name="dataIni" value="" size="8"/>
                até <input type="text" onkeyup="formatar(this,'##/##/####')" name="dataFin" value="" size="8"/>
                <br/>
                <br/>
                <input type="submit" value="Relatório" name="bntRel"/>
            </form>
        </div>
        <h:form>
            <div id="pesquisa">
                <br/>
                Funcionário:<h:selectOneMenu value="#{PagamentoFuncionarioFaces.selectedPagamentoFuncionario.pesCatCodigo}">
                    <f:selectItems value="#{PessoaCategoriafaces.pessoaCategoriaFuncionarios}"/>
                    <f:converter converterId="PessoaCategoriaConverter"/>
                </h:selectOneMenu>
                <br/>
                <br/>
                Data Inicial:<h:inputText size="10" onkeyup="formatar(this,'##/##/####')" maxlength="10" value="#{PagamentoFuncionarioFaces.dataInicial}">
                    <f:convertDateTime pattern="dd/MM/yyyy"/>
                </h:inputText>
                Data Final:<h:inputText size="10" onkeyup="formatar(this,'##/##/####')" maxlength="10" value="#{PagamentoFuncionarioFaces.dataFinal}">
                    <f:convertDateTime pattern="dd/MM/yyyy"/>
                </h:inputText>
                <h:commandButton action="#{PagamentoFuncionarioFaces.chamaPagamentoFuncionario}" value="Pesqusiar"/>
                <br/>
                <br/>
            </div>
            <h:commandButton action="#{PagamentoFuncionarioFaces.addPagamentoFuncionario}" value="Novo Registro"/>
            <h:dataTable border="1" styleClass="cinza" value="#{PagamentoFuncionarioFaces.cachedPagamentoFuncionario}" var="item">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{item.pagFunCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Pessoa"/>
                    </f:facet>
                    <h:commandLink action="#{PagamentoFuncionarioFaces.updatePagamentoFuncionario}" value=" #{item.pesCatCodigo.pesCodigo}">
                        <f:setPropertyActionListener target="#{PagamentoFuncionarioFaces.selectedPagamentoFuncionario}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Data"/>
                    </f:facet>
                    <h:outputText value="#{item.pagFunData}">
                        <f:convertDateTime pattern="dd/MM/yyyy" />
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Valor"/>
                    </f:facet>
                    <h:outputText value="#{item.pagFunValor}">
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

            <div id="resultado">
                <b> Total:</b><h:outputText value="#{PagamentoFuncionarioFaces.total}">
                    <f:convertNumber type="currency" currencySymbol="R$"/>
                </h:outputText>

            </div>
        </h:form>
    </div>
</f:view>
