
<%@include file="tagLib.jsp" %>

<f:view>
    
    <div id="corFundo" style="width:40%">
        <h:form>
            <h:outputText value="#{BackupFaces.sucesso}"/><br>
            <h:commandButton action="#{BackupFaces.iniciaBackup}" value="Backup" />
        </h:form>
    </div>
</f:view>
