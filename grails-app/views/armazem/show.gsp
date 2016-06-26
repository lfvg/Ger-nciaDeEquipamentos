
<%@ page import="gerenciadeequipamentos.Armazem" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'armazem.label', default: 'Armazem')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-armazem" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-armazem" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list armazem">
			
				<g:if test="${armazemInstance?.areaUtil}">
				<li class="fieldcontain">
					<span id="areaUtil-label" class="property-label"><g:message code="armazem.areaUtil.label" default="Area Util" /></span>
					
						<span class="property-value" aria-labelledby="areaUtil-label"><g:fieldValue bean="${armazemInstance}" field="areaUtil"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${armazemInstance?.lotacao}">
				<li class="fieldcontain">
					<span id="lotacao-label" class="property-label"><g:message code="armazem.lotacao.label" default="Lotacao" /></span>
					
						<span class="property-value" aria-labelledby="lotacao-label"><g:fieldValue bean="${armazemInstance}" field="lotacao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${armazemInstance?.cheio}">
				<li class="fieldcontain">
					<span id="cheio-label" class="property-label"><g:message code="armazem.cheio.label" default="Cheio" /></span>
					
						<span class="property-value" aria-labelledby="cheio-label"><g:formatBoolean boolean="${armazemInstance?.cheio}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${armazemInstance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="armazem.nome.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${armazemInstance}" field="nome"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:armazemInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${armazemInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
