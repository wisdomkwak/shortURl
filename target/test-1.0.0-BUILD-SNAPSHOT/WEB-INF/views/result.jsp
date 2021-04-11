<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>Result Page</title>
</head>
<link href="./resources/css/shortUrl.css" rel="stylesheet" type="text/css" />
<!-- jQuery  -->
<script src="./resources/js/jquery.min.js"></script>

<script>
function popup(url) {
	window.open("http://"+ url, "", "width=400, height=300, left=100, location=1");
}

function goPage() { 
	location.replace('/test');
}

</script>
<body>

<h1>Result Page</h1>

<form action="/encoding" method="POST" name="shotUrlForm">
	<input id ="url_id" name="url_id" value="${jsonInString}">
	<button type="submit">encoding</button>
	<input id ="url_id2" name="url_id2" value ="${jsonInString2}" readonly="readonly">
	<input id ="url_id3" name="url_id3" value ="${jsonInString3}" readonly="readonly">
	<button onclick="popup('${jsonInString3}')">move</button>
</form>

<button onclick="goPage();" style="width: 900px">clear</button>

<table>
	<thead>
		<tr>
			<th>Id</th>
			<th>LongUrl</th>
			<th>Cnt</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="ul" items="${urlList}" varStatus="status">
			<tr>
				<td>${ul.id}</td>
				<td>${ul.longurl}</td>
				<td>${ul.cnt}</td>
			</tr>
		</c:forEach>
	</tbody>	
</table>

</body>
</html>
