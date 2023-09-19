<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/mytaglib.tld" prefix="pstl" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Custom Tag Example</title>
</head>
<body>
    <h1>Custom JSP Tag Example</h1>
	FROM:
   <pstl:drop  id="trn_start" tableName="mystations" column="trn_start"/>
    TO:
	<pstl:drop  id="trn_end" tableName="mystations" column="trn_end"/>
   
	<button id="btn" onclick="doo()">Search</button><BR>
   
    Trains:
	<pstl:train column1="<%= request.getParameter("from") %>" column2="<%= request.getParameter("to") %>" />
	
    <script>
        function doo() {
            var from = document.getElementById("trn_start").value;
            var to = document.getElementById("trn_end").value;
            console.log(from + to);
            // You can remove the JavaScript code to set attributes here
        }
    </script>
</body>
</html>
