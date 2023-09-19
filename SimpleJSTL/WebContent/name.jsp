<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/mytaglib.tld" prefix="pstl" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Custom Tag Example</title>
    <script>
        function submitForm() {
            var from = document.getElementById("dropdown_trn_start").value;
            var to = document.getElementById("dropdown_trn_end").value;


            document.getElementById("column1").value = from;
            document.getElementById("column2").value = to;

            document.getElementById("trainsForm").submit();
        }
    </script>
</head>
<body>
    <h1>Custom JSP Tag Example</h1>
    <form id="trainsForm" action="TrainsServlet" method="post">
        FROM:
        <pstl:drop id="trn_start" tableName="mystations" column="trn_start"/>
        TO:
        <pstl:drop id="trn_end" tableName="mystations" column="trn_end"/>
        <input type="hidden" id="column1" name="column1" />
        <input type="hidden" id="column2" name="column2" />
        <button type="button" onclick="submitForm()">Search</button>
    </form>

    Trains:
    <pstl:train column1="${column1}" column2="${column2}" />
</body>
</html>
