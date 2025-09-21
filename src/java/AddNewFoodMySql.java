
import controller.DBConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.Food;
//import java.net.Authenticator;

@WebServlet("/AddNewFoodMySql")
public class AddNewFoodMySql extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(">>> TEST: servlet โดนเรียกใช้งานแล้ว <<<");
//         response.setContentType("text/html;charset-UTF-8");
//        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("idUpdate");
        String foodName = request.getParameter("foodName");
        String foodType = request.getParameter("foodType");
        String[] nutrient = request.getParameterValues("nutrient");
        String hotLevel = request.getParameter("hotLevel");
        String price = request.getParameter("foodPrice");
        String showAllFood = request.getParameter("showAllFood");

        Food food = new Food();

        food.setFoodName(foodName);
        food.setFoodType(foodType);
        food.setNutrient(nutrient);
        food.setHotLevel(hotLevel);
        food.setPrice(price);

        DBConnector dbconnection = new DBConnector(); // เรียกฟังก์ชันให้ทำการเก็บข้อมูล
        if ("SAF".equals(showAllFood)) {
            String allFood = dbconnection.showAll();  // ดึงข้อมูล
            request.setAttribute("allFoodData", allFood); // ส่งไปหน้า JSP
            request.getRequestDispatcher("/showAllFood.jsp").forward(request, response);
            return;  
        }

        if (id != null && !id.isEmpty()) {
            // กรณีนี้คือมี id → แก้ไขข้อมูล
            int idINT = Integer.parseInt(id);
            food.setId(idINT);
            System.out.println(">>> UPDATE MODE: id=" + idINT);
            dbconnection.editFood(food);

        } else {
            if (!dbconnection.insertNewFood(food)) {// เรียก method insertNewFood() จาก DBConnection.java
                System.out.println(">>> AddNewFoodMySql ERROR");
            }
        }

        HttpSession session = request.getSession();
        session.setAttribute("toJspp", food);
        request.getRequestDispatcher("/addNewFoodSuccess.jsp").forward(request, response);

    }

}
