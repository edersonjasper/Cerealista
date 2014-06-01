<%@include file="tagLib.jsp" %>
<f:view>
    <b id="titulo">Usuários!</b>
    <h:form>
        <h:commandButton action="#{UsuarioFaces.doAddUsuario}" value="Novo Registro"/>
        <div id="scroll">
            <h:dataTable border="1" var="usu" value="#{UsuarioFaces.cacheUsuarios}" styleClass="cinza">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Codigo"/>
                    </f:facet>
                    <h:outputText value="#{usu.usuCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Nome"/>
                    </f:facet>
                    <h:commandLink action="#{UsuarioFaces.updateUsuario}" value="#{usu.usuNome}">
                        <f:setPropertyActionListener target="#{UsuarioFaces.selectedUsuario}" value="#{usu}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Usuário"/>
                    </f:facet>
                    <h:outputText value="#{usu.usuUsuario}"/>
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Senha"/>
                    </f:facet>
                    <h:outputText value="#{usu.usuSenha}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Status"/>
                    </f:facet>
                    <h:outputText value="#{usu.usuStatus}"/>
                </h:column>
            </h:dataTable>
        </div>
    </h:form>
</f:view>
