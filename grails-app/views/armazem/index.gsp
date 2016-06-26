
<%@ page import="gerenciadeequipamentos.Armazem" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'armazem.label', default: 'Armazem')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-armazem" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-armazem" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
						<g:sortableColumn property="nome" title="${message(code: 'armazem.nome.label', default: 'Nome')}" />
						<g:sortableColumn property="areaUtil" title="${message(code: 'armazem.areaUtil.label', default: 'Area Util')}" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${armazemInstanceList}" status="i" var="armazemInstance">
					<tr class="${ armazemInstance.cheio == false ? 'clear' : 'full'}">

						<td><g:link action="show" id="${armazemInstance.id}">${fieldValue(bean: armazemInstance, field: "nome")}</g:link></td>
					
						<td>${fieldValue(bean: armazemInstance, field: "areaUtil")}</td>

					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${armazemInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
