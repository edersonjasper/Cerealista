/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.dao;

import classe.entidade.Ordem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class OrdemDAO extends GenericDAO {

    public OrdemDAO() {
    }

    public int addOrdem(Ordem ordem) {
        saveOrUpdatePojo(ordem);
        return ordem.getOrdCodigo();
    }

    public void removeOrdem(Ordem ordem) {
        removePojo(ordem);
    }

    public void setOrdem(Ordem ordem) {
        saveOrUpdatePojo(ordem);
    }

    public Ordem getOrdem(int ordemId) {
        Ordem ordem = getPojo(Ordem.class, ordemId);
        return ordem;
    }

    public List<Ordem> getOrdems() {
        return getPureList(Ordem.class, "from Ordem ord where ordAberta = 'A' order by ordCodigo desc");
    }
    public List<Ordem> getOrdens() {
        return getPureList(Ordem.class, "from Ordem ord order by ordCodigo desc");
    }

    public List<Ordem> getPesqOrdems(String aberta, Integer pesId, Date dataInicial, Date dataFinal, Date dataIniVen, Date dataFinVen) {
        DateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        //lista todas
        if (aberta.equals("T") && pesId == 0 && dataInicial == null && dataFinal == null && dataIniVen == null && dataFinVen == null) {
            return getPureList(Ordem.class, "from Ordem ord order by ordCodigo desc");
        }//lista as ordens referente a pessoa sem considerar datas ou ordens abertas ou fechadas
        else if (aberta.equals("T") && pesId != 0 && dataInicial == null && dataFinal == null && dataIniVen == null && dataFinVen == null) {
            return getPureList(Ordem.class, "from Ordem ord " +
                    "where pesCatCodigo = " + pesId + "" +
                    "order by ordCodigo desc");
        }//lista as ordens referente a pessoa sem considerar datas
        else if (pesId != 0 && dataInicial == null && dataFinal == null && dataIniVen == null && dataFinVen == null) {
            return getPureList(Ordem.class, "from Ordem ord " +
                    "where pesCatCodigo = " + pesId + "" +
                    "and ordAberta = '"+aberta+"'"+
                    "order by ordCodigo desc");
        }//lista as ordens referente a aberta ou fechadas
        else if (pesId == 0 && dataInicial == null && dataFinal == null && dataIniVen == null && dataFinVen == null) {
            return getPureList(Ordem.class, "from Ordem ord " +
                    "where ordAberta = '"+aberta+"'"+
                    "order by ordCodigo desc");
        } //lista todas entre as datas de abertura informadas
        else if (aberta.equals("T") && pesId == 0 && dataInicial != null && dataFinal != null) {
            return getPureList(Ordem.class, "from Ordem ord " +
                    "where ordData >= '" + ft.format(dataInicial) + "' " +
                    "and ordData <= '" + ft.format(dataFinal) + "'" +
                    "order by ordCodigo desc");
        }//lista todas da pessoa informada entre a data de abertura informada
        else if (aberta.equals("T") && pesId != 0 && dataInicial != null && dataFinal != null) {
            return getPureList(Ordem.class, "from Ordem ord " +
                    "where pesCatCodigo = "+pesId+"" +
                    "and ordData >= '" + ft.format(dataInicial) + "' " +
                    "and ordData <= '" + ft.format(dataFinal) + "'" +
                    "order by ordCodigo desc");
        }//lista de todos entre as datas de abertura informada levando em consideração se esta aberta ou não
        else if (pesId == 0 && dataInicial != null && dataFinal != null) {
            return getPureList(Ordem.class, "from Ordem ord " +
                    "where ordAberta = '" + aberta + "'" +
                    "and ordData >= '" + ft.format(dataInicial) + "' " +
                    "and ordData <= '" + ft.format(dataFinal) + "'" +
                    "order by ordCodigo desc");
        }//lista as ordens da pessoa entre a data de abertura informada
        else if (pesId != 0 && dataInicial != null && dataFinal != null) {
            return getPureList(Ordem.class, "from Ordem ord " +
                    "where pesCatCodigo = " + pesId + "" +
                    "and ordAberta = '" + aberta + "'" +
                    "and ordData >= '" + ft.format(dataInicial) + "' " +
                    "and ordData <= '" + ft.format(dataFinal) + "'" +
                    "order by ordCodigo desc");
        }//lista todas entre a data de vencimento informada
        else if (aberta.equals("T") && pesId == 0 && dataIniVen != null && dataFinVen != null) {
            return getPureList(Ordem.class, "from Ordem ord " +
                    "where ordDataVencimento >= '" + ft.format(dataIniVen) + "' " +
                    "and ordDataVencimento <= '" + ft.format(dataFinVen) + "'" +
                    "order by ordCodigo desc");
        }//lista todas da pessoa informada entre a data de vencimento informada
        else if (aberta.equals("T") && pesId != 0 && dataIniVen != null && dataFinVen != null) {
            return getPureList(Ordem.class, "from Ordem ord " +
                    "where pesCatCodigo = "+pesId+"" +
                    "and ordDataVencimento >= '" + ft.format(dataIniVen) + "' " +
                    "and ordDataVencimento <= '" + ft.format(dataFinVen) + "'" +
                    "order by ordCodigo desc");
        }//lista de todos entre as datas de vencimento informada levando em consideração se esta aberta ou não
        else if (pesId == 0 && dataIniVen != null && dataFinVen != null) {
            return getPureList(Ordem.class, "from Ordem ord " +
                    "where ordAberta = '" + aberta + "'" +
                    "and ordDataVencimento >= '" + ft.format(dataIniVen) + "' " +
                    "and ordDataVencimento <= '" + ft.format(dataFinVen) + "'" +
                    "order by ordCodigo desc");
        }//lista as ordens da pessoa entre a data de vencimento informada
        else if(pesId != 0 && dataIniVen != null && dataFinVen != null) {
            return getPureList(Ordem.class, "from Ordem ord " +
                    "where pesCatCodigo = " + pesId + "" +
                    "and ordAberta = '" + aberta + "'" +
                    "and ordDataVencimento >= '" + ft.format(dataIniVen) + "' " +
                    "and ordDataVencimento <= '" + ft.format(dataFinVen) + "'" +
                    "order by ordCodigo desc");
        }
        return getPureList(Ordem.class, "from Ordem ord order by ordCodigo desc");
    }

    public Integer getProximo(Integer max) {
        Session ses = getSession();
        List<Ordem> ord = ses.createQuery("from Ordem ord order by ordCodigo desc limit 1").list();
        if (ord.size() != 0) {
            max = ord.get(0).getOrdCodigo() + 1;
            return max;
        }
        return max;
    }
}
