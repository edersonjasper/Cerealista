/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.faces;

import cerealista.dao.ProdutoVendaDAO;
import cerealista.dao.SessionDAO;
import cerealista.dao.VendaDAO;
import classe.entidade.ProdutoVenda;
import classe.entidade.Venda;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Eder
 */
public class VendaFaces {

    private Venda selectedVenda;
    private List<ProdutoVenda> listAuxiliar = null;
    private ProdutoVendaDAO proVenDAO = new ProdutoVendaDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private VendaDAO venDAO = new VendaDAO();
    private List<Venda> cachedVenda = null;
    private List<ProdutoVenda> listAuxProdutoVenda = null;
    private Integer codigo;
    private Integer intAux;
    private Double valor;
    private Double peso;
    private String fechada = null;

    /** Creates a new instance of VendaFaces */
    public VendaFaces() {
    }

    public void addVenda() {
        codigo = 1;
        selectedVenda = new Venda();
        Date data = new Date();
        selectedVenda.setVenData(data);
        selectedVenda.setVenFechada("A");
        fechada = "A";
        sesDAO.setaSession("id", "addVenda");
    }

    public void finishAddVenda() {
        //acerta o preço de custo se a ordem estava aberta e foi fechada
        if (selectedVenda.getVenFechada().equals("F") && fechada.equals("A")) {
            listAuxProdutoVenda = null;
            Double quantidade = 0.0;
            Double despesaAdicional = 0.0;
            listAuxProdutoVenda = proVenDAO.getProdutoVendasVenda(selectedVenda.getVenCodigo());
            for (ProdutoVenda proVen : listAuxProdutoVenda) {
                quantidade = quantidade + proVen.getProVenQuatidade();
            }
            if (selectedVenda.getVenIcms() > 0) {
                despesaAdicional = despesaAdicional + selectedVenda.getVenIcms();
            }
            if (selectedVenda.getVenSeguro() > 0) {
                despesaAdicional = despesaAdicional + selectedVenda.getVenSeguro();
            }
            if (selectedVenda.getVenValorFrete() > 0) {
                despesaAdicional = despesaAdicional + selectedVenda.getVenValorFrete();
            }
            for (ProdutoVenda proVen : listAuxProdutoVenda) {
                proVen.setProVenValorUnitario((despesaAdicional / quantidade) + proVen.getProVenValorUnitario());
                proVen.setProVenValorTotal(proVen.getProVenQuatidade() * proVen.getProVenValorUnitario());
                proVenDAO.addProdutoVenda(proVen);
            }
            listAuxiliar = null;
            listAuxiliar = proVenDAO.getTotalVenda(selectedVenda.getVenCodigo());
            if (listAuxiliar.size() != 0) {
                peso = 0.0;
                valor = 0.0;
                for (ProdutoVenda proVen : listAuxiliar) {
                    valor = valor + proVen.getProVenValorTotal();
                }
                selectedVenda.setVenValorTotal(valor);
                selectedVenda.calculaValorLiquido();
                venDAO.addVenda(selectedVenda);
            }
        }
        //retorna o preço de custo do saco descontano a ICMS, frete e seguro; isso caso abra a nota ja fechada;
        if (selectedVenda.getVenFechada().equals("A") && fechada.equals("F")) {
            listAuxProdutoVenda = null;
            Double quantidade = 0.0;
            Double despesaAdicional = 0.0;
            listAuxProdutoVenda = proVenDAO.getProdutoVendasVenda(selectedVenda.getVenCodigo());
            for (ProdutoVenda proVen : listAuxProdutoVenda) {
                quantidade = quantidade + proVen.getProVenQuatidade();
            }
            if (selectedVenda.getVenIcms() > 0) {
                despesaAdicional = despesaAdicional + selectedVenda.getVenIcms();
            }
            if (selectedVenda.getVenSeguro() > 0) {
                despesaAdicional = despesaAdicional + selectedVenda.getVenSeguro();
            }
            if (selectedVenda.getVenValorFrete() > 0) {
                despesaAdicional = despesaAdicional + selectedVenda.getVenValorFrete();
            }
            for (ProdutoVenda proVen : listAuxProdutoVenda) {
                proVen.setProVenValorUnitario(proVen.getProVenValorUnitario()-(despesaAdicional / quantidade));
                proVen.setProVenValorTotal(proVen.getProVenQuatidade() * proVen.getProVenValorUnitario());
                proVenDAO.addProdutoVenda(proVen);
            }
            listAuxiliar = null;
            listAuxiliar = proVenDAO.getTotalVenda(selectedVenda.getVenCodigo());
            if (listAuxiliar.size() != 0) {
                peso = 0.0;
                valor = 0.0;
                for (ProdutoVenda proVen : listAuxiliar) {
                    valor = valor + proVen.getProVenValorTotal();
                }
                selectedVenda.setVenValorTotal(valor);
                selectedVenda.calculaValorLiquido();
                venDAO.addVenda(selectedVenda);
            }
        }
        venDAO.addVenda(selectedVenda);
        cachedVenda = null;
        sesDAO.setaSession("id", "venda");
    }

