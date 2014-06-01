<%@include file="tagLib.jsp" %>
<f:view>
    <c:if test="${DespesaFaces.selectedDespesa.desValor == null}">
        <b id="titulo">Cadastro de Despesas!</b>
    </c:if>
    <c:if test="${DespesaFaces.selectedDespesa.desValor != null}">
        <b id="titulo">Atualizar Despesa!</b>
    </c:if>
    <div>
        <h:form>
            Despesa: <h:selectOneMenu value="#{DespesaFaces.selectedDespesa.catDesCodigo}">
                <f:selectItems value="#{CategoriaDespesaFaces.categoriaDespesa}"/>
                <f:converter converterId="CategoriaDespesaConverter"/>
            </h:selectOneMenu>
            Valor: <h:inputText id="valor" size="8" maxlength="10" required="true" requiredMessage="Informe o valor" value="#{DespesaFaces.selectedDespesa.desValor}">
                <f:convertNumber pattern="#,###,##0.000"/>
            </h:inputText>
            <b id="obrigatorio"><h:message for="valor"/></b>
            <br/><br/>
            Descrição: <h:inputText id="descricao" maxlength="50" value="#{DespesaFaces.selectedDespesa.desDescricao}"/>
            <b id="obrigatorio"><h:message for="descricao"/></b>

            Data: <h:inputText size="8" disabled="true" value="#{DespesaFaces.selectedDespesa.desData}">
                <f:convertDateTime pattern="dd/MM/yyyy"/>
            </h:inputText>
            <br/><br/>
            Usuário: <h:selectOneMenu value="#{DespesaFaces.selectedDespesa.usuCodigo}">
                <f:selectItems value="#{UsuarioFaces.usuarios}"/>
                <f:converter converterId="UsuarioConverter"/>
            </h:selectOneMenu>
            <br/><br/>
            <h:commandButton action="#{DespesaFaces.chamaDespesa}" value="Cancelar" immediate="true"/>
            <h:commandButton action="#{DespesaFaces.finishAddDespesa}" value="Salvar"/>
        </h:form>
    </div>
</f:view>