/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate;

import classe.entidade.Acao;
import classe.entidade.Acesso;
import classe.entidade.AcessoUsuario;
import classe.entidade.Auditoria;
import classe.entidade.Autenticacao;
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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Eder
 */
public class HibernateUtil {

    private static HibernateUtil me;
    private SessionFactory sessionfactory;
    private HibernateUtil(){
        sessionfactory = new AnnotationConfiguration().
                setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
                .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
                .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/cerealista")
                .setProperty("hibernate.connection.username", "postgres")
                .setProperty("hibernate.connection.password", "postgres")
//                .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/th36077_cerealista")
//                .setProperty("hibernate.connection.username", "th36077_ederson")
//                .setProperty("hibernate.connection.password", "ej4132=-")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.format_sql", "true")
                .setProperty("hibernate.c3p0.acquire_increment", "1")
                .setProperty("hibernate.c3p0.idle_test_period", "1")
                .setProperty("hibernate.c3p0.max_size", "20")
                .setProperty("hibernate.c3p0.max_statements", "0")
                .setProperty("hibernate.c3p0.min_size","0")
                .setProperty("hibernate.c3p0.timeout", "400")
                .addAnnotatedClass(Acao.class)
                .addAnnotatedClass(Acesso.class)
                .addAnnotatedClass(Auditoria.class)
                .addAnnotatedClass(Autenticacao.class)
                .addAnnotatedClass(Banco.class)
                .addAnnotatedClass(Caixa.class)
                .addAnnotatedClass(Categoria.class)
                .addAnnotatedClass(CategoriaDespesa.class)
                .addAnnotatedClass(Cidade.class)
                .addAnnotatedClass(Conta.class)
                .addAnnotatedClass(Despesa.class)
                .addAnnotatedClass(FormaPagamento.class)
                .addAnnotatedClass(HorasTrabalhadas.class)
                .addAnnotatedClass(Ordem.class)
                .addAnnotatedClass(OrdemProduto.class)
                .addAnnotatedClass(AcessoUsuario.class)
                .addAnnotatedClass(PagamentoFuncionario.class)
                .addAnnotatedClass(PagamentoOrdem.class)
                .addAnnotatedClass(Pessoa.class)
                .addAnnotatedClass(Produto.class)
                .addAnnotatedClass(ProdutoVenda.class)
                .addAnnotatedClass(PessoaCategoria.class)
                .addAnnotatedClass(Quebra.class)
                .addAnnotatedClass(SaldoCaixa.class)
                .addAnnotatedClass(Telefone.class)
                .addAnnotatedClass(TipoTelefone.class)
                .addAnnotatedClass(UnidadeMedida.class)
                .addAnnotatedClass(Usuario.class)
                .addAnnotatedClass(Veiculo.class)
                .addAnnotatedClass(Venda.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstace(){
        if(me == null){
            me = new HibernateUtil();
        }
        return me;
    }
    public Session getSession(){
        Session toReturn = sessionfactory.openSession();
        toReturn.beginTransaction();      
        return toReturn;
    }

}