    public void updateVenda() {
        codigo = 0;
        fechada = selectedVenda.getVenFechada();
        sesDAO.setaSession("id", "addVenda");
    }

    public void removeVenda() {
        venDAO.removeVenda(selectedVenda);
        cachedVenda = null;
        sesDAO.setaSession("id", "venda");
    }
    public void chamaVenda(){
        sesDAO.setaSession("id", "venda");
    }
    public List<Venda> getCachedVenda() {
        cachedVenda = null;
        if (cachedVenda == null) {
            cachedVenda = venDAO.getVendas();
        }
        return cachedVenda;
    }


    public Integer getCodigo() {
        return codigo;
    }

    public Venda getSelectedVenda() {
        return selectedVenda;
    }

    public String getFechada() {
        return fechada;
    }

    public void setFechada(String fechada) {
        this.fechada = fechada;
    }


    public Integer getIntAux() {
        return intAux;
    }

    public void setIntAux(Integer intAux) {
        this.intAux = intAux;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setSelectedVenda(Venda selectedVenda) {
        this.selectedVenda = selectedVenda;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
//============ produto venda===========================
//    public String addProdutoVenda() {
//        selectedProdutoVenda = new ProdutoVenda();
//        selectedProdutoVenda.setVenCodigo(selectedVenda);
//        codigo = 1;
//        intAux = 0;
//        return "gotoAddProdutoVenda";
//    }
//
//    public String finishAddProdutoVenda() {
//        selectedProdutoVenda.calculaPesoTotal();
//        selectedProdutoVenda.calculaValorTotal();
//        proVenDAO.addProdutoVenda(selectedProdutoVenda);
//
//        //carrega o produto que esta sendo inserido ou atualizado na vanda
//        selectedProduto = proDAO.getProduto(selectedProdutoVenda.getProCodigo().getProCodigo());
//        // se esta sendo atualizo somente o peso do mesmo produto que foi inserido antes ele atualiza o estoque do mesmo
//        if (codigo == 0 && intAux == selectedProdutoVenda.getProCodigo().getProCodigo()) {
//            peso = selectedProdutoVenda.getProVenPesoTotal() - peso;
//            selectedProduto.setProEstoque(selectedProduto.getProEstoque() - peso);
//        } else //verifica se foi mudado de produto para aquela quantidade
//        //faz a comparação com o zero para verificar senão esta sendo inserido
//        if (intAux != selectedProdutoVenda.getProCodigo().getProCodigo() && intAux != 0) {
//            //atualiza o estoque do produto que esta sendo utilizado
//            selectedProduto.setProEstoque(selectedProduto.getProEstoque() - selectedProdutoVenda.getProVenPesoTotal());
//            proDAO.addProduto(selectedProduto);
//            //retorna ao estoque a quantidade do produto anterior
//            selectedProduto = proDAO.getProduto(intAux);
//            selectedProduto.setProEstoque(selectedProduto.getProEstoque() + peso);
//            proDAO.addProduto(selectedProduto);
//
//        } else {
//            selectedProduto.setProEstoque(selectedProduto.getProEstoque() - selectedProdutoVenda.getProVenPesoTotal());
//        }
//        proDAO.addProduto(selectedProduto);
//
//        //seleciona os produtos da venda para atualizar o peso e o valor.
//        listAuxiliar = proVenDAO.getTotalVenda(selectedProdutoVenda.getVenCodigo().getVenCodigo());
//        if (listAuxiliar.size() != 0) {
//            peso = 0.0;
//            valor = 0.0;
//            for (ProdutoVenda proVen : listAuxiliar) {
//                peso = peso + proVen.getProVenPesoTotal();
//                valor = valor + proVen.getProVenValorTotal();
//            }
//            selectedVenda.setVenPesoTotal(peso);
//            selectedVenda.setVenValorTotal(valor);
//            venDAO.addVenda(selectedVenda);
//        }
//
//        cachedProdutoVenda = null;
//
//        return "gotoListProdutoVenda";
//    }
//
//    public String updateProdutoVenda() {
//        codigo = 0;
//        peso = selectedProdutoVenda.getProVenPesoTotal();
//        intAux = selectedProdutoVenda.getProCodigo().getProCodigo();
//        return "gotoAddProdutoVenda";
//    }
//
//    public String removeProdutoVenda() {
//        proVenDAO.removeProdutoVenda(selectedProdutoVenda);
//        listAuxiliar = proVenDAO.getTotalVenda(selectedProdutoVenda.getVenCodigo().getVenCodigo());
//        if (listAuxiliar.size() != 0) {
//            peso = 0.0;
//            valor = 0.0;
//            for (ProdutoVenda proVen : listAuxiliar) {
//                peso = peso + proVen.getProVenPesoTotal();
//                valor = valor + proVen.getProVenValorTotal();
//            }
//            selectedVenda.setVenPesoTotal(peso);
//            selectedVenda.setVenValorTotal(valor);
//            venDAO.addVenda(selectedVenda);
//        }// caso for o ultimo produto a ser excluido ele sera o peso e o valor total
//        else {
//            selectedVenda.setVenPesoTotal(0.0);
//            selectedVenda.setVenValorTotal(0.0);
//            selectedVenda.setVenValorFrete(0.0);
//            selectedVenda.setVenValorLiquido(0.0);
//            selectedVenda.setVenIcms(0.0);
//            venDAO.addVenda(selectedVenda);
//        }
//        selectedProduto = proDAO.getProduto(selectedProdutoVenda.getProCodigo().getProCodigo());
//
//        selectedProduto.setProEstoque(selectedProduto.getProEstoque() + selectedProdutoVenda.getProVenPesoTotal());
//
//        proDAO.addProduto(selectedProduto);
//        cachedProdutoVenda = null;
//
//        return "gotoListProdutoVenda";
//    }
//
//    public List<ProdutoVenda> getCachedProdutoVenda() {
//        cachedProdutoVenda = null;
//        if (cachedProdutoVenda == null) {
//            cachedProdutoVenda = proVenDAO.getProdutoVendasVenda(selectedVenda.getVenCodigo());
//        }
//        return cachedProdutoVenda;
//    }
//
//    public ProdutoVenda getSelectedProdutoVenda() {
//        return selectedProdutoVenda;
//    }
//
//    public void setSelectedProdutoVenda(ProdutoVenda selectedProdutoVenda) {
//        this.selectedProdutoVenda = selectedProdutoVenda;
//    }
//
//    public Produto getSelectedProduto() {
//        return selectedProduto;
//    }
//
//    public void setSelectedProduto(Produto selectedProduto) {
//        this.selectedProduto = selectedProduto;
//    }
}
