/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author ederson
 */
public class Conexao {
    public static Connection getConnection() throws Exception{
        try{
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/cerealista","postgres","postgres");
//            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/th36077_cerealista","th36077_ederson","ej4132=-");
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public static void closeConnection(Connection conn,Statement stmt, ResultSet rs)throws Exception{
        close(conn,stmt,rs);
    }
    public static void closeConnection(Connection conn,Statement stmt)throws Exception{
        close(conn,stmt,null);
    }
    public static void closeConnection(Connection conn)throws Exception{
        close(conn,null,null);
    }
    private static void close(Connection conn,Statement stmt, ResultSet rs) throws Exception{
        try{
            if(rs != null)rs.close();
            if(stmt != null)stmt.close();
            if(conn != null)conn.close();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
