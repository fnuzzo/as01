<c:choose>
	<c:when test="${operazione == 'edit'}">
		<h2>Modifica dati contatto</h2>
		<center>
		<form id="mod_contact" name="mod_contact" action="Contact" method="post">
		<table cellpadding="5" width="500px">
			<tr><td><label for="name">Nome:</label></td>
				<td><input id="name" type="text" size="15" name="name" value="${name}"/></td>
				<td rowspan="4" colspan="2" valign="top"><img src="template/male.jpg"/></td>
			</tr>
			<tr><td><label for="surname">Cognome:</label></td>
				<td><input id="surname" type="text" size="15" name="surname" value="${surname}"/></td></tr>
			<tr><td><label for="mail">E-mail:</label></td>
				<td><input id="mail" type="text" size="15" name="mail" value='${mail}'/></td></tr>
			<tr><td><label for="skype">Skype:</label></td>
				<td><input id="skype" type="text" size="15" name="skype" value='${skype}'/></td></tr>
			<tr><td><label for="phone">Telefono:</label></td>
				<td><input id="phone" type="text" size="15" name="phone" value='${phone}'/></td>
				<td><label for="cell">Cellulare:</label></td>
				<td ><input id="cell" type="text" size="15" name="cell" value='${cell}'/></td></tr>
			<tr><td><label for="adress">Indirizzo:</label></td>
				<td><textarea name="adress" rows="5" cols="25"><c:out value='${adress}'/></textarea></td>
				<td><label for="note">Note:</label></td>
				<td><textarea name="note" rows="5" cols="25"><c:out value='${note}'/></textarea></td></tr>
			<tr><td><td colspan="3"><input type="submit" value="Salva modifiche"/></td></tr>
		</table>
		</form>
		</center>		
	</c:when>
	<c:when test="${operazione == 'del'}">
		<h2>Contatto eliminato con successo!</h2>
		Implementare la fulzione di cancellazione contatto
	</c:when>
	<c:otherwise>
		<h2>Scheda contatto</h2>
		<center>
		<table cellpadding="5" width="500px">
		<tr><td>Nome:</td><td><c:out value='${name}'/></td>
			<td rowspan="8" valign="top"><img src="template/male.jpg"/></td>
		</tr>
		<tr><td>Cognome:</td><td><c:out value='${surname}'/></td></tr>
		<tr><td>Email:</td><td><c:out value='${mail}'/></td></tr>
		<tr><td>Skype:</td><td><c:out value='${skype}'/></td></tr>
		<tr><td>Telefono:</td><td><c:out value='${phone}'/></td></tr>
		<tr><td>Cellulare:</td><td ><c:out value='${cell}'/></td></tr>
		<tr><td>Indirizzo:</td><td><c:out value='${adress}'/></td></tr>
		<tr><td>Note:</td><td><c:out value='${note}'/></td></tr>
		</table>
		</center><br/>	
		<a href="ViewContact?id=edit"><img src="template/edit.jpg"/></a>
		<a href="ViewContact?id=del"><img src="template/delete.jpg"/></a>
    </c:otherwise>
</c:choose>
