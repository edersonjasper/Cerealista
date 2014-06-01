<%@include file="tagLib.jsp" %>
<f:view>
    <b id="titulo">Telefones!</b>
    <h:form>
        <h:commandButton action="#{PessoaFaces.chamaPessoa}" value="Voltar"/>
        <h:commandButton action="#{TelefoneFaces.addTelefone}" value="Novo Registro"/>
        <div id="scroll">
            <h:dataTable border="1" styleClass="cinza" value="#{TelefoneFaces.cachedTelefone}" var="tel">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{tel.telCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Pessoa"/>
                    </f:facet>
                    <h:outputText value=" #{tel.pesCodigo.pesNome}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Contato"/>
                    </f:facet>
                    <h:outputText value=" #{tel.telContato}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Número"/>
                    </f:facet>
                    <h:commandLink action="#{TelefoneFaces.updateTelefone}" value=" #{tel.telNumero}">
                        <f:setPropertyActionListener target="#{TelefoneFaces.selectedTelefone}" value="#{tel}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Telefone"/>
                    </f:facet>
                    <h:outputText value=" #{tel.tipCodigo.tipDescricao}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Excluir"/>
                    </f:facet>
                    <h:commandLink action="#{TelefoneFaces.removeTelefone}" value="Excluir">
                        <f:setPropertyActionListener target="#{TelefoneFaces.selectedTelefone}" value="#{tel}"/>
                    </h:commandLink>
                </h:column>
            </h:dataTable>
        </div>
    </h:form>
</f:view>