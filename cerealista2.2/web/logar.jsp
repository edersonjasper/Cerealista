<%@include file="tagLib.jsp" %>
<%-- 
    Document   : logar
    Created on : 05/08/2009, 16:06:37
    Author     : Eder
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logar!</title>
    </head>
    <body>
        
        <f:view>
            <h:form>
                <div align="center">
                    <b id="titulo">Logar!</b>
                    <div id="corFundo" style="width:30%;">
                        Usuário: <h:inputText id="usu" required="true" requiredMessage="Informe o usuário de acesso!" value="#{UsuarioFaces.usuario}"/>
                        <b id="obrigatorio"> <h:message for="usu"/> </b> <br/><br/>
                        Senha: <h:inputSecret id="senha" required="true" requiredMessage="Informe a senha de acesso!" value="#{UsuarioFaces.senha}"/>
                        <b id="obrigatorio"> <h:message for="senha"/> </b> <br/><br/>
                        <h:commandButton action="#{UsuarioFaces.doLogin}" value="Logar"/>
                    </div>
                </div>
            </h:form>
        </f:view>
    </body>
</html>
