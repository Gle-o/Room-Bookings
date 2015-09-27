<%@include file="/html/init.jsp" %>

<c:forEach var="equipment" items="${SEARCH_CONTAINER_RESULT_ROW.getObject().getEquipements()}">
	<span class="badge badge-info">${equipment.getName(locale)} ${equipment.reference}</span>
</c:forEach>