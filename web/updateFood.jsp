

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Food"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%Food food = (Food) session.getAttribute("toJspp");%>
        <h2>แก้ไขข้อมูล</h2>
        <form action="AddNewFoodMySql" method="post">
            <%--<%=food.getId()%>--%>
            <input type="hidden" name="idUpdate" value="<%=food.getId()%>">
            <%System.out.println("MMMMMMMMMMM : "+food.getId());%>
            ชื่อ:<input type ="text" name="foodName" value="<%=food.getFoodName()%>"><br/>
            ประเภท: 
            <select name="foodType">
                <option value="ต้ม" <%= food.getFoodType().equals("ต้ม") ? "selected" : ""%> >ต้ม</option>
                <option value="ผัด" <%= food.getFoodType().equals("ผัด") ? "selected" : ""%>>ผัด</option>
                <option value="แกง" <%= food.getFoodType().equals("แกง") ? "selected" : ""%>>แกง</option>
                <option value="ทอด" <%=food.getFoodType().equals("ทอด") ? "selected" : ""%>>ทอด</option>
                <option value="ยำ" <%=food.getFoodType().equals("ยำ") ? "selected" : ""%>>ยำ</option>
            </select><br/>

            <% String hasProtein = "";%>
            <% String hasFat = "";%>
            <% String hasVitamin = "";%>
            <% String hasCarbo = "";%>

            <%for (String n : food.getNutrient()) {
                    if (n.equals("โปรตีน")) {
                        hasProtein = "โปรตีน";
                    }
                    if (n.equals("ไขมัน")) {
                        hasFat = "ไขมัน";
                    }
                    if (n.equals("วิตามิน")) {
                        hasVitamin = "วิตามิน";
                    }
                    if (n.equals("คาร์โบไฮเดรต")) {
                        hasCarbo = "คาร์โบไฮเดรต";
            }
        }%>
            สารอาหาร:
            <input type="checkbox" name="nutrient" value="โปรตีน" <%=hasProtein.equals("โปรตีน") ? "checked" : ""%>>โปรตีน
            <input type="checkbox" name="nutrient" value="ไขมัน" <%=hasFat.equals("ไขมัน") ? "checked" : ""%>> ไขมัน<br/>
            <input type="checkbox" name="nutrient" value="วิตามิน" <%=hasVitamin.equals("วิตามิน") ? "checked" : ""%>>วิตามิน<br/>
            <input type="checkbox" name="nutrient" value="คาร์โบไฮเดรต" <%=hasCarbo.equals("คาร์โบไฮเดรต") ? "checked" : ""%>>คาร์โบไฮเดรต<br/>

            รสเผ็ด:<br/>
            <input type="radio" name="hotLevel" value="ไม่เผ็ด" <%=food.getHotLevel().equals("ไม่เผ็ด") ? "checked" : ""%>>ไม่เผ็ด<br/>
            <input type="radio" name="hotLevel" value="เผ็ดน้อย"<%=food.getHotLevel().equals("เผ็ดน้อย") ? "checked" : ""%>>เผ็ดน้อย<br/>
            <input type="radio" name="hotLevel" value="เผ็ดมาก"<%=food.getHotLevel().equals("เผ็ดมาก") ? "checked" : ""%> >เผ็ดมาก<br/>

            ราคา: <input type="text" name="foodPrice" value="<%= food.getPrice()%>"><br/>
          
            <input type="submit" value="บันทึกข้อมูล">
        </form>
    </body>
</html>
