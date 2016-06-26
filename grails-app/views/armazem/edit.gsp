<%@ page import="gerenciadeequipamentos.Armazem" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
	<g:set var="entityName" value="${message(code: 'armazem.label', default: 'Armazem')}" />
	<title><g:message code="default.edit.label" args="[entityName]" /></title>
</head>
<body>
<a href="#show-armazem" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<a href="#edit-armazem" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
	<ul>
		<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
		<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
		<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
	</ul>
</div>
<div id="show-armazem" class="content scaffold-show" role="main">
	<ol class="property-list armazem">
		<g:if test="${armazemInstance?.lotacao}">
			<li class="fieldcontain">
				<span id="lotacao-label" class="property-label"><g:message code="armazem.lotacao.label" default="Lotacao" /></span>

				<span class="property-value" aria-labelledby="lotacao-label"><g:fieldValue bean="${armazemInstance}" field="lotacao"/></span>

			</li>
		</g:if>
		<g:else>
			<p align="center">O armazem está com lotação 0</p>
		</g:else>
	</ol>
</div>
<div id="edit-armazem" class="content scaffold-edit" role="main">
	<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
	<g:if test="${flash.message}">
		<div class="message" role="status">${flash.message}</div>
	</g:if>
	<g:hasErrors bean="${armazemInstance}">
		<ul class="errors" role="alert">
			<g:eachError bean="${armazemInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
			</g:eachError>
		</ul>
	</g:hasErrors>
	<g:form url="[resource:armazemInstance, action:'update']" method="PUT" >
		<g:hiddenField name="version" value="${armazemInstance?.version}" />
		<fieldset class="form">
			<g:render template="form"/>
		</fieldset>
		<fieldset class="buttons">
			<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
		</fieldset>
	</g:form>


</div>
</body>
</html>
