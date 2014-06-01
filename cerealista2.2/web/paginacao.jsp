<t:dataScroller id="scroll"
                for="data"
                fastStep="10"
                pageCountVar="pageCount"
                pageIndexVar="pageIndex"
                styleClass="scroller"
                paginator="true"
                paginatorMaxPages="15"
                paginatorTableClass="table"
                paginatorActiveColumnStyle="font-weight:bold;">


    <f:facet name="first" >
        <t:outputText value="Primeira"/>
    </f:facet>
    <f:facet name="last">
        <t:outputText value="Ultima"/>
    </f:facet>
    <f:facet name="previous">
        <t:outputText value="Anterior"/>
    </f:facet>
    <f:facet name="next">
        <t:outputText value="Próxima"/>
    </f:facet>
</t:dataScroller>