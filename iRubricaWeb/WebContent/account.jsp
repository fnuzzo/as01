<c:choose>
<c:when test="${modifica_ok == 'ok'}">
Ok, modificato.
</c:when>
<c:otherwise>
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
</c:otherwise>
</c:choose>
