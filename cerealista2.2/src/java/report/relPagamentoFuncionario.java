/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import static hibernate.Conexao.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Eder
 */
public class relPagamentoFuncionario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        Connection con = getConnection();
//formata a data para o formato MM/dd/yyyy
        String dt = request.getParameter("dataIni");
        String da = dt.substring(3,5);
        da = da + "/"+ dt.substring(0,2);
        da = da + "/"+ dt.substring(6,10);

        String df = request.getParameter("dataFin");
        String di = df.substring(3,5);
        di = di + "/"+ df.substring(0,2);
        di = di + "/"+ df.substring(6,10);
        String path = getServletContext().getRealPath("/rel/relatorios/");
        Date data1 = new Date(da);
        Date data2 = new Date(di);
        String relJasper = path + "/relPagamentoFuncionario.jasper";
        Map parameters = new HashMap();
        parameters.put("dataIni", data1);
        parameters.put("dataFin", data2);

        JasperPrint report = null;
        try {
            report = JasperFillManager.fillReport(relJasper, parameters, con);
            response.setContentType("application/pdf");

            //export to pdf format
            byte x1[] = JasperExportManager.exportReportToPdf(report);

            //open in browser
            response.getOutputStream().write(x1);
            closeConnection(con);
        } catch (JRException e) {
            System.out.println(e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Métodos HttpServlet. Clique no sinal de + à esquerda para editar o código.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(relPagamentoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(relPagamentoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
