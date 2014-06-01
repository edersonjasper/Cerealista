<%@include file="tagLib.jsp" %>

<f:view>
    <b id="titulo">Categoria de Pessoas!</b>
    <h:form>
        <h:commandButton action="#{PessoaFaces.chamaPessoa}" value="Voltar"/>
        <h:commandButton action="#{PessoaCategoriafaces.addPessoaCateforia}" value="Novo Registro"/>
        <div id="scroll">
            <h:dataTable border="1" styleClass="cinza" value="#{PessoaCategoriafaces.cachedPessoaCategoria}" var="item">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{item.pesCatCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Pessoa"/>
                    </f:facet>
                    <h:outputText value=" #{item.pesCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Categoria"/>
                    </f:facet>
                    <h:outputText value=" #{item.catCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Excluir"/>
                    </f:facet>
                    <h:commandLink action="#{PessoaCategoriafaces.removePessoacategoria}" value="Excluir">
                        <f:setPropertyActionListener target="#{PessoaCategoriafaces.selectedPessoaCategoria}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
            </h:dataTable>
        </div>
    </h:form>
</f:view>