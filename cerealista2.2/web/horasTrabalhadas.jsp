<%@include file="tagLib.jsp" %>

<f:view>           
    <b id="titulo">Horas Trabalhadas!</b>
    <h:form>
        <div id="scroll">
            <div id="pesquisa">
                <br/>
                Funcionário:<h:selectOneMenu value="#{HorasTrabalhadasFaces.selectedHorasTrabalhadas.pesCatCodigo}">
                    <f:selectItems value="#{PessoaCategoriafaces.pessoaCategoriaFuncionarios}"/>
                    <f:converter converterId="PessoaCategoriaConverter"/>
                </h:selectOneMenu>
                <br/>
                <br/>
                Data: <h:inputText size="10" value="#{HorasTrabalhadasFaces.dataIni}">
                    <f:convertDateTime pattern="dd/MM/yyyy"/>
                </h:inputText>
                até: <h:inputText size="10" value="#{HorasTrabalhadasFaces.dataFin}">
                    <f:convertDateTime pattern="dd/MM/yyyy"/>
                </h:inputText>
                <h:commandButton action="#{HorasTrabalhadasFaces.chamaHorasTrabalhadas}" value="Pesquisar"/>
                <br/>
                <br/>
            </div>
            <h:commandButton action="#{HorasTrabalhadasFaces.addHorasTrabalhadas}" value="Novo Registro"/>

            <h:dataTable styleClass="cinza" border="1" value="#{HorasTrabalhadasFaces.cachedHorastrabalhadas}" var="item">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Código"/>
                    </f:facet>
                    <h:outputText value=" #{item.horTraCodigo}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Pessoa"/>
                    </f:facet>
                    <h:commandLink action="#{HorasTrabalhadasFaces.updateHorasTrabalhadas}" value=" #{item.pesCatCodigo.pesCodigo}- #{item.pesCatCodigo.catCodigo}">
                        <f:setPropertyActionListener target="#{HorasTrabalhadasFaces.selectedHorasTrabalhadas}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Data"/>
                    </f:facet>
                    <h:outputText value="#{item.horTraData}">
                        <f:convertDateTime pattern="dd/MM/yyyy" />
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Descrição"/>
                    </f:facet>
                    <h:outputText value=" #{item.horTraDescricao}"/> &nbsp;
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Horas Trabalhadas"/>
                    </f:facet>
                    <h:outputText value="#{item.horTraHorasTrabalhadas}">
                        <f:convertNumber pattern="###,##0.00"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Valor p/ Hora"/>
                    </f:facet>
                    <h:outputText value="#{item.horTraValorHora}">
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Valor Total"/>
                    </f:facet>
                    <h:outputText value="#{item.horTraValorTotal}">
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Excluir"/>
                    </f:facet>
                    <h:commandLink action="#{HorasTrabalhadasFaces.removeHorasTrabalhadas}" value="Excluir">
                        <f:setPropertyActionListener target="#{HorasTrabalhadasFaces.selectedHorasTrabalhadas}" value="#{item}"/>
                    </h:commandLink>
                </h:column>
            </h:dataTable>
            <div id="resultado">
                <b>
                    Total:<h:outputText value="#{HorasTrabalhadasFaces.total}">
                        <f:convertNumber type="currency" currencySymbol="R$"/>
                    </h:outputText> <br/>
                    Horas:<h:outputText value="#{HorasTrabalhadasFaces.horas}"/>
                </b>
            </div>
        </div>
    </h:form>
</f:view>