<%@include file="tagLib.jsp" %>
<%
            String id = "";
            if (request.getParameter("id") != null) {
                id = request.getParameter("id");
                session.setAttribute("id", id);
            }else if(session.getAttribute("id") != null){
               id = (String) session.getAttribute("id");
                }
            if (!id.equals("")) {
                if (id.equals("banco")) {
                    %><%@include file="banco.jsp" %><%
                } else if (id.equals("addBanco")) {
                    %><%@include file="addBanco.jsp" %><%
                } else if (id.equals("categoriaDespesa")) {
                    %><%@include file="categoriaDespesa.jsp" %><%
                } else if (id.equals("addCategoriaDespesa")) {
                    %><%@include file="addCategoriaDespesa.jsp" %><%
                } else if (id.equals("cidade")) {
                    %><%@include file="cidade.jsp" %><%
                } else if (id.equals("addCidade")) {
                    %><%@include file="addCidade.jsp" %><%
                } else if (id.equals("despesa")) {
                    %><%@include file="despesa.jsp" %><%
                } else if (id.equals("addDespesa")) {
                    %><%@include file="addDespesa.jsp" %><%
                } else if (id.equals("horasTrabalhadas")) {
                    %><%@include file="horasTrabalhadas.jsp" %><%
                } else if (id.equals("addHorasTrabalhadas")) {
                    %><%@include file="addHorastrabalhadas.jsp" %><%
                } else if (id.equals("ordem")) {
                    %><%@include file="ordem.jsp" %><%
                } else if (id.equals("addOrdem")) {
                    %><%@include file="addOrdem.jsp" %><%
                } else if (id.equals("pagamentoFuncionario")) {
                    %><%@include file="pagamentoFuncioario.jsp" %><%
                } else if (id.equals("addPagamentoFuncionario")) {
                    %><%@include file="addPagamentoFuncionario.jsp" %><%
                } else if (id.equals("pessoa")) {
                    %><%@include file="pessoa.jsp" %><%
                } else if (id.equals("addPessoa")) {
                    %><%@include file="addPessoa.jsp" %><%
                } else if (id.equals("produto")) {
                    %><%@include file="produto.jsp" %><%
                } else if (id.equals("addProduto")) {
                    %><%@include file="addProduto.jsp" %><%
                } else if (id.equals("quebra")) {
                    %><%@include file="quebra.jsp" %><%
                } else if (id.equals("addQuebra")) {
                    %><%@include file="addQuebra.jsp" %><%
                } else if (id.equals("veiculo")) {
                    %><%@include file="veiculo.jsp" %><%
                } else if (id.equals("addVeiculo")) {
                    %><%@include file="addVeiculo.jsp" %><%
                } else if (id.equals("tipoTelefone")) {
                    %><%@include file="tipoTelefone.jsp" %><%
                } else if (id.equals("addTipoTelefone")) {
                    %><%@include file="addTipoTelefone.jsp" %><%
                } else if (id.equals("unidadeMedida")) {
                    %><%@include file="unidadeMedida.jsp" %><%
                } else if (id.equals("addUnidadeMedida")) {
                    %><%@include file="addUnidadeMedida.jsp" %><%
                } else if (id.equals("caixa")) {
                    %><%@include file="caixa.jsp" %><%
                } else if (id.equals("addCaixa")) {
                    %><%@include file="addCaixa.jsp" %><%
                } else if (id.equals("formaPagamento")) {
                    %><%@include file="formaPagamento.jsp" %><%
                } else if (id.equals("addFormaPagamento")) {
                    %><%@include file="addFormaPagamento.jsp" %><%
                } else if (id.equals("pagamentoOrdem")) {
                    %><%@include file="pagamentoOrdem.jsp" %><%
                } else if (id.equals("addPagamentoOrdem")) {
                    %><%@include file="addPagamentoOrdem.jsp" %><%
                } else if (id.equals("saldoCaixa")) {
                    %><%@include file="saldoCaixa.jsp" %><%
                }else if (id.equals("venda")) {
                    %><%@include file="venda.jsp" %><%
                } else if (id.equals("addVenda")) {
                    %><%@include file="addVenda.jsp" %><%
                } else if (id.equals("usuario")) {
                    %><%@include file="usuario.jsp" %><%
                } else if (id.equals("addUsuario")) {
                    %><%@include file="addUsuario.jsp" %><%
                } else if (id.equals("categoria")) {
                    %><%@include file="categoria.jsp" %><%
                } else if (id.equals("addCategoria")) {
                    %><%@include file="addCategoria.jsp" %><%
                } else if (id.equals("conta")) {
                    %><%@include file="conta.jsp" %><%
                } else if (id.equals("addConta")) {
                    %><%@include file="addConta.jsp" %><%
                } else if (id.equals("ordemProduto")) {
                    %><%@include file="ordemProduto.jsp" %><%
                } else if (id.equals("addOrdemProduto")) {
                    %><%@include file="addOrdemProduto.jsp" %><%
                } else if (id.equals("pessoaCategoria")) {
                    %><%@include file="pessoaCategoria.jsp" %><%
                } else if (id.equals("addPessoaCategoria")) {
                    %><%@include file="addPessoaCategoria.jsp" %><%
                } else if (id.equals("produtoVenda")) {
                    %><%@include file="produtoVenda.jsp" %><%
                } else if (id.equals("addProdutoVenda")) {
                    %><%@include file="addProdutoVenda.jsp" %><%
                } else if (id.equals("telefone")) {
                    %><%@include file="telefone.jsp" %><%
                } else if (id.equals("addTelefone")) {
                    %><%@include file="addTelefone.jsp" %><%
                } else if (id.equals("pesqOrdem")) {
                    %><%@include file="pesqOrdem.jsp" %><%
                }else if (id.equals("backup")) {
                    %><%@include file="backup.jsp" %><%
                }
            }
%>

