<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
	<script type="text/javascript">
	
		function send(){
			
			var f = document.form;
			
			var inData = f.inData.value;
			var setType1 = f.setType1.value;
			var setType2 = f.setType2.value;
			
			//alert(inData+"//"+setType1+"//"+setType2);
			
			f.submit();
			
		}
	
	</script>
</head>
<body>
<form name="form" action="<c:url value='/excutConverter.do' />" method="POST">
<table>
<tr>
	<td><input type="text" name="inData" value="<c:out value='${ inData }' />" /></td>
	<td>
		<select name="setType1">
			<option value="1" <c:if test="${ setType1 == '1' }">selected</c:if> >BIT</option>
			<option value="2" <c:if test="${setType1 == '2' }">selected</c:if> >BYTE</option>
			<option value="3" <c:if test="${setType1 == '3' }">selected</c:if> >KB</option>
			<option value="4" <c:if test="${setType1 == '4' }">selected</c:if> >MB</option>
			<option value="5" <c:if test="${setType1 == '5' }">selected</c:if> >GB</option>
			<option value="6" <c:if test="${setType1 == '6' }">selected</c:if> >TB</option>
		</select>
	</td>
	<td><input type="text" name="outData" value="<c:out value='${ outData }' />"/></td>
	<td>
		<select name="setType2">
			<option value="1" <c:if test="${setType2 == '1' }">selected</c:if> >BIT</option>
			<option value="2" <c:if test="${setType2 == '2' }">selected</c:if> >BYTE</option>
			<option value="3" <c:if test="${setType2 == '3' }">selected</c:if> >KB</option>
			<option value="4" <c:if test="${setType2 == '4' }">selected</c:if> >MB</option>
			<option value="5" <c:if test="${setType2 == '5' }">selected</c:if> >GB</option>
			<option value="6" <c:if test="${setType2 == '6' }">selected</c:if> >TB</option>
		</select> 
	</td>
	<td><input type="button" name="bnt" value="실행" onClick="send();" /></td>
</tr>
</table>
</form>
</body>
</html>
