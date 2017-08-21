<!-- <tr class="description"> -->
<tr>
	<th>
		${attrs.label}
	</th>	
	<td class="text-right">
		<span class="amount">
			<g:select style="${attrs.style}"
				name="${attrs.name}" 
				from="${attrs.from}" 
				value="${attrs.value}" 
				optionKey="${attrs.optionKey}"  
				noSelection="${['':'Select One...']}"
				class="FormTagLib_field"
				/>
		</span>
	</td>
</tr>
