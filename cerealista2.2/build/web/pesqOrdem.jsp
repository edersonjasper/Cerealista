
<%@include file="tagLib.jsp" %>
<f:view>
    <b id="titulo">Pesquisar Ordens!</b>
    <br/>
    <div id="scroll">
        <div  id="pesquisa">
            <br/>
            <form method="post" action="relOrdem">
                Código:<input type="text" size="5" name="ordCodigo" value="">
                <input type="submit" value="Imprimir">
                <br/>
            </form>
            <br/>
        </div>
        <h:form id="form">
            <div id="pesquisa" style="width: 80%">
                <br/>
                Aberta/Fechada: <h:selectOneMenu value="#{OrdemFaces.selectedOrdem.ordAberta}">
                    <f:selectItem itemValue="T" itemLabel="T"/>
                    <f:selectItem itemValue="A" itemLabel="A"/>
                    <f:selectItem itemValue="F" itemLabel="F"/>
                </h:selectOneMenu>
                Pessoa:<h:selectOneMenu value="#{OrdemFaces.selectedOrdem.pesCatCodigo}">
                    <f:selectItems value="#{PessoaCategoriafaces.pessoaCategoriaFornecedores}"/>
                    <f:converter converterId="PessoaCategoriaConverter"/>
                </h:selectOneMenu>
                <h:selectOneMenu value="#{OrdemFaces.todas}">
                    <f:selectItem itemValue="U" itemLabel="Somente o Selecionado"/>
                    <f:selectItem itemValue="T" itemLabel="Todos"/>
                </h:selectOneMenu>
                <p>
                    Data Abertura:<h:inputText size="10" onkeyup="formatar(this,'##/##/####')" maxlength="10" value="#{OrdemFaces.dataInicial}">
                        <f:convertDateTime pattern="dd/MM/yyyy"/>
                    </h:inputText>
                    até:<h:inputText size="10" onkeyup="formatar(this,'##/##/####')" maxlength="10" value="#{OrdemFaces.dataFinal}">
                        <f:convertDateTime pattern="dd/MM/yyyy"/>
                    </h:inputText>
                </p>
                <p>
                    Data de Vencimento:<h:inputText size="10" onkeyup="formatar(this,'##/##/####')" maxlength="10" value="#{OrdemFaces.dataIniVen}">
                        <f:convertDateTime pattern="dd/MM/yyyy"/>
                    </h:inputText>
                    até:<h:inputText size="10" onkeyup="formatar(this,'##/##/####')" maxlength="10" value="#{OrdemFaces.dataFinVen}">
                        <f:convertDateTime pattern="dd/MM/yyyy"/>
                    </h:inputText>
                </p>
                <h:commandButton action="#{OrdemFaces.chamaPesqOrdem}" value="Pesquisar"/>
                <br/>
                <br/>
            </div>
            <br/>
            <h:commandButton action="#{OrdemFaces.chamaOrdem}" value="Voltar a Ordens"/>

            <h:dataTable id="tab" border="1" styleClass="cinza" value="#{OrdemFaces.cachedPesqOrdem}" var="item">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText id="ordCodigo" value=" #{item.ordCodigo}"/>
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
                        <h:outputText value="Data Vencimento"/>
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
                        <f:convertNumber pattern="#,###,##0.000"/>
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
                        <h:outputText value="Fundo Rural"/>
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
                    <h:outputText value=" #{item.ordAberta}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Pago"/>
                    </f:facet>
                    <h:commandLink action="#{PagamentoOrdemFaces.chamaPagamentoOrdem}" value=" #{item.ordPago}">
                        <f:setPropertyActionListener target="#{PagamentoOrdemFaces.selectedOrdem}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Nota For."/>
                    </f:facet>
                    <h:outputText value=" #{item.ordNotaFornecedor}"/>&nbsp;
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Usuário"/>
                    </f:facet>
                    <h:outputText value=" #{item.usuCodigo}"/>
                </h:column>
            </h:dataTable>

            <br/>
            <div id="resultado">
                <b>
                    Valor Total:<h:outputText value="#{OrdemFaces.pesqTotal}">
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText> <br/>
                    Fundo Rural:<h:outputText value="#{OrdemFaces.pesqFunRuralTotal}">
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText> <br/>
                    Desconto:<h:outputText value="#{OrdemFaces.pesqDescontoTotal}">
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText> <br/>
                    Adiantamento:<h:outputText value="#{OrdemFaces.pesqAdiantamentoTotal}">
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText> <br/>
                    Valor Restante:<h:outputText value="#{OrdemFaces.pesqRestanteTotal}">
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText> <br/>
                </b>
            </div>
        </h:form>
    </div>
</f:view>
