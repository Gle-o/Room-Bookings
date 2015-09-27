<%@include file="/html/init.jsp" %>

<aui:model-context bean="${equipment}" model="${model}" />

<portlet:actionURL var="editEquipmentURL" windowState="normal" name="addEquipment"/>

<aui:form action="${editEquipmentURL}" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="${redirect}" />

		<aui:input type="hidden" name="equipmentId" />

		<liferay-ui:error key="name-required" message="this-field-is-required" />
		<aui:input name="name" label='com.zenixia.plugin.room.management.equipment.type.name' >
				<aui:validator name="required"/>
		</aui:input>
		
		<liferay-ui:error key="reference-required" message="this-field-is-required" />
		<aui:input name="reference" label='com.zenixia.plugin.room.management.equipment.type.reference' >
				<aui:validator name="required"/>
		</aui:input>
		
		<liferay-ui:error key="equipment-type-required" message="this-field-is-required" />
		<aui:select name="equipmentTypeId" label='com.zenixia.plugin.room.management.equipment.type.equipement.type' showEmptyOption="true">
			<c:forEach var="equipmentType" items="${equipmentTypes}">
				<aui:option label="${equipmentType.getName(locale)}" value="${equipmentType.getEquipmentTypeId()}" />
			</c:forEach>
		</aui:select>
	</aui:fieldset>

	<c:if test="${equipment eq null}">
		<aui:field-wrapper label="permissions">
			<liferay-ui:input-permissions
				modelName="${model.getName()}"
				/>
		</aui:field-wrapper>
	</c:if>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel" />
	</aui:button-row>
</aui:form>

<aui:script use="aui-base,aui-form-validator">
	var rules = {
		<portlet:namespace/>equipmentTypeId: {
		 	required: true
		}	
	};
	
	var validator = new A.FormValidator({
		boundingBox: document.<portlet:namespace />fm,
		rules: rules,
		validateOnBlur: true
	});
</aui:script>