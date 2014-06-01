<%@include file="tagLib.jsp" %>
<f:view>
    <c:if test="${HorasTrabalhadasFaces.selectedHorasTrabalhadas.horTraHorasTrabalhadas == null}">
        <b id="titulo">Cadastro de Horas Trabalhadas!</b>
    </c:if>
    <c:if test="${HorasTrabalhadasFaces.selectedHorasTrabalhadas.horTraHorasTrabalhadas != null}">
        <b id="titulo">Atualizar Horas Trabalahdas!</b>
    </c:if>
    <div id="corFundo" style="width:60%">
        <h:form>
            <h:messages/>

            Pessoa: <h:selectOneMenu value="#{HorasTrabalhadasFaces.selectedHorasTrabalhadas.pesCatCodigo}">
                <f:selectItems value="#{PessoaCategoriafaces.pessoaCategoriaFuncionarios}"/>
                <f:converter converterId="PessoaCategoriaConverter"/>
            </h:selectOneMenu>

            Data: <h:inputText disabled="true" size="10" value="#{HorasTrabalhadasFaces.selectedHorasTrabalhadas.horTraData}">
                <f:convertDateTime pattern="dd/MM/yyyy"/>
            </h:inputText>
            <br/><br/>
            Valor Hora:<h:inputText id="valor" required="true" size="10" maxlength="10" requiredMessage="Informe o valor da hora" value="#{HorasTrabalhadasFaces.selectedHorasTrabalhadas.horTraValorHora}">
                <f:convertNumber pattern="###,##0.00"/>
            </h:inputText>
            <b id="obrigatorio"> <h:message for="valor"/></b>

            Horas Trabalhadas:<h:inputText id="horas" required="true" size="10" maxlength="10" requiredMessage="Informe horas trabalhadas" value="#{HorasTrabalhadasFaces.selectedHorasTrabalhadas.horTraHorasTrabalhadas}">
                <f:convertNumber pattern="###,##0.00"/>
            </h:inputText>
            <b id="obrigatorio"> <h:message for="horas"/></b>
            <br/><br/>
            Descrição:<h:inputText maxlength="50" value="#{HorasTrabalhadasFaces.selectedHorasTrabalhadas.horTraDescricao}"/>
            <br/><br/>
            <h:commandButton action="#{HorasTrabalhadasFaces.chamaHorasTrabalhadas}" value="Cancelar" immediate="true"/>
            <h:commandButton action="#{HorasTrabalhadasFaces.finishAddHorasTrabalhadas}" value="Salvar"/>
        </h:form>
    </div>
</f:view>
