<%@include file="/html/init.jsp" %>

<aui:model-context bean="${equipmentType}" model="${model}" />

<portlet:actionURL var="editEquipmentTypeURL" windowState="normal" name="addEquipmentType"/>

<aui:form action="${editEquipmentTypeURL}" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="${redirect}" />

		<aui:input type="hidden" name="equipmentTypeId" />

		<liferay-ui:error key="label-required" message="this-field-is-required" />

		<aui:input name="name" label='com.zenixia.plugin.room.management.equipment.type' >
				<aui:validator name="required"/>
		</aui:input>
	</aui:fieldset>

	<c:if test="${equipmentType eq null}">
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