<%@include file="tagLib.jsp" %>
<f:view>
    <c:if test="${UnidadeMedidaFaces.selectedUniMed.uniDescricao == null}">
        <b id="titulo">Cadastro de Unidades de Medidas!</b>
    </c:if>
    <c:if test="${UnidadeMedidaFaces.selectedUniMed.uniDescricao != null}">
        <b id="titulo">Atualizar Unidade de Medida!</b>
    </c:if>
    <h:form>
        <div>
            Descrição: <h:inputText id="descricao" maxlength="5" size="5" required="true" requiredMessage="Informe a descrição" value="#{UnidadeMedidaFaces.selectedUniMed.uniDescricao}"/>
            <b id="obrigatorio"><h:message for="descricao"/></b> <br/> <br/>

            <h:commandButton action="#{UnidadeMedidaFaces.chamaUnidadeMedida}" value="Cancelar" immediate="true"/>
            <h:commandButton action="#{UnidadeMedidaFaces.finishAddUnidadeMedida}" value="Salvar"/>
        </div>
    </h:form>
</f:view>