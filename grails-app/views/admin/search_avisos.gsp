<g:applyLayout name="admin_layout">
	
    <content tag="body">

		<h2>avisos</h2>	
		
		<evaca:cruderror modelo="${avisos}"/>
		
		<div class="table-responsive" id="admin">
		
		<table class="table cart-table wishlist-table" cellspacing="0">
			<thead>
				<tr class="item">
					<th>fechaCreacion</th>
					<th>lote</th>
					<th>consignatario</th>
					<th>precio</th>
					<th>plazo</th>
					<th>tbState</th>
				</tr>
			</thead>
			
			<tbody>								
				<g:each in="${avisos}" var="aviso" status="i">

					<tr class="item">
						
						<td><g:formatDate date="${aviso.fechaCreacion}" type="datetime"/></td>
						<td>${aviso.lote.raza}</td>
						<td>${aviso.consignatario}</td>
						<td>${aviso.precio}</td>    
						<td>${aviso.plazo}</td>    
						<td><aviso:entityState state="${aviso.state}"/></td>
					</tr>
					
					<tr class="actions">
						<td colspan="6" >
							<g:link class="admin-action" action="admin" id="${aviso.id}">ver Ofertas |</g:link>
							<g:link class="admin-action" action="admin" id="${aviso.id}">ver Reseñas</g:link>&nbsp;&nbsp;&nbsp;&nbsp;
							<g:link params="['aviso.id': aviso.id]" class="admin-action" action="aprobar_aviso" id="${aviso.id}">Aprobar | </g:link>
							<g:link params="['aviso.id': aviso.id]" class="admin-action" action="desaprobar_aviso" id="${aviso.id}">Desaprobar</g:link>
						</td>
					</tr>					
				</g:each>					            
			</tbody>
		</table>

	</content>

</g:applyLayout>