<form id="menu_registrazione" name="menu_registrazione" action="Registrazione" method="post">
					<table>
					<tr>
					<td><label for="mail">E-mail:</label></td>
					<td><input id="mail" type="text" name="mail" value="<c:out value='${email}'/>"/></td>
					</tr>
					<tr>
					<td><label for="username">Nuova Password:</label></td>
					<td><input id="username" type="password" name="password1" value="<c:out value='${username}'/>"/></td>
					</tr>
					<tr>
					<td><label for="password1">Conferma Nuova Password:</label></td>
					<td><input id="password1" type="password" name="password2"/></td>
					</tr>
					<tr>
					<td><label for="password2">Vecchia Password:</label></td>
					<td><input id="password2" type="password" name="old_password"/></td>
					</tr>
					<tr>
					<td colspan="2"><br/><input type="submit" value="registrati"/></td>
					</tr>
					</table>		
				</form>