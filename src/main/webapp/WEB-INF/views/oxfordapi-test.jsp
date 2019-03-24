<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>

<body>

<div class = "fearstats">
	<p>Currently, we have your fear registered as ${userFear.getShortFear()}. Don't worry; you and your partner will overcome this fear together!</p>
	<p>The medical term for this fear is: ${userFear.getLongFear() }</p>
	<p>It is defined as: ${word}</p>
	<p><a href = "${userFear.getWebMDLink()}">Here</a> you can access more information</p>
</div>
</body>
</html>