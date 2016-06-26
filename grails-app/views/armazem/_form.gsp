<%@ page import="gerenciadeequipamentos.Armazem" %>



<div class="fieldcontain ${hasErrors(bean: armazemInstance, field: 'areaUtil', 'error')} required">
	<label for="areaUtil">
		<g:message code="armazem.areaUtil.label" default="Area Util" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="areaUtil" type="number" value="${armazemInstance.areaUtil}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: armazemInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="armazem.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${armazemInstance?.nome}"/>

</div>
