<%@include file="tagLib.jsp" %>
<%-- 
    Document   : addCor
    Created on : 26/08/2009, 21:40:59
    Author     : ederson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Cor!</title>
    </head>
    <body>
        <c:if test="${CorFaces.selectedCor.corNome == null}">
            <b id="titulo">Cadastrar Cor!</b>
        </c:if>
        <c:if test="${CorFaces.selectedCor.corNome != null}">
            <b id="titulo">Atualizar Cor!</b>
        </c:if>
            <f:view>
                <div id="corFundo">
                    <h:form id="form">
                        <b id="erro"> <h:message for="form"/> </b><br/>
                        Cor: <h:inputText id="cor" required="true" requiredMessage="Informe a cor!" value="#{CorFaces.selectedCor.corNome}"/>
                        <b id="obrigatorio">
                            <h:message for="cor"/>
                        </b>
                        <br/>
                        <br/>
                        <h:commandButton action="gotoListCor" value="Cancelar" immediate="true"/>
                        <h:commandButton action="#{CorFaces.finishAddCor}" value="Salvar" />
                    </h:form>

                </div>
            </f:view>

    </body>
</html>
