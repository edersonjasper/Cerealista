
<%@include file="tagLib.jsp" %>

<f:view>
    <c:if test="#{BancoFaces.selectedBanco.banNome == null}">
        <b id="titulo">Cadastro de Bancos!</b>
    </c:if>
    <c:if test="#{BancoFaces.selectedBanco.banNome != null}">
        <b id="titulo">Atualizar Banco!</b>
    </c:if>
    <div id="corFundo" style="width:40%">
        <h:form>

            Nome: <h:inputText id="nome" maxlength="30" required="true" requiredMessage="Informe o nome" value="#{BancoFaces.selectedBanco.banNome}"/>
            <b id="obrigatorio"> <h:message for="nome"/> </b>
            <br/><br/>
            <h:commandButton action="#{BancoFaces.chamaBanco}" value="Cancelar" immediate="true"/>
            <h:commandButton action="#{BancoFaces.finishAddBanco}" value="Salvar"/>
        </h:form>
    </div>
</f:view>
