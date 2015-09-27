<%@include file="/html/init.jsp" %>

<liferay-ui:search-container  searchContainer="${searchContainer}">
	<liferay-ui:search-container-results
		results="${searchContainer.results}"
		total="${searchContainer.total}"
	/>

	<liferay-ui:search-container-row
		className="com.zenixia.plugins.model.Equipment"
		keyProperty="equipmentId"
		modelVar="equipmentType" escapedModel="true" 
	>
		<liferay-ui:search-container-column-text
			name="Name"
			value="${equipmentType.getName(locale)}" 
		/>
		
		<liferay-ui:search-container-column-text
			name="Reference"
			property="reference"
		/>
		
		<liferay-ui:search-container-column-text
			name="Equipement Type"
			value="${equipmentType.getEquipmentTypeName(locale)}" 
		/>

		<liferay-ui:search-container-column-jsp
			name="Actions"
			path="/html/equipment/actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="true" searchContainer="${searchContainer}"/>
</liferay-ui:search-container>