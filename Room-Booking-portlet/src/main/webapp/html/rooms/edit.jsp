<%@include file="/html/init.jsp"%>

<aui:model-context bean="${room}" model="${model}" />

<portlet:actionURL var="editRoomURL" windowState="normal" name="addRoom" />

<c:set var="portletNamespace">
	<portlet:namespace />
</c:set>

<aui:form action="${editRoomURL}" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="${redirect}" />

		<aui:input type="hidden" name="roomId" />

		<liferay-ui:error key="name-required" message="this-field-is-required" />
		<aui:input name="name" label='com.zenixia.plugin.room.management.room.name'>
			<aui:validator name="required" />
		</aui:input>

		<liferay-ui:error key="description-required" message="this-field-is-required" />
		<aui:field-wrapper label="com.zenixia.plugin.room.management.room.description" name="description" required="true">
			<liferay-ui:input-editor name="description" resizable="true"/>
		</aui:field-wrapper>

		<liferay-ui:error key="capacity-required" message="this-field-is-required" />
		<liferay-ui:error key="capacity-number-required" message="please-enter-a-valid-number" />
		<aui:input name="capacity" label='com.zenixia.plugin.room.management.room.capacity'>
			<aui:validator name="required" />
			<aui:validator name="number"/>
		</aui:input>

		<liferay-ui:error key="level-required" message="this-field-is-required" />
		<liferay-ui:error key="level-number-required" message="please-enter-a-valid-number" />
		<aui:input name="level" label='com.zenixia.plugin.room.management.room.level'>
			<aui:validator name="required" />
			 <aui:validator name="number"/>
		</aui:input>

		<aui:input name="currentEquipementIds" type="hidden" />
		<c:forEach var="equipmentType" items="${equipmentTypes}">
			<liferay-ui:panel id="${portletNamespace}${equipmentType.equipmentTypeId}" title="${equipmentType.getName(locale)}" iconCssClass="icon-archive" persistState="false" extended="true"
				collapsible="true" state="open">
				<liferay-ui:input-move-boxes
					leftBoxName="${equipmentType.equipmentTypeId}currentEquipementIds"
					leftList="${equipmentType.getTypesLeftList()}"
					leftTitle="current"
					rightBoxName="${equipmentType.equipmentTypeId}availableEquipementIds"
					rightList="${equipmentType.getTypesRightList()}"
					rightTitle="available" />
			</liferay-ui:panel>
		</c:forEach>


	</aui:fieldset>

	<c:if test="${room eq null}">
		<aui:field-wrapper label="permissions">
			<liferay-ui:input-permissions modelName="${model.getName()}" />
		</aui:field-wrapper>
	</c:if>

	<aui:button-row>
		<aui:button type="submit" onclick="${portletNamespace}submitForm();" />
		<aui:button type="cancel" />
	</aui:button-row>
</aui:form>

<aui:script use="aui-base,liferay-util-list-fields">
	Liferay.provide(  
		window,  
		'<portlet:namespace />submitForm',  
		 function() {
		 	var currentEquipementIds = [];
		 	<c:forEach var="equipmentType" items="${equipmentTypes}">
		 		var array = Liferay.Util.listSelect(document.<portlet:namespace />fm.<portlet:namespace />${equipmentType.equipmentTypeId}currentEquipementIds).split(',');
		 		
		 		A.Array.each(
					array,
					function(item, index, collection) {
						currentEquipementIds.push(item);
					}
				);
		 	</c:forEach>
		 	A.Array.removeItem(currentEquipementIds, "");
		 	
		 	document.<portlet:namespace />fm.<portlet:namespace />currentEquipementIds.value = currentEquipementIds;
		 	
		 },['liferay-util-list-fields']
	 );
	 
	var rules = {
		<portlet:namespace/>description: {
		 	required: true
		},
		<portlet:namespace/>capacity: {
			min: 1
		}
	};
	
	var validator = new A.FormValidator({
		boundingBox: document.<portlet:namespace />fm,
		rules: rules,
		validateOnBlur: true
	});
</aui:script>

<aui:script>
	function <portlet:namespace />initEditor() {
		return "${content}";
	}
	
function <portlet:namespace />extractCodeFromEditor() {
	   document.<portlet:namespace />fm.<portlet:namespace />description.value = window.<portlet:namespace />description.getHTML();
	}
</aui:script>