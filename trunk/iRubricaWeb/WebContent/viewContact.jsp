<c:choose>
	<c:when test="${operazione == 'edit'}">
		<h2>Modifica dati contatto</h2>
		<center>
		<form id="mod_contact" name="mod_contact" action="Contacts" method="post">
		<table border="0" cellpadding="0" width="600px">
			<tr><td><label for="name">Nome:</label></td>
				<td><input maxlength="15" type="text" size="15" name="name" value="${contatto.name}"/></td>
				<td rowspan="4" colspan="2" align="center"><img src="template/male.jpg"/></td>
			</tr>
			<tr><td><label for="surname">Cognome:</label></td>
				<td><input maxlength="15" type="text" size="15" name="surname" value="${contatto.surname}"/></td></tr>
			<tr><td><label for="mail">E-mail:</label></td>
				<td><input maxlength="20" type="text" size="15" name="mail" value='${contatto.email}'/></td></tr>
			<tr><td><label for="web">Web:</label></td>
				<td ><input maxlength="20" type="text" size="15" name="web" value='${contatto.web}'/></td></tr>
			<tr><td><label for="city">Citta:</label></td>
				<td><input maxlength="15" type="text" size="15" name="city" value='${contatto.city}'/></td>
				<td><label for="state">Stato:</label></td>
				<td ><input maxlength="15" type="text" size="15" name="state" value='${contatto.state}'/></td></tr>
			<tr><td><label for="phone_home">Telefono casa:</label></td>
				<td><input maxlength="11" type="text" size="15" name="phone_home" value='${contatto.tel_home}'/></td>
				<td><label for="phone_office">Telefono ufficio:</label></td>
				<td><input maxlength="11" type="text" size="15" name="phone_office" value='${contatto.tel_office}'/></td>
			</tr>
			<tr><td><label for="cell">Cellulare:</label></td>
				<td ><input maxlength="10" type="text" size="15" name="cell" value='${contatto.mobile_tel}'/></td>
				<td><label for="fax">Fax:</label></td>
				<td><input maxlength="11" type="text" size="15" name="fax" value='${contatto.fax}'/></td></tr>

			<tr><td><label for="address_home">Indirizzo casa:</label></td>
				<td><input maxlength="25" type="text" size="15" name="address_home" value='${contatto.address_home}'/></td>
				<td><label for="address_office">Indirizzo ufficio:</label></td>
				<td><input maxlength="25" type="text" size="15" name="address_office" value='${contatto.address_office}'/></td>
			</tr>
			<tr><td valign="top"><label for="other">Altro:</label></td>
				<td valign="top"><input maxlength="20" type="text" size="15" name="other" value='${contatto.other}'/></td>
				<td valign="top"><label for="note">Note:</label></td>
				<td><textarea name="note" rows="5" cols="25"><c:out value='${contatto.note}'/></textarea></td>
			</tr>			
			<tr><td colspan="4">
				<input type="hidden" name="idcontact" value="${contatto.id}"/>
				<input type="submit" name="salva" value="Salva modifiche"/>
				<span id="errore">&nbsp;<c:out value="${msgError}"/></span>
			</td></tr>
		</table>
		</form>
		</center>		
	</c:when>
	<c:when test="${operazione == 'del'}">
		<h2>Contatto eliminato con successo!</h2>
		<c:out value="${deleteOk}" />
		<span id="errore"><c:out value="${deleteErr}"/></span> 
	</c:when>
	
	<c:otherwise>
		<h2>Scheda contatto</h2>
		<center>
		<table border="0" cellpadding="5" width="600px">
		<tr><td bgcolor="#c9d7e0" width="100">Nome:</td><td><c:out value='${contatto.name}'/></td>
			<td rowspan="5" colspan="2" align="right"><img src="template/male.jpg"/></td>
		</tr>
		<tr><td bgcolor="#c9d7e0">Cognome:</td><td><c:out value='${contatto.surname}'/></td></tr>
		<tr><td bgcolor="#c9d7e0">Email:</td><td><c:out value='${contatto.email}'/></td></tr>
		<tr><td bgcolor="#c9d7e0">Altro:</td><td><c:out value='${contatto.other}'/></td></tr>
		<tr><td bgcolor="#c9d7e0">Web:</td><td><c:out value='${contatto.web}'/></td></tr>
		<tr><td bgcolor="#c9d7e0">Citta:</td><td><c:out value='${contatto.city}'/></td>
			<td bgcolor="#c9d7e0" width="100">Stato:</td><td><c:out value='${contatto.state}'/></td></tr>
		<tr><td bgcolor="#c9d7e0">Telefono casa:</td><td><c:out value='${contatto.tel_home}'/></td>
			<td bgcolor="#c9d7e0">Telefono ufficio:</td><td><c:out value='${contatto.tel_office}'/></td></tr>
		<tr><td bgcolor="#c9d7e0">Cellulare:</td><td ><c:out value='${contatto.mobile_tel}'/></td>
			<td bgcolor="#c9d7e0">Fax:</td><td><c:out value='${contatto.fax}'/></td></tr>
		<tr><td bgcolor="#c9d7e0">Indirizzo casa:</td><td><c:out value='${contatto.address_home}'/></td>
			<td bgcolor="#c9d7e0">Indirizzo ufficio:</td><td><c:out value='${contatto.address_office}'/></td></tr>
		<tr><td bgcolor="#c9d7e0">Note:</td><td colspan="3"><c:out value='${contatto.note}'/></td></tr>
		</table>
		</center><br/>
		<c:choose>
		<c:when test="${user.type == 'super' || user.type == 'admin' || user.id == contatto.idCreatore}">	
		<a href="ViewContact?op=edit&idcon=${contatto.id}"><img src="template/edit.jpg"/></a>
		<a href="ViewContact?op=del&idcon=${contatto.id}"><img src="template/delete.jpg"/></a>
		</c:when>
		</c:choose>
    </c:otherwise>
</c:choose>
