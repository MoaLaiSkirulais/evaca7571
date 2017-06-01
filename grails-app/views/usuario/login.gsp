<g:applyLayout name="crudContainer">

	<h2>login</h2>
	<evaca:cruderror modelo=""/>

	<form method="post">
		<table class="table table-condensed" cellspacing="0">
			<tbody>
				
				<myform:field name="username" label="username" value=""/>
				<myform:field name="password" label="password" value=""/>

				<tr class="order-total">
					<th></th>
					<td class="text-right">
						<div class="form-group text-right">
							<g:actionSubmit action="create" value="create" class="btn btn-default"/>	
							<g:actionSubmit action="login" value="login" class="btn btn-default"/>	
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</form>

</g:applyLayout>