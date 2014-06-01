
<b> <%  out.print(session.getAttribute("user"));%> </b>
<a href="welcomeJSF.faces?sair=sair">Sair</a>

<%
            if (request.getParameter("sair") != null) {
                session.setAttribute("usuario", false);
                response.sendRedirect("logar.faces");
            }
%>