<%@ page language="java" contentType="text/html; charset=ISO-8859-1; application/json"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1; application/json">
<title>Data From CoWorkr API</title>
</head>
<body>
<div class = "CoWorkrData">
<h4>Here's what my GET Requests to the CoWorkr API would look like with authorization: </h4>
<p>CoWorkr WorkPoints Data</p>
<p>${workpoints}</p>
</div>
<div class = "iOfficeData">
<h4>Here's what my POST Requests to the iOffice API would look like with authorization: </h4>
<p>iOffice Sensor Data: </p>
<p>${sensors}</p>
</div>
</body>
</html>
