
<%@ page import="gerenciadeequipamentos.Equipamento" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'equipamento.label', default: 'Equipamento')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-equipamento" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-equipamento" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list equipamento">
			
				<g:if test="${equipamentoInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="equipamento.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${equipamentoInstance}" field="status"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${equipamentoInstance?.localizacao}">
				<li class="fieldcontain">
					<span id="localizacao-label" class="property-label"><g:message code="equipamento.localizacao.label" default="Localizacao" /></span>
					
						<span class="property-value" aria-labelledby="localizacao-label"><g:fieldValue bean="${equipamentoInstance}" field="localizacao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${equipamentoInstance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="equipamento.nome.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${equipamentoInstance}" field="nome"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${equipamentoInstance?.data}">
				<li class="fieldcontain">
					<span id="data-label" class="property-label"><g:message code="equipamento.data.label" default="Data" /></span>
					
						<span class="property-value" aria-labelledby="data-label"><g:formatDate date="${equipamentoInstance?.data}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:equipamentoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${equipamentoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
