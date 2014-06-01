<%@include file="tagLib.jsp" %>
<f:view>
    <c:if test="${FormaPagamentoFaces.selectedFormaPagamento.forPagDescricao == null}">
        <b id="titulo">Cadastro de Forma de Pagamentos!</b>
    </c:if>
    <c:if test="${FormaPagamentoFaces.selectedFormaPagamento.forPagDescricao != null}">
        <b id="titulo">Atualizar Forma de Pagamento!</b>
    </c:if>
    <div id="corFundo" style="width:40%">
        <h:form>

            Descrição: <h:inputText id="descricao" maxlength="20" required="true" requiredMessage="Informe a descrição" value="#{FormaPagamentoFaces.selectedFormaPagamento.forPagDescricao}"/>
            <b id="obrigatorio"> <h:message for="descricao"/> </b>
            <br/> <br/>
            <h:commandButton action="#{FormaPagamentoFaces.chamaFormaPagamento}" value="Cancelar" immediate="true"/>
            <h:commandButton action="#{FormaPagamentoFaces.finishFormaPagamento}" value="Salvar"/>
        </h:form>
    </div>
</f:view>
