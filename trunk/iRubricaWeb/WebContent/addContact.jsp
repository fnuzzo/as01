<center>
<form id="add_contact" name="add_contact" action="Contact" method="post">
<table width="600px">
	<tr>
		<td><label for="name">Nome*:</label></td>
		<td><input id="name" type="text" size="15" name="name"/></td>
		<td><label for="surname">Cognome*:</label></td>
		<td><input id="surname" type="text" size="15" name="surname"/></td>
	</tr>
	<tr>
		<td><label for="mail">E-mail:</label></td>
		<td><input id="mail" type="text" size="15" name="mail"/></td>
		<td><label for="web">Web:</label></td>
		<td><input id="web" type="text" size="15" name="web"/></td>
	</tr>
	<tr>
		<td><label for="phone_home">Telefono casa:</label></td>
		<td><input id="phone_home" type="text" size="15" name="phone_home"/></td>
		<td><label for="phone_office">Telefono ufficio:</label></td>
		<td><input id="phone_office" type="text" size="15" name="phone_office"/></td>
	</tr>	
	<tr>
		<td><label for="fax">Fax:</label></td>
		<td><input id="fax" type="text" size="15" name="fax"/></td>
		<td><label for="cell">Cellulare:</label></td>
		<td><input id="cell" type="text" size="15" name="cell"/></td>
	</tr>	
	<tr>
		<td><label for="city">City:</label></td>
		<td><input id="city" type="text" size="15" name="city"/></td>
		<td><label for="state">State:</label></td>
		<td><input id="state" type="text" size="15" name="state"/></td>
	</tr>	
	<tr>
		<td><label for="address_home">Indirizzo casa*:</label></td>
		<td><textarea name="address_home"></textarea><br/></td>
		<td><label for="address_office">Indirizzo ufficio:</label></td>
		<td><textarea name="address_office"></textarea><br/></td>
	</tr>	
	<tr>
		<td><label for="other">Other:</label></td>
		<td><input id="other" type="text" size="15" name="other"/></td>
		<td><label for="note">Note:</label></td>
		<td><textarea name="note"></textarea><br/></td>
	</tr>	
	<tr>
		<td colspan="4"><input type="submit" value="Salva" name="salva"/></td>
	</tr>
</table>
</form>		
<span id="errore"><c:out value="${msgError}"/></span>
</center>
