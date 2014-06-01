<%@include file="tagLib.jsp" %>

<f:view>
    <b id="titulo">Pessoas!</b>
    <h:form>
        <h:commandButton action="#{PessoaFaces.addPessoa}" value="Novo Registro"/>
        <div id="scroll">
            <h:dataTable border="1" styleClass="cinza" value="#{PessoaFaces.cachedPessoa}" var="pes">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{pes.pesCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Nome"/>
                    </f:facet>
                    <h:commandLink action="#{PessoaFaces.updatePessoa}" value=" #{pes.pesNome}">
                        <f:setPropertyActionListener target="#{PessoaFaces.selectedPessoa}" value="#{pes}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Fis/Jur"/>
                    </f:facet>
                    <h:outputText value=" #{pes.pesTipo}"/>&nbsp;
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="CPF/CNPJ"/>
                    </f:facet>
                    <h:outputText value=" #{pes.pesCpfCnpj}"/>&nbsp;
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Insc. Est."/>
                    </f:facet>
                    <h:outputText value=" #{pes.pesIe}"/>&nbsp;
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Endereço"/>
                    </f:facet>
                    <h:outputText value=" #{pes.pesEndereco}"/>&nbsp;
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Número"/>
                    </f:facet>
                    <h:outputText value=" #{pes.pesNumero}"/>&nbsp;
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Bairro"/>
                    </f:facet>
                    <h:outputText value=" #{pes.pesBairro}"/>&nbsp;
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Cidade"/>
                    </f:facet>
                    <h:outputText value=" #{pes.cidCodigo.cidNome}"/>
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="CEP"/>
                    </f:facet>
                    <h:outputText value="#{pes.pesCep}"/>&nbsp;
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Dt. Nacto"/>
                    </f:facet>
                    <h:outputText value="#{pes.pesNascimento}">
                        <f:convertDateTime pattern="dd/MM/yyyy" />&nbsp;
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Oculto"/>
                    </f:facet>
                    <h:outputText value=" #{pes.pesOculto}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Sexo"/>
                    </f:facet>
                    <h:outputText value=" #{pes.pesSexo}"/>&nbsp;
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Usuário"/>
                    </f:facet>
                    <h:outputText value="#{pes.usuCodigo.usuNome}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Telefone"/>
                    </f:facet>
                    <h:commandLink action="#{TelefoneFaces.chamaTelefone}" value="Telefone">
                        <f:setPropertyActionListener target="#{TelefoneFaces.selectedPessoa}" value="#{pes}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Conta"/>
                    </f:facet>
                    <h:commandLink action="#{ContaFaces.chamaConta}" value="Conta">
                        <f:setPropertyActionListener target="#{ContaFaces.selectedPessoa}" value="#{pes}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Classificação"/>
                    </f:facet>
                    <h:commandLink action="#{PessoaCategoriafaces.chamaPessoaCategoria}" value="Classificação">
                        <f:setPropertyActionListener target="#{PessoaCategoriafaces.selectedPessoa}" value="#{pes}"/>
                    </h:commandLink>
                </h:column>
            </h:dataTable>
        </div>
    </h:form>
</f:view>
