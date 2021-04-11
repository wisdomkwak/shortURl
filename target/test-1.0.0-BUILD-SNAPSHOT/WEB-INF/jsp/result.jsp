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
	location.replace('/index');
}

</script>
<body>

<h1>Result Page</h1>

<form action="/encoding" method="POST" name="shotUrlForm">
	<input id ="writeUrl" name="writeUrl" value="${writeUrl}" placeholder="변경 할 URL를 입력해주세요.">
	<button type="submit">encoding</button>
	<input id ="shortUrl" name="shortUrl" value ="${shortUrl}" readonly="readonly" placeholder="short_url">
	<input id ="longUrl" name="longUrl" value ="${longUrl}" readonly="readonly" placeholder="long_url">
	<button onclick="popup('${jsonInString3}')">move</button>
</form>

<button class="clearbut" onclick="goPage();">clear</button>

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
