<g:set var="months" value="${new java.text.DateFormatSymbols().months}"/>
<g:select class="col l4 m4 s12" name="${property}_day" from="${1..31}" />
<g:select class="col l4 m4 s12" name="{property}_month" from="${months as List}" />
<g:select class="col l4 m4 s12" name="{property}_year" from="${1947..2016}" />

!!!
<g:select id="active" name="active" from="${['Enabled','Disabled']}" keys="${[1,0]}" value="${0}" />
