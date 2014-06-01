<%@include file="tagLib.jsp" %>
<f:view>
    <c:if test="${VeiculoFaces.selectedVeiculo.veiPlaca == null}">
        <b id="titulo">Cadastro de Veículos!</b>
    </c:if>
    <c:if test="${VeiculoFaces.selectedVeiculo.veiPlaca != null}">
        <b id="titulo">Atualizar Veículo!</b>
    </c:if>
    <div>
        <h:form>
            Pessoa: <h:selectOneMenu value="#{VeiculoFaces.selectedVeiculo.pesCatCodigo}">
                <f:selectItems value="#{PessoaCategoriafaces.pessoaCategoriaTransportadora}"/>
                <f:converter converterId="PessoaCategoriaConverter"/>
            </h:selectOneMenu>

            Veículo: <h:inputText id="veiculo" required="true" maxlength="30" requiredMessage="Informe o veículo" value="#{VeiculoFaces.selectedVeiculo.veiVeiculo}"/>
            <b id="obrigatorio"><h:message for="veiculo"/></b>
            <br/><br/>
            <c:if test="${VeiculoFaces.selectedVeiculo.veiPlaca != null}">
                Placa: <h:inputText id="placa" disabled="true" size="8" required="true" requiredMessage="Informe a placa" value="#{VeiculoFaces.selectedVeiculo.veiPlaca}"/>
            </c:if>
            <c:if test="${VeiculoFaces.selectedVeiculo.veiPlaca == null}">
                Placa: <h:inputText id="placa" maxlength="8" size="8" required="true" onkeyup="formatar(this,'### ####')" requiredMessage="Informe a placa" value="#{VeiculoFaces.selectedVeiculo.veiPlaca}"/>
            </c:if>
            <b id="obrigatorio"><h:message for="placa"/></b>
            Cidade: <h:selectOneMenu value="#{VeiculoFaces.selectedVeiculo.cidCodigo}">
                <f:selectItems value="#{CidadeFaces.cidades}"/>
                <f:converter converterId="CidadeConverter"/>
            </h:selectOneMenu>
            <br/><br/>
            <h:commandButton action="#{VeiculoFaces.chamaVeiculo}" value="Cancelar" immediate="true"/>
            <h:commandButton action="#{VeiculoFaces.finishAddVeiculo}" value="Salvar"/>
        </h:form>
    </div>
</f:view>
