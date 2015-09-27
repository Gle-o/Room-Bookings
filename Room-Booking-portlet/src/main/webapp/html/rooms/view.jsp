<%@include file="/html/init.jsp" %>

<liferay-ui:search-container  searchContainer="${searchContainer}">
	<liferay-ui:search-container-results
		results="${searchContainer.results}"
		total="${searchContainer.total}"
	/>

	<liferay-ui:search-container-row
		className="com.zenixia.plugins.model.Room"
		keyProperty="roomId"
		modelVar="room" escapedModel="true" 
	>
		<liferay-ui:search-container-column-text
			name="Name"
			value="${room.getName(locale)}" 
		/>
		
		<liferay-ui:search-container-column-text
			name="Capacity"
			property="capacity"
		/>
		
		<liferay-ui:search-container-column-text
			name="Level"
			property="level"
		/>
		
		<liferay-ui:search-container-column-jsp
			name="Equipments"
			path="/html/rooms/equipments.jsp"
		/>

		<liferay-ui:search-container-column-jsp
			name="Actions"
			path="/html/rooms/actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="true" searchContainer="${searchContainer}"/>
</liferay-ui:search-container>