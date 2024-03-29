<%@ include file="initjsp.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>iRubrica</title>
<link rel="stylesheet" href="style.css" type="text/css" />
</head>
<body>
<div id="central">
	<div id="container">
		<div id="logo"><img src="template/irubrica.jpg" alt="iRubrica"/></div>
		<div id="form">	
		<br/><table>
		<tr><td><span><a href="Login?id=0">Hai dimenticato la password?</a></span></td></tr>
		<tr><td>
		<form id="menu_login" name="menu_login" action="Login" method="post">
			<span>User:</span>
			<input id="username_login" type="text" size="15" name="username_login"/>
			<span>Pass:</span>
			<input id="pass_login" type="password" size="15" name="pass_login"/>	
			<input type="submit" value="Accedi" name="accedi" />
		</form>
		</td></tr>
   	    </table>
   	    </div>
	</div>
	<div id="content"><br/>
		<table align="center">
		<tr>
			<td width="550px" rowspan="3">
				<br/><img src="template/testo.jpg"/><img src="template/share.jpg"/>
			</td>
			<td width="350px" height="50px">
			 	<span id="errore"><c:out value='${mgerrore}'/></span> 
			</td>
		</tr>
		<tr>
			<td>
				<c:choose>
				<c:when test="${op=='0'}">	
				<img src="template/recupera.jpg"/>
				<form id="menu_recupera" name="menu_recupera" action="Registrazione" method="post">
				<table>
					<tr>
						<td><label for="username">Username:</label></td>
						<td><input id="username" type="text" name="username"/></td>
					</tr>	
					<tr>
						<td colspan="2"><br/>
						<input type="hidden" name="iduser" value="recupera"/>
						<input type="submit" name="recupera" value="Recupera password"/>
						</td>
					</tr>
					<tr><td colspan="2">
						<br/><br/>
						<h2>Torna alla <a href="Login">Registrazione</a></h2>
					</td><tr>
				</table>
				</form>
				</c:when>
				<c:otherwise>
				<img src="template/reg.jpg"/>
				<form id="menu_registrazione" name="menu_registrazione" action="Registrazione" method="post">
					<table>
					<tr>
					<td><label for="username">Username:</label></td>
					<td><input id="username" type="text" name="username" value="<c:out value='${username}'/>"/></td>
					</tr>
					<tr>
					<td><label for="mail">E-mail:</label></td>
					<td><input id="mail" type="text" name="mail" value="<c:out value='${email}'/>"/></td>
					</tr>
					<tr>
					<td><label for="password1">Password:</label></td>
					<td><input id="password1" type="password" name="password1"/></td>
					</tr>
					<tr>
					<td><label for="password2">Conferma Password:</label></td>
					<td><input id="password2" type="password" name="password2"/></td>
					</tr>
					<tr>
					<td colspan="2"><br/>
					<input type="hidden" name="iduser" value="new"/>
					<input type="submit" name="registrati" value="Registrati"/></td>
					</tr>
					</table>		
				</form>
				
				</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td height="100px" valign="top">
			<c:choose>
				<c:when test="${errorMex == null}">
					<span id="ok"><c:out value='${okMex}'/></span> 	
				</c:when>
				<c:otherwise>
					<span id="errore"><c:out value='${errorMex}'/></span>
				</c:otherwise>
			</c:choose>
			</td>
		</tr>
		</table> 
	</div>
</div>
</body>
</html>