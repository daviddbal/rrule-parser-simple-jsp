<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RRULE Parser - JSP servlet</title>
</head>
<body>
	<h1>RRULE Parser</h1>
	<form id="rruleform" action="RRuleServlet" method="post">
		<p>
			RRULE <input type="text" size="35" name="rruleContent" value="RRULE:FREQ=DAILY"><br>
			DTSTART <input type="text" size="35" name="dateTimeStart" value="DTSTART:20170101T120000"><br>
			Max Recurrences <input type="number" name="limit" min="1" max="1000" value="10"><br>
			<input type="submit">
		</p>	
	</form>
<p><span id='display'></span></p>
</body>
</html>