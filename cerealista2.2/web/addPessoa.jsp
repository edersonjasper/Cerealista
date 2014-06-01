<%@include file="tagLib.jsp" %>
<f:view>
    <c:if test="${PessoaFaces.selectedPessoa.pesNome == null}">
        <b id="titulo">Cadastro de Pessoas!</b>
    </c:if>
    <c:if test="${PessoaFaces.selectedPessoa.pesNome != null}">
        <b id="titulo">Atualizar Pessoa!</b>
    </c:if>
    <h:form>
        Nome: <h:inputText id="nome" required="true" maxlength="40" requiredMessage="Informe o nome" value="#{PessoaFaces.selectedPessoa.pesNome}"/>
        <b id="obrigatorio"> <h:message for="nome"/> </b>

        Sexo: <h:selectOneMenu id="sexo" value="#{PessoaFaces.selectedPessoa.pesSexo}">
            <f:selectItems value="#{PessoaFaces.sexo}"/>
        </h:selectOneMenu>

        Fisica/Juridica: <h:selectOneMenu id="tipo" value="#{PessoaFaces.selectedPessoa.pesTipo}">
            <f:selectItems value="#{PessoaFaces.tipoPessoa}"/>
        </h:selectOneMenu> <br/> <br/>

        CPF/CNPJ: <h:inputText id="cpf" size="15" maxlength="18" required="true" requiredMessage="Informe o CPF ou CNPJ" value="#{PessoaFaces.selectedPessoa.pesCpfCnpj}"/>
        <b id="obrigatorio"> <h:message for="cpf"/> </b>


        Insc. Estadual: <h:inputText id="ie" size="15" maxlength="11" required="false" requiredMessage="Informe a Isnc. Estadual" value="#{PessoaFaces.selectedPessoa.pesIe}"/>
        <b id="obrigatorio"> <h:message for="ie"/> </b>

        Endereço: <h:inputText id="endereco" required="true" maxlength="50" requiredMessage="Informe o endereco" value="#{PessoaFaces.selectedPessoa.pesEndereco}"/>
        <b id="obrigatorio"> <h:message for="endereco"/> </b> <br/><br/>

        Número: <h:inputText id="numero" size="5" required="false" maxlength="6" requiredMessage="Informe o número" value="#{PessoaFaces.selectedPessoa.pesNumero}"/>
        <b id="obrigatorio"> <h:message for="numero"/> </b>

        Bairro: <h:inputText id="bairro" required="true" maxlength="40" requiredMessage="Informe o bairro" value="#{PessoaFaces.selectedPessoa.pesBairro}"/>
        <b id="obrigatorio"> <h:message for="bairro"/> </b>

        Cidade: <h:selectOneMenu id="cidade" value="#{PessoaFaces.selectedPessoa.cidCodigo}">
            <f:selectItems value="#{CidadeFaces.cidades}"/>
            <f:converter converterId="CidadeConverter"/>
        </h:selectOneMenu>

        CEP: <h:inputText id="cep" size="10" required="true" maxlength="9" onkeypress="formatar(this,'#####-###')" requiredMessage="Informe o CEP" value="#{PessoaFaces.selectedPessoa.pesCep}"/>
        <b id="obrigatorio"> <h:message for="cep"/> </b> <br/><br/>

        Data de Nasct.: <h:inputText id="nascimento" size="10" maxlength="10" onkeypress="formatar(this,'##/##/####')" required="false" requiredMessage="Informe a data de Nascimento" value="#{PessoaFaces.selectedPessoa.pesNascimento}">
            <f:convertDateTime pattern="dd/MM/yyyy"/>
        </h:inputText>
        <b id="obrigatorio"> <h:message for="nascimento"/> </b>

        Usuario: <h:selectOneMenu id="usuario" value="#{PessoaFaces.selectedPessoa.usuCodigo}">
            <f:selectItems value="#{UsuarioFaces.usuarios}"/>
            <f:converter converterId="UsuarioConverter"/>
        </h:selectOneMenu> <h:message for="usuario"/>

        Oculto: <h:selectOneMenu id="oculto" value="#{PessoaFaces.selectedPessoa.pesOculto}">
            <f:selectItems value="#{PessoaFaces.oculto}"/>
        </h:selectOneMenu>
        <b id="obrigatorio"> <h:message for="tipo"/> </b>
        <br/><br/>
        <h:commandButton action="#{PessoaFaces.chamaPessoa}" value="Cancelar" immediate="true"/>
        <h:commandButton action="#{PessoaFaces.finishAddPessoa}" value="Salvar"/>
    </h:form>
</f:view>
