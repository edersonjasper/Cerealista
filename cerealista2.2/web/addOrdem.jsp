<%@include file="tagLib.jsp" %>
<f:view>
    <c:if test="${OrdemFaces.selectedOrdem.pesCatCodigo == null}">
        <b id="titulo">Cadastro de Ordens!</b>
    </c:if>
    <c:if test="${OrdemFaces.selectedOrdem.pesCatCodigo != null}">
        <b id="titulo">Atualizar Ordem!</b>
    </c:if>
    <div>
        <h:form>
            <h:messages/>

            Usuário:<h:selectOneMenu id="usuario" value="#{OrdemFaces.selectedOrdem.usuCodigo}">
                <f:selectItems value="#{UsuarioFaces.usuarios}"/>
                <f:converter converterId="UsuarioConverter"/>
                <b id="obrigatorio"><h:message for="usuario"/></b>
            </h:selectOneMenu>

            Fornecedor:<h:selectOneMenu id="pessoa" value="#{OrdemFaces.selectedOrdem.pesCatCodigo}">
                <f:selectItems value="#{PessoaCategoriafaces.pessoaCategoriaFornecedores}"/>
                <f:converter converterId="PessoaCategoriaConverter"/>
            </h:selectOneMenu>
            <b id="obrigatorio"><h:message for="pessoa"/></b>
            Data: <h:inputText id="data" size="8" maxlength="10" required="true" requiredMessage="Informe a data" disabled="true" value="#{OrdemFaces.selectedOrdem.ordData}">
                <f:convertDateTime pattern="dd/MM/yyyy"/>
            </h:inputText>
            <b id="obrigatorio"><h:message for="data"/></b>
            <br/><br/>
            Data Vencimento: <h:inputText id="vencimento" size="8" maxlength="10" onkeyup="formatar(this,'##/##/####')" required="true" requiredMessage="Informe a data de vencimento" value="#{OrdemFaces.selectedOrdem.ordDataVencimento}">
                <f:convertDateTime pattern="dd/MM/yyyy"/>
            </h:inputText>
            <b id="obrigatorio"><h:message for="vencimento"/></b>

            Peso total: <h:inputText disabled="true" size="10" value="#{OrdemFaces.selectedOrdem.ordPesoTotal}">
                <f:convertNumber pattern="#,###,##0.000"/>
            </h:inputText>

            Valor total: <h:inputText disabled="true" size="10" value="#{OrdemFaces.selectedOrdem.ordValorTotal}">
                <f:convertNumber pattern="#,###,##0.00"/>
            </h:inputText>
            <br/><br/>
            fundo Rural: <h:inputText id="fundo" size="10" maxlength="10" value="#{OrdemFaces.selectedOrdem.ordFundoRural}">
                <f:convertNumber pattern="#,###,##0.00"/>
            </h:inputText>

            Desconto: <h:inputText id="desconto" size="10" maxlength="10" value="#{OrdemFaces.selectedOrdem.ordDesconto}">
                <f:convertNumber pattern="#,###,##0.00"/>
            </h:inputText>

            Adiantamento: <h:inputText size="10" maxlength="10" value="#{OrdemFaces.selectedOrdem.ordAdiantemento}">
                <f:convertNumber pattern="#,###,##0.00"/>
            </h:inputText>
            <br/><br/>
            Nota Fornecedor: <h:inputText size="10" maxlength="10" value="#{OrdemFaces.selectedOrdem.ordNotaFornecedor}"/>
            Aberta/Fechada: <h:selectOneMenu value="#{OrdemFaces.selectedOrdem.ordAberta}">
                <f:selectItems value="#{OrdemFaces.aberta}"/>
            </h:selectOneMenu>
            <br/><br/>
            <h:commandButton action="#{OrdemFaces.chamaOrdem}" value="Cancelar" immediate="true" />
            <h:commandButton action="#{OrdemFaces.finishAddOrdem}" value="Salvar" />
        </h:form>
    </div>
</f:view>
