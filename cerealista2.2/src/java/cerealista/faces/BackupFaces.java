/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.faces;

import cerealista.dao.AcaoDAO;
import cerealista.dao.AcessoDAO;
import cerealista.dao.AcessoUsuarioDAO;
import cerealista.dao.AuditoriaDAO;
import cerealista.dao.AutenticacaoDAO;
import cerealista.dao.BancoDAO;
import cerealista.dao.CaixaDAO;
import cerealista.dao.CategoriaDAO;
import cerealista.dao.CategoriaDespesaDAO;
import cerealista.dao.CidadeDAO;
import cerealista.dao.ContaDAO;
import cerealista.dao.DespesaDAO;
import cerealista.dao.FormaPagamentoDAO;
import cerealista.dao.HorasTrabalhadasDAO;
import cerealista.dao.OrdemDAO;
import cerealista.dao.OrdemProdutoDAO;
import cerealista.dao.PagamentoFuncionarioDAO;
import cerealista.dao.PagamentoOrdemDAO;
import cerealista.dao.PessoaCategoriaDAO;
import cerealista.dao.PessoaDAO;
import cerealista.dao.ProdutoDAO;
import cerealista.dao.ProdutoVendaDAO;
import cerealista.dao.QuebraDAO;
import cerealista.dao.SaldoCaixaDAO;
import cerealista.dao.TelefoneDAO;
import cerealista.dao.TipoTelefoneDAO;
import cerealista.dao.UnidadeMedidaDAO;
import cerealista.dao.UsuarioDAO;
import cerealista.dao.VeiculoDAO;
import cerealista.dao.VendaDAO;
import classe.entidade.Banco;
import classe.entidade.Caixa;
import classe.entidade.Categoria;
import classe.entidade.CategoriaDespesa;
import classe.entidade.Cidade;
import classe.entidade.Conta;
import classe.entidade.Despesa;
import classe.entidade.FormaPagamento;
import classe.entidade.HorasTrabalhadas;
import classe.entidade.Ordem;
import classe.entidade.OrdemProduto;
import classe.entidade.PagamentoFuncionario;
import classe.entidade.PagamentoOrdem;
import classe.entidade.Pessoa;
import classe.entidade.PessoaCategoria;
import classe.entidade.Produto;
import classe.entidade.ProdutoVenda;
import classe.entidade.Quebra;
import classe.entidade.SaldoCaixa;
import classe.entidade.Telefone;
import classe.entidade.TipoTelefone;
import classe.entidade.UnidadeMedida;
import classe.entidade.Usuario;
import classe.entidade.Veiculo;
import classe.entidade.Venda;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class BackupFaces {

    private AcaoDAO acaDao = new AcaoDAO();
    private AcessoDAO aceDAO = new AcessoDAO();
    private AcessoUsuarioDAO aceUsuDAO = new AcessoUsuarioDAO();
    private AuditoriaDAO audDAO = new AuditoriaDAO();
    private AutenticacaoDAO autDAO = new AutenticacaoDAO();
    private BancoDAO banDAO = new BancoDAO();
    private CaixaDAO caiDAO = new CaixaDAO();
    private CategoriaDAO catDAO = new CategoriaDAO();
    private CategoriaDespesaDAO catDesDAO = new CategoriaDespesaDAO();
    private CidadeDAO cidDAO = new CidadeDAO();
    private ContaDAO conDAO = new ContaDAO();
    private DespesaDAO desDAO = new DespesaDAO();
    private FormaPagamentoDAO forPagDAO = new FormaPagamentoDAO();
    private HorasTrabalhadasDAO horTraDAO = new HorasTrabalhadasDAO();
    private OrdemDAO ordDAO = new OrdemDAO();
    private OrdemProdutoDAO ordProDAO = new OrdemProdutoDAO();
    private PagamentoFuncionarioDAO pagFunDAO = new PagamentoFuncionarioDAO();
    private PagamentoOrdemDAO pagOrdDAO = new PagamentoOrdemDAO();
    private PessoaCategoriaDAO pesCatDAO = new PessoaCategoriaDAO();
    private PessoaDAO pesDAO = new PessoaDAO();
    private ProdutoDAO proDAO = new ProdutoDAO();
    private ProdutoVendaDAO proVenDAO = new ProdutoVendaDAO();
    private QuebraDAO queDAO = new QuebraDAO();
    private SaldoCaixaDAO salCaiDAO = new SaldoCaixaDAO();
    private TelefoneDAO telDAO = new TelefoneDAO();
    private TipoTelefoneDAO tipTelDAO = new TipoTelefoneDAO();
    private UnidadeMedidaDAO uniMedDAO = new UnidadeMedidaDAO();
    private UsuarioDAO usuDAO = new UsuarioDAO();
    private VeiculoDAO veiDAO = new VeiculoDAO();
    private VendaDAO venDAO = new VendaDAO();
    private String sucesso = "Realizar backup";

    public void iniciaBackup() {
        Date data = new Date();

        int ano = data.getYear() + 1900;
        int mes = data.getMonth() + 1;
        int dia = data.getDate();
        String dt = String.valueOf(dia) + "_" + String.valueOf(mes) + "_" + String.valueOf(ano);
        String arquivo = "C:/Users/Rodrigo/Desktop/backup" + dt + ".txt";
//        String arquivo = "C:/Documents and Settings/Administrador/Desktop/backup_" + dt + ".txt";
        FileOutputStream arquivoBackup = null;
        DataOutputStream arq = null;
//        PrintWriter out = null;
        try {
//            out = new PrintWriter(arquivo);
//            out.println("algo para escrecer");
            arquivoBackup = new FileOutputStream(arquivo);
            arq = new DataOutputStream(arquivoBackup);

//            for (Acao aca : acaDao.getAcaos()) {
//                String linha = "insert into acao (aca_codigo, aca_descricao)values(" + String.valueOf(aca.getAcaCodigo() + ",'" + aca.getAcaDescricao() + "');");
//                arquivoDados.writeChars(linha);
//            }
//            for (Acesso ace : aceDAO.getAcessos()) {
//                String linha = "insert into acao (aca_codigo, aca_descricao)values(" + String.valueOf(ace.getAceCodigo() + ",'" + ace.getAceDescricao() + "');");
//                arquivoDados.writeChars(linha);
//            }
            for (Usuario usu : usuDAO.getUsuarios(1)) {
                String linha = "insert into usuario(usu_codigo, usu_nome, usu_senha, usu_status, usu_usuario)values(" + String.valueOf(usu.getUsuCodigo()) + ",'" + usu.getUsuNome() + "','" + usu.getUsuSenha() + "','" + usu.getUsuStatus() + "','" + usu.getUsuSenha() + "');";
                arq.writeBytes(linha);
            }
            for (Banco ban : banDAO.getBancos()) {
                String linha = "insert into banco(ban_codigo, ban_nome)values(" + String.valueOf(ban.getBanCodigo()) + ",'" + ban.getBanNome() + "');";
                arq.writeBytes(linha);

            }

            for (Categoria cat : catDAO.getCategorias()) {
                String linha = "insert into categoria(cat_codigo,cat_descricao)values(" + String.valueOf(cat.getCatCodigo()) + ",'" + cat.getCatDescricao() + "');";
                arq.writeBytes(linha);
            }
            for (CategoriaDespesa catDes : catDesDAO.getCategoriaDespesas()) {
                String linha = "insert into categoria_despesa(cat_des_codigo,cat_des_descricao)values(" + String.valueOf(catDes.getCatDesCodigo()) + ",'" + catDes.getCatDesDescricao() + "');";
                arq.writeBytes(linha);
            }
            for (Cidade cid : cidDAO.getCidades()) {
                String linha = "insert into cidade(cid_codigo,cid_nome,cid_uf)values(" + String.valueOf(cid.getCidCodigo()) + ",'" + cid.getCidNome() + "','" + cid.getCidUf() + "');";
                arq.writeBytes(linha);
            }
            for (Pessoa pes : pesDAO.getPessoas()) {
                if (pes.getPesNascimento() == null) {
                    pes.setPesNascimento(new Date(2000, 01, 01));
                }
                String linha = "insert into pessoa(pes_codigo,pes_bairro,pes_cep,pes_cpf_cnpj,pes_endereco,pes_ie,"
                        + "pes_nascimento,pes_nome,pes_numero,pes_oculto,pes_sexo,pes_tipo,cid_codigo,usu_codigo)values("
                        + String.valueOf(pes.getPesCodigo()) + ",'" + pes.getPesBairro() + "','" + pes.getPesCep() + "','" + pes.getPesCpfCnpj() + "','"
                        + pes.getPesEndereco() + "','" + pes.getPesIe() + "','" + String.valueOf(pes.getPesNascimento()) + "','" + pes.getPesNome() + "',"
                        + String.valueOf(pes.getPesNumero()) + ",'" + pes.getPesOculto() + "','" + pes.getPesSexo() + "','"
                        + pes.getPesTipo() + "'," + String.valueOf(pes.getCidCodigo().getCidCodigo()) + "," + String.valueOf(pes.getUsuCodigo().getUsuCodigo() + ");");
                arq.writeBytes(linha);
            }
            for (Conta con : conDAO.getContas()) {
                String linha = "insert into conta(con_codigo,con_agencia,con_nome_deposito,con_numero_banco,"
                        + "con_numero_conta,con_operacao,ban_codigo,pes_codigo)values(" + String.valueOf(con.getConCodigo()) + ",'" + con.getConAgencia() + "','"
                        + con.getConNomeDeposito() + "'," + String.valueOf(con.getConNumeroBanco()) + ",'" + con.getConNumeroConta() + "','"
                        + con.getConOperacao() + "'," + String.valueOf(con.getBanCodigo().getBanCodigo()) + ","
                        + String.valueOf(con.getPesCodigo().getPesCodigo()) + ");";
                arq.writeBytes(linha);
            }
            for (Despesa des : desDAO.getDespesas()) {
                String linha = "insert into despesa(des_codigo,des_data,des_descricao,des_valor,cat_des_codigo,usu_codigo)values("
                        + String.valueOf(des.getDesCodigo()) + ",'" + String.valueOf(des.getDesData()) + "','" + des.getDesDescricao() + "','"
                        + String.valueOf(des.getDesValor()) + "'," + String.valueOf(des.getCatDesCodigo().getCatDesCodigo()) + "," + String.valueOf(des.getUsuCodigo().getUsuCodigo()) + ");";
                arq.writeBytes(linha);
            }
            for (FormaPagamento forPag : forPagDAO.getFormaPagamentos()) {
                String linha = "insert into forma_pagamento(for_pag_codigo,for_pag_descricao)values("
                        + String.valueOf(forPag.getForPagCodigo()) + ",'" + forPag.getForPagDescricao() + "');";
                arq.writeBytes(linha);
            }
            for (PessoaCategoria pesCat : pesCatDAO.getPessoaCategorias()) {
                String linha = "insert into pessoa_categoria(pes_cat_codigo,cat_codigo,pes_codigo)values ("
                        + String.valueOf(pesCat.getPesCatCodigo()) + "," + String.valueOf(pesCat.getCatCodigo().getCatCodigo()) + ","
                        + String.valueOf(pesCat.getPesCodigo().getPesCodigo()) + ");";
                arq.writeBytes(linha);
            }
            for (Caixa cai : caiDAO.getCaixas()) {
                Integer pesCatCod = 18;
                try {
                    if (cai.getPesCatCodigo().getPesCatCodigo() != null) {
                        pesCatCod = cai.getPesCatCodigo().getPesCatCodigo();
                    }
                } catch (NullPointerException e) {
                    pesCatCod = 18;
                }
                String linha = "insert into caixa(cai_codigo,cai_data,cai_valor_depositado,usu_codigo,pes_cat_codigo)values(" + String.valueOf(cai.getCaiCodigo()) + ",'" + String.valueOf(cai.getCaiData()) + "','" + String.valueOf(cai.getCaiValorDepositado()) + "'," + String.valueOf(cai.getUsuCodigo().getUsuCodigo()) + "," + String.valueOf(pesCatCod) + ");";
                arq.writeBytes(linha);

            }
            for (HorasTrabalhadas horTra : horTraDAO.getHorasTrabalhadas()) {
                String linha = "insert into horas_trabalhadas(hor_tra_codigo,hor_tra_data,hor_tra_descricao,"
                        + "hor_tra_horas_trabalhadas,hor_tra_valor_hora,hor_tra_valor_total,pes_cat_codigo)values("
                        + String.valueOf(horTra.getHorTraCodigo()) + ",'" + String.valueOf(horTra.getHorTraData()) + "','" + horTra.getHorTraDescricao() + "','"
                        + String.valueOf(horTra.getHorTraHorasTrabalhadas()) + "','" + String.valueOf(horTra.getHorTraValorHora()) + "','"
                        + String.valueOf(horTra.getHorTraValorTotal()) + "'," + String.valueOf(horTra.getPesCatCodigo().getPesCatCodigo()) + ");";
                arq.writeBytes(linha);
            }
            for (Ordem ord : ordDAO.getOrdens()) {
                if (ord.getOrdNotaFornecedor() == null) {
                    ord.setOrdNotaFornecedor(0);
                }
                String linha = "insert into ordem(ord_codigo,ord_aberta,"
                        + "ord_adiantamento,ord_data,"
                        + "ord_data_vencimento,ord_desconto,"
                        + "ord_fundo_rural,ord_pago,"
                        + "ord_peso_total,ord_valor_restante,"
                        + "ord_valor_total,pes_cat_codigo,"
                        + "usu_codigo, ord_nota_fornecedor)values("
                        + String.valueOf(ord.getOrdCodigo()) + ",'" + ord.getOrdAberta() + "','"
                        + String.valueOf(ord.getOrdAdiantemento()) + "','" + String.valueOf(ord.getOrdData()) + "','"
                        + String.valueOf(ord.getOrdDataVencimento()) + "','" + String.valueOf(ord.getOrdDesconto()) + "','"
                        + String.valueOf(ord.getOrdFundoRural()) + "','" + ord.getOrdPago() + "','"
                        + String.valueOf(ord.getOrdPesoTotal()) + "','" + String.valueOf(ord.getOrdValorRestante()) + "','"
                        + String.valueOf(ord.getOrdValorTotal()) + "'," + String.valueOf(ord.getPesCatCodigo().getPesCatCodigo()) + ","
                        + String.valueOf(ord.getUsuCodigo().getUsuCodigo()) + "," + String.valueOf(ord.getOrdNotaFornecedor()) + ");";
                arq.writeBytes(linha);
            }
            for (UnidadeMedida uniMed : uniMedDAO.getUnidadeMedidas()) {
                String linha = "insert into unidade_medida(uni_med_codigo,uni_med_descricao)values("
                        + String.valueOf(uniMed.getUniCodigo()) + ",'" + uniMed.getUniDescricao() + "');";
                arq.writeBytes(linha);
            }
            for (Produto pro : proDAO.getProdutos()) {
                String linha = "insert into produto(pro_codigo,pro_estoque,pro_nome,uni_med_codigo)values("
                        + String.valueOf(pro.getProCodigo()) + ",'" + String.valueOf(pro.getProEstoque()) + "','" + pro.getProNome() + "'," + String.valueOf(pro.getUniMedCodigo().getUniCodigo()) + ");";
                arq.writeBytes(linha);
            }
            for (OrdemProduto ordPro : ordProDAO.getOrdemProdutos()) {
                String linha = "insert into ordem_produto(ord_pro_codigo,ord_pro_peso_total,"
                        + "ord_pro_peso_unitario,ord_pro_quantidade,"
                        + "ord_pro_valor_total,ord_pro_valor_unitario,"
                        + "ord_codigo,pro_codigo,usu_codigo)values("
                        + String.valueOf(ordPro.getOrdProCodigo()) + ",'" + String.valueOf(ordPro.getOrdProPesoTotal()) + "','"
                        + String.valueOf(ordPro.getOrdProPesoUnitario()) + "','" + String.valueOf(ordPro.getOrdProQuantidade()) + "','"
                        + String.valueOf(ordPro.getOrdProValorTotal()) + "','" + String.valueOf(ordPro.getOrdProValorUnitario()) + "',"
                        + String.valueOf(ordPro.getOrdCodigo().getOrdCodigo()) + "," + String.valueOf(ordPro.getProCodigo().getProCodigo()) + ","
                        + String.valueOf(ordPro.getUsuCodigo().getUsuCodigo()) + ");";
                arq.writeBytes(linha);
            }
            for (PagamentoFuncionario pagFun : pagFunDAO.getPagamentoFuncionariosTodos()) {
                String linha = "insert into pagamento_funcionario(pag_fun_codigo,pag_fun_data,"
                        + "pag_fun_valor,pes_cat_codigo,usu_codigo)values("
                        + String.valueOf(pagFun.getPagFunCodigo()) + ",'" + String.valueOf(pagFun.getPagFunData()) + "','"
                        + String.valueOf(pagFun.getPagFunValor()) + "'," + String.valueOf(pagFun.getPesCatCodigo().getPesCatCodigo()) + ","
                        + String.valueOf(pagFun.getUsuCodigo().getUsuCodigo()) + ");";
                arq.writeBytes(linha);
            }
            for (PagamentoOrdem pagOrd : pagOrdDAO.getPagamentoOrdems()) {
                String linha = "insert into pagamento_ordem(pag_ord_codigo,pag_ord_data,"
                        + "pag_ord_valor,pag_ord_valor_acumulado,"
                        + "for_pag_codigo,ord_codigo,usu_codigo)values("
                        + String.valueOf(pagOrd.getPagOrdCodigo()) + ",'" + String.valueOf(pagOrd.getPagOrdData()) + "','"
                        + String.valueOf(pagOrd.getPagOrdValor()) + "','" + String.valueOf(pagOrd.getPagOrdValorAcumulado()) + "',"
                        + String.valueOf(pagOrd.getForPagCodigo().getForPagCodigo()) + "," + String.valueOf(pagOrd.getOrdCodigo().getOrdCodigo()) + ","
                        + String.valueOf(pagOrd.getUsuCodigo().getUsuCodigo()) + ");";
                arq.writeBytes(linha);

            }
            for (Veiculo vei : veiDAO.getVeiculos()) {
                String linha = "insert into veiculo(vei_codigo,vei_placa,"
                        + "vei_veiculo,cid_codigo,pes_cat_codigo)values("
                        + String.valueOf(vei.getVeiCodigo()) + ",'" + vei.getVeiPlaca() + "','"
                        + vei.getVeiVeiculo() + "'," + String.valueOf(vei.getCidCodigo().getCidCodigo()) + ","
                        + String.valueOf(vei.getPesCatCodigo().getPesCatCodigo()) + ");";
                arq.writeBytes(linha);
            }
            for (Venda ven : venDAO.getVendas()) {
                String linha = "insert into venda(ven_codigo,ven_data_entrega,"
                        + "ven_data,ven_fechada,"
                        + "ven_icms,ven_peso_total,"
                        + "ven_seguro,ven_valor_frete,"
                        + "ven_valor_liquido,ven_valor_total,"
                        + "pes_cat_codigo,usu_codigo,vei_codigo)values("
                        + String.valueOf(ven.getVenCodigo()) + ",'" + String.valueOf(ven.getVenDAtaEntrega()) + "','"
                        + String.valueOf(ven.getVenData()) + "','" + ven.getVenFechada() + "','"
                        + String.valueOf(ven.getVenIcms()) + "','" + String.valueOf(ven.getVenPesoTotal()) + "','"
                        + String.valueOf(ven.getVenSeguro()) + "','" + String.valueOf(ven.getVenValorFrete()) + "','"
                        + String.valueOf(ven.getVenValorLiquido()) + "','" + String.valueOf(ven.getVenValorTotal()) + "',"
                        + String.valueOf(ven.getPesCatCodigo().getPesCatCodigo()) + "," + String.valueOf(ven.getUsuCodigo().getUsuCodigo()) + ","
                        + String.valueOf(ven.getVeiCodigo().getVeiCodigo()) + ");";
                arq.writeBytes(linha);
            }
            for (ProdutoVenda proVen : proVenDAO.getProdutoVendas()) {
                String linha = "insert into produto_venda(pro_ven_codigo,pro_ven_nome_fornecedor,"
                        + "pro_ven_peso_total,pro_ven_peso_unitario,"
                        + "pro_ven_quantidade,pro_ven_valor_total,"
                        + "pro_ven_valor_unitario,pro_codigo,"
                        + "usu_codigo,ven_codigo)values("
                        + String.valueOf(proVen.getProVenCodigo()) + ",'" + proVen.getProVenNomeFornecedor() + "','"
                        + String.valueOf(proVen.getProVenPesoTotal()) + "','" + String.valueOf(proVen.getProVenPesoUnitario()) + "','"
                        + String.valueOf(proVen.getProVenQuatidade()) + "','" + String.valueOf(proVen.getProVenValorTotal()) + "','"
                        + String.valueOf(proVen.getProVenValorUnitario()) + "'," + String.valueOf(proVen.getProCodigo().getProCodigo()) + ","
                        + String.valueOf(proVen.getUsuCodigo().getUsuCodigo()) + "," + String.valueOf(proVen.getVenCodigo().getVenCodigo()) + ");";
                arq.writeBytes(linha);
            }
            for (Quebra que : queDAO.getQuebras()) {
                String linha = "insert into quebra(que_codigo,que_data,"
                        + "que_peso_total,que_peso_unitario,"
                        + "que_quantidade,pro_codigo,usu_codigo)values("
                        + String.valueOf(que.getQueCodigo()) + ",'" + String.valueOf(que.getQueData()) + "','"
                        + String.valueOf(que.getQuePesoTotal()) + "','" + String.valueOf(que.getQuePesoUnitario()) + "','"
                        + String.valueOf(que.getQueQuantidade()) + "'," + String.valueOf(que.getProCodigo().getProCodigo()) + "," + String.valueOf(que.getUsuCodigo().getUsuCodigo()) + ");";
                arq.writeBytes(linha);
            }
            for (SaldoCaixa salCai : salCaiDAO.getSaldoCaixas()) {
                String linha = "insert into saldo_caixa(sal_cai_codigo,sal_cai_data,"
                        + "sal_cai_valor,sal_cai_tabela)values("
                        + String.valueOf(salCai.getSalCaiCodigo()) + ",'" + String.valueOf(salCai.getSalCaiData()) + "','"
                        + String.valueOf(salCai.getSalCaiValor()) + "','" + salCai.getSalCaiTabela() + "');";
                arq.writeBytes(linha);
            }
            for (TipoTelefone tipTel : tipTelDAO.getTipoTelefones()) {
                String linha = "insert into tipo_telefone(tip_codigo,tip_descricao)values("
                        + String.valueOf(tipTel.getTipCodigo()) + ",'" + tipTel.getTipDescricao() + "');";
                arq.writeBytes(linha);
            }
            for (Telefone tel : telDAO.getTelefones()) {
                String linha = "insert into telefone(tel_codigo,tel_contato,"
                        + "tel_numero,pes_codigo,tip_codigo)values("
                        + String.valueOf(tel.getTelCodigo()) + ",'" + tel.getTelContato() + "','"
                        + tel.getTelNumero() + "'," + String.valueOf(tel.getPesCodigo().getPesCodigo()) + "," + String.valueOf(tel.getTipCodigo().getTipCodigo()) + ");";
                arq.writeBytes(linha);
            }

            setSucesso("Backup realizado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (arq != null) {
                try {
                    arq.close();
                } catch (IOException ex) {
                    Logger.getLogger(BackupFaces.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    public String getSucesso() {
        return sucesso;
    }

    public void setSucesso(String sucesso) {
        this.sucesso = sucesso;
    }
}
