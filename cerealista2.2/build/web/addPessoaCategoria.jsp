<%@include file="tagLib.jsp" %>
<f:view>
    <c:if test="${PessoaCategoriafaces.selectedPessoaCategoria.pesCodigo == null}">
        <b id="titulo">Cadastro de Pessoas com Categorias!</b>
    </c:if>
    <c:if test="${PessoaCategoriafaces.selectedPessoaCategoria.pesCodigo != null}">
        <b id="titulo">Atualizar Pessoas em Categorias!</b>
    </c:if>
    <div id="corFundo" style="width:50%">
        <h:form>
            Pessoa: <h:outputText value="#{PessoaCategoriafaces.selectedPessoaCategoria.pesCodigo.pesNome}"/>

            Categoria: <h:selectOneMenu value="#{PessoaCategoriafaces.selectedPessoaCategoria.catCodigo}">
                <f:selectItems value="#{PessoaCategoriafaces.categoria}"/>
                <f:converter converterId="CategoriaConverter"/>
            </h:selectOneMenu>
            <br/><br/>
            <h:commandButton action="#{PessoaCategoriafaces.chamaPessoaCategoria}" value="Cancelar"/>
            <h:commandButton action="#{PessoaCategoriafaces.finishAddCategoria}" value="Salvar"/>
        </h:form>
    </div>
</f:view>