
<%@include file="tagLib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%--
    This file is an entry point for JavaServer Faces application.
--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>
            <%
                if (request.getParameter("id") != null) {
                    out.print(request.getParameter("id"));
                } else {
                    out.print(session.getAttribute("id"));
                }
            %>
            .:Versão 2.2:.
        </title>
    </head>
    <body>

        <div id="topo" align="right">            
            <%@include file="topo.jsp" %>
        </div>
        <div id="centro">
            <div class="menu">
                <%@include file="menu.jsp" %>
            </div>
            <div class="conteudo">
                <%@include file="include.jsp" %>
            </div>
        </div>

    </body>
</html>
