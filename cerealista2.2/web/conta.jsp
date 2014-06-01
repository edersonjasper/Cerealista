<%@include file="tagLib.jsp" %>

<f:view>
    <b id="titulo">Conta!</b>
    <h:form>
        <h:commandButton action="#{PessoaFaces.chamaPessoa}" value="Voltar"/>
        <h:commandButton action="#{ContaFaces.addConta}" value="Novo Registro"/>
        <div id="scroll">
            <h:dataTable border="1" styleClass="cinza" value="#{ContaFaces.cachedConta}" var="item">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{item.conCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Pessoa"/>
                    </f:facet>
                    <h:outputText value=" #{item.pesCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Nome"/>
                    </f:facet>
                    <h:outputText value=" #{item.conNomeDeposito}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Banco"/>
                    </f:facet>
                    <h:outputText value=" #{item.banCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="N. Conta"/>
                    </f:facet>
                    <h:commandLink action="#{ContaFaces.updateConta}" value=" #{item.conNumeroConta}">
                        <f:setPropertyActionListener target="#{ContaFaces.selectedConta}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Agência"/>
                    </f:facet>
                    <h:outputText value=" #{item.conAgencia}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="N. Banco"/>
                    </f:facet>
                    <h:outputText value=" #{item.conNumeroBanco}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Operação"/>
                    </f:facet>
                    <h:outputText value=" #{item.conOperacao}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Excluir"/>
                    </f:facet>
                    <h:commandLink action="#{ContaFaces.removeConta}" value="Excluir">
                        <f:setPropertyActionListener target="#{ContaFaces.selectedConta}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
            </h:dataTable>
        </div>
    </h:form>
</f:view>