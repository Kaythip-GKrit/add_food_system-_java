
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.DBConnector"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ข้อมูลอาหารทั้งหมด</title>
    </head>
    <body>
        <h1>อาหารทั้งหมด</h1>
        <%DBConnector dbc = new DBConnector(); %>
        <%=request.getAttribute("allFoodData")%>
    </body>
</html>
