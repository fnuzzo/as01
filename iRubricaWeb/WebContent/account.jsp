<c:choose>
<c:when test="${iduser ==  null }">
Dati utente <b><c:out value="${user.userName}"/></b><br/>
<br/>
Indirizzo e-mail: <b><c:out value="${user.mail}"/></b><br/>
Tipologia utente: <c:out value="${user.type}"/><br/><br/>
<a href="Registrazione?idmod=1">Modifica mail</a><br/>
<a href="Registrazione?idmod=2">Modifica password</a><br/>
<c:out value="${iduser}"/>
<br/>
<span id="ok"><c:out value="${modifica_ok}"/></span>
</c:when>
<c:when test="${iduser == 'modifica_mail'}">
<form id="menu_registrazione" name="menu_registrazione" action="Registrazione" method="post">
<table>
	<tr>
		<td><label for="mail">E-mail:</label><br/>
			<input id="mail" type="text" name="mail" value="${user.mail}"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="hidden" name="iduser" value="mod_mail"/>
			<input type="hidden" name="username" value="${user.userName}"/>
			<br/><input type="submit" value="modifica"/><br/>
			<br/><span id="errore"><c:out value="${errorMex}"/></span>
		</td>
	</tr>
</table>		
</form>
</c:when>
<c:when test="${iduser == 'modifica_pass'}">
<form id="menu_registrazione" name="menu_registrazione" action="Registrazione" method="post">
<table>
<tr>
		<td><label for="old_password">Vecchia Password:</label><br/>
			<input type="text" name="old_password" /></td>
	</tr>
<tr>
		<td><label for="password1">Nuova Password:</label><br/>
			<input type="password" name="password1" value=""/></td>
	</tr>
	<tr>
		<td><label for="password2">Conferma Nuova Password:</label><br/>
		 	<input type="password" name="password2"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="hidden" name="iduser" value="mod_pass"/>
			<input type="hidden" name="username" value="${user.userName}"/>
			<br/><input type="submit" value="modifica"/><br/>
			<br/><span id="errore"><c:out value="${errorMex}"/></span>
		</td>
	</tr>
</table>		
</form>
</c:when>
</c:choose>

<c:choose>
<c:when test="${user.type == 'admin'}">
<span id="titleListUser"><b>Lista Utenti della Rubrica</b><br/></span>
<div id="listUser">
<table>
<tr><td align="center"><b>Username</b></td>
	<td align="center"><b>Mail</b></td>
	<td align="center"><b>Type</b></td>
	<td align="center"><b>Azioni</b></td></tr>
	<c:choose>
		<c:when test="${lista_utenti == 'nessun contatto'}">
			<c:out value='${lista_utenti}'/>
		</c:when>
		<c:otherwise>
			<c:forEach	items="${lista_utenti}" var="utente">
			<tr>
			 	<td><c:out value='${utente.userName}'/></td>
				<td><c:out value='${utente.mail}'/></td>
				<td><c:out value='${utente.type}'/></td>
				<c:choose>
					<c:when test="${utente.type == 'inattesa'}">
						<td width="100">
							<a href="Admin?act=attiva&username=${utente.userName}">[attiva]</a> 
							<a href="Admin?act=elimina&username=${utente.userName}">[elimina]</a></td>
					</c:when>
					<c:when test="${utente.type == 'normale'}">
						<td><a href="Admin?act=modifica&username=${utente.userName}&status=super">[rendi super]</a>
							<a href="Admin?act=elimina&username=${utente.userName}">[elimina]</a></td>
					</c:when>
					<c:when test="${utente.type == 'super'}">
						<td><a href="Admin?act=modifica&username=${utente.userName}&status=normale">[rendi normale]</a>
							<a href="Admin?act=elimina&username=${utente.userName}">[elimina]</a></td>
					</c:when>
					<c:when test="${utente.type == 'admin'}">
						<td>&nbsp;</td>
					</c:when>
				</c:choose>
			</tr>
			</c:forEach>
</table>
</div>
</c:otherwise>
</c:choose>
</c:when>
</c:choose>
