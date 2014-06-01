<%@include file="tagLib.jsp" %>
        <f:view>
            <c:if test="${ProdutoVendaFaces.selectedProdutoVenda.proVenQuatidade == null}">
                <b id="titulo">Cadastro de Itens para a Venda!</b>
            </c:if>
            <c:if test="${ProdutoVendaFaces.selectedProdutoVenda.proVenQuatidade != null}">
                <b id="titulo">Atualizar Item da Venda!</b>
            </c:if>
                <h:form>
                    <c:if test="${ProdutoVendaFaces.selectedVenda.venFechada == 'A'}">
                       
                        Venda: <h:inputText size="10" disabled="true" value="#{ProdutoVendaFaces.selectedProdutoVenda.venCodigo.pesCatCodigo}"/>
                        Usuário: <h:selectOneMenu value="#{ProdutoVendaFaces.selectedProdutoVenda.usuCodigo}">
                            <f:selectItems value="#{UsuarioFaces.usuarios}"/>
                            <f:converter converterId="UsuarioConverter"/>
                        </h:selectOneMenu>
                        <br/> <br/>
                        Produto: <h:selectOneMenu value="#{ProdutoVendaFaces.selectedProdutoVenda.proCodigo}">
                            <f:selectItems value="#{ProdutoFaces.produto}"/>
                            <f:converter converterId="ProdutoConverter"/>
                        </h:selectOneMenu>

                        Quantidade: <h:inputText id="quantidade" size="10"  maxlength="10" required="true" requiredMessage="Informe a quantidade" value="#{ProdutoVendaFaces.selectedProdutoVenda.proVenQuatidade}">
                            <f:convertNumber pattern="#,###,##0.###"/>
                        </h:inputText>
                        <b id="obrigatorio"> <h:message for="quantidade"/></b>

                        Peso Unit.: <h:inputText id="unitario" size="10" maxlength="10" required="true" requiredMessage="Informe o peso unitário" value="#{ProdutoVendaFaces.selectedProdutoVenda.proVenPesoUnitario}">
                            <f:convertNumber pattern="#,###,##0.000"/>
                        </h:inputText>
                        <b id="obrigatorio"> <h:message for="unitario"/></b>
                        <br/> <br/>
                        Valor Unit.: <h:inputText id="valor" required="true" maxlength="10" size="10" requiredMessage="Informe o valor unitario" value="#{ProdutoVendaFaces.selectedProdutoVenda.proVenValorUnitario}">
                            <f:convertNumber pattern="#,###,##0.00"/>
                        </h:inputText>

                        Fornecedor: <h:selectOneMenu value="#{ProdutoVendaFaces.selectedProdutoVenda.proVenNomeFornecedor}">
                            <f:selectItems value="#{PessoaCategoriafaces.pessoaCategoriaFornecedores}"/>
                            <f:converter converterId="PessoaCategoriaConverter"/>
                        </h:selectOneMenu>

                        <br/><br/>
                        <h:commandButton action="#{ProdutoVendaFaces.chamaProdutoVenda}" value="Cancelar" immediate="true"/>
                        <h:commandButton action="#{ProdutoVendaFaces.finishAddProdutoVenda}" value="Salvar"/>
                    </c:if>
                    <c:if test="${ProdutoVendaFaces.selectedVenda.venFechada == 'F'}">
                        <h:commandButton action="#{ProdutoVendaFaces.chamaProdutoVenda}" value="Voltar" immediate="true"/>
                        <b style="width:150%">Esta Venda já esta fechada, portanto não poderá ser alterada!</b>
                    </c:if>
                </h:form>
        </f:view>
