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
		<td><label for="skype">Skype:</label></td>
		<td><input id="skype" type="text" size="15" name="skype"/></td>
	</tr>
	<tr>
		<td><label for="phone">Telefono:</label></td>
		<td><input id="phone" type="text" size="15" name="phone"/></td>
		<td><label for="cell">Cellulare:</label></td>
		<td><input id="cell" type="text" size="15" name="cell"/></td>
	</tr>	
	<tr>
		<td><label for="adress">Indirizzo*:</label></td>
		<td><textarea name="adress"></textarea><br/></td>
		<td><label for="note">Note:</label></td>
		<td><textarea name="note"></textarea><br/></td>
	</tr>	
	<tr>
		<td colspan="4"><input type="submit" value="Salva" /></td>
	</tr>
</table>
</form>		
<span id="errore"><c:out value="${msgError}"/></span>
</center>
