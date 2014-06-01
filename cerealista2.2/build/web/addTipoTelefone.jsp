<%@include file="tagLib.jsp" %>
<f:view>
    <c:if test="${TipoTelefoneFaces.selectedTipoTelefone.tipDescricao == null}">
        <b id="titulo">Cadastro de Tipo de Telefones!</b>
    </c:if>
    <c:if test="${TipoTelefoneFaces.selectedTipoTelefone.tipDescricao != null}">
        <b id="titulo">Atualizar Tipo de Telefone!</b>
    </c:if>
    <div>
        <h:form>
            Descrição:<h:inputText id="descricao" maxlength="20" required="true" requiredMessage="Informe a descrição" value="#{TipoTelefoneFaces.selectedTipoTelefone.tipDescricao}"/>
            <b id="obrigatorio"><h:message for="descricao"/> </b> <br/> <br/>
            <h:commandButton action="#{TipoTelefoneFaces.chamaTipoTelefone}" value="Cancelar" immediate="true"/>
            <h:commandButton action="#{TipoTelefoneFaces.finishAddTipoTelefone}" value="Salvar"/>
        </h:form>
    </div>
</f:view>
