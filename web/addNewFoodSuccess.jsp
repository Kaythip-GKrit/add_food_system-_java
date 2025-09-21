
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Food" %>

<html lang="th">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>addNewFoodSuccess</title>
    </head>
    <body>
        <h1>เพิ่มอาหารสำเร็จ</h1>
        <%  Food newFood = (Food) session.getAttribute("toJspp");%>
        <p>ชื่ออาหาร: <%=newFood.getFoodName()%></p>
        <p>ประเภทอาหาร: <%=newFood.getFoodType()%></p>
        <%if (newFood.getNutrient().length > 3) {%>
        <%
            for (int n = 0; n < newFood.getNutrient().length - 1; n++) {
        %>
        <label><%=newFood.getNutrient()[n]%>;</label>
        <%
            }
        %>
        <label><%=newFood.getNutrient()[3]%></label>
        <%}%>
        <p>ระดับความเผ็ด: <%=newFood.getHotLevel()%></p>
        <p>ราคา : <%=newFood.getPrice()%></p>
        <label><a href="updateFood.jsp">แก้ไขข้อมูล</a></label>
        </br>
        <form action="AddNewFoodMySql" method="post">
            <input type="hidden" name="showAllFood" value="SAF" />
            <input type="submit" value="ดูข้อมูลอาหารทั้งหมด" />
        </form>
    </body>
</html>
