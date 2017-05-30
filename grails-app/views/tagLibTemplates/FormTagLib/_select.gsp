<tr class="cart-subtotal">
	<th>${attrs.label}</th>	
	<td class="text-right">
		<span class="amount">
			<g:select 
				name="${attrs.name}" 
				from="${attrs.from}" 
				value="${attrs.value}" 
				optionKey="${attrs.optionKey}" 
				/>
		</span>
	</td>
</tr>
