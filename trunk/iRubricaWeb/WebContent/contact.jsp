<%@ include file="initjsp.jsp" %>

<c:if test="${logged_user == 'no' || logged_user == null}"><c:redirect url="enter.jsp"/></c:if>
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
		<br/>
		<table>
		<tr><td></td></tr>
		<tr><td>
		<form id="menu_login" name="menu_login" action="" method="post">
			<br/><span>Ricerca contatto:</span>
			<select name="ricerca">   
  			     <option value="perNome" selected>per nome</option>
  			     <option value="perTelefono">per telefono</option>
  			     <option value="perEmail">per email</option>
  			</select>			
			<input id="ricerca" type="text" size="15" name="ricerca_contatto"/>
			<input type="submit" value="Cerca" />
		</form>
		</td></tr>
   	    </table>
   	    </div>
	</div>
	<div id="content">
		<div id="top">
			<div id="top_left">
			<ul>
				<li><a href="Contacts?p=1"><img src="template/home.jpg" alt="home" /></a></li>
				<li><a href="Contacts?p=2">
						<img src="template/add_contact.jpg" alt="add contact"/>
					</a>
				</li>
				<li><span id="benvenuto"><c:out value='${mgbenvenuto}'/></span>
				</li>
			</ul>		
			</div>
			<div id="top_right">
			<ul>
				<li><a href="Account"><img src="template/account.jpg" alt="setting account"/></a></li> 
				<!-- logged_user mi serve come variabile di sessione per vedere l'utente è logato -->
				<li><a href="Login"><img src="template/logout.jpg" alt="logout"/></a></li>
			</ul>
		</div>
		</div>
		<div id="left">
			<center><h2>Lista contatti</h2></center>
			<div id="lista">
			<c:choose>
			<c:when test="${lista == 'nessun contatto'}">
				<c:out value='${lista}'/>
			</c:when>
			<c:otherwise>
				<c:forEach	items="${lista}" var="elemento">
				 <a href="ViewContact?idcon=${elemento.id}">
				 	<c:out value='${elemento.surname}'/>&nbsp;<c:out value='${elemento.name}'/></a><br/>
				 </c:forEach>
			</c:otherwise>
			</c:choose>
			</div>
		</div>
		<div id="right">
		<c:choose>
		<c:when test="${link_clicked == 'add'}">
				<!-- Includo la pagina per aggingere un contatto -->
				<h2>Aggiungi un nuovo contatto</h2>
				<%@ include file="addContact.jsp" %>
		
		</c:when>
		<c:when test="${link_clicked == 'addOK'}">
				<!-- Includo la pagina per aggingere un contatto -->
				<h2>Dati contatto salvati con successo!</h2>	
				<c:out value="${msgok}"/>	
		</c:when>
		<c:when test="${link_clicked == 'account'}">
			<!-- Includo la pagina per aggingere un contatto -->
			<h2>Dati personali dell'account</h2>
			<%@ include file="account.jsp" %>
		</c:when>
		<c:when test="${link_clicked == 'view'}">
				<!-- Scheda contatto -->
				<%@ include file="viewContact.jsp" %>
		</c:when>
		<c:when test="${link_clicked == 'no' || link_clicked == null}">		
			<center>
			<h2>Visualizza la scheda dei tuoi contatti</h2>
			<img src="template/web_contact.png"/>
			</center>
		</c:when>
 		<c:otherwise>
		<center>
			<h2>Visualizza la scheda dei tuoi contatti!</h2>
			<img src="template/web_contact.png"/>
		</center>
		</c:otherwise> 
		</c:choose>
		<br/>  	
		</div>
	</div>
</div>
</body>
</html>