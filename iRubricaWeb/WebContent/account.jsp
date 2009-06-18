<c:choose>
<c:when test="${iduser ==  null }">
<c:if test="${modifica_ok == 'ok'}">
<span id="ok">Utente modificato con successo.</span>
</c:if>
<br/><br/>
Dati utente <b><c:out value="${user.userName}"/></b><br/>
<br/>
Indirizzo e-mail: <b><c:out value="${user.mail}"/></b><br/>
Password: <b><c:out value="${user.passwd}"/></b><br/>
Tipologia utente: <c:out value="${user.type}"/><br/><br/>
<a href="Registrazione?iduser=modifica">Modifica i tuoi dati</a><br/>
<c:out value="${iduser}"/>
</c:when>
<c:when test="${iduser == 'modifica'}">
<form id="menu_registrazione" name="menu_registrazione" action="Registrazione" method="post">
					<table>
					<tr>
					<td><label for="mail">E-mail:</label></td>
					<td><input id="mail" type="text" name="mail" value="${user.mail}"/></td>
					</tr>
					<tr>
					<td><label for="username">Nuova Password:</label></td>
					<td><input id="username" type="password" name="password1" value=""/></td>
					</tr>
					<tr>
					<td><label for="password1">Conferma Nuova Password:</label></td>
					<td><input id="password1" type="password" name="password2"/></td>
					</tr>
					<tr>
					<td><label for="password2">Vecchia Password:</label></td>
					<td><input id="password2" type="text" name="old_password" value="${user.passwd}"/></td>
					<input type="hidden" name="iduser" value=""/>
					<input type="hidden" name="username" value="${user.userName}"/>
					</tr>
					<tr>
					<td colspan="2"><br/><input type="submit" value="modifica"/></td>
					</tr>
					</table>		
				</form>
				</c:when>
</c:choose>
<c:choose>
<c:when test="${user.type == 'admin'}">
<br/><br/><br/>
<b>Lista Utenti della Rubrica</b>
<br/><b>Username/Mail/Type</b><br/><br/>
<c:choose>
			<c:when test="${lista_utenti == 'nessun contatto'}">
				<c:out value='${lista_utenti}'/>
			</c:when>
			<c:otherwise>
				<c:forEach	items="${lista_utenti}" var="utente">
				 	<c:out value='${utente.userName}'/>&nbsp;<c:out value='${utente.mail}'/>&nbsp;
				 	<c:out value='${utente.type}'/><br/>
				 </c:forEach>
			</c:otherwise>
			</c:choose>
</c:when>
</c:choose>
