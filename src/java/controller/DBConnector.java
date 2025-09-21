package controller;

import java.sql.*;
import model.Food;

public class DBConnector {

    public boolean insertNewFood(Food food) {
        boolean result = false;
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/srikai?useUnicode=true&characterEncoding=UTF-8",
                    "root", "1234"
            );

            //คำสั่งใช้ insert ข้อมูล 
            Statement statement;
            statement = connection.createStatement();

            String nutrient = "";
            int n1 = food.getNutrient().length;
            for (int i = 0; i < n1 - 1; i++) {
                nutrient += food.getNutrient()[i] + ";";
            }
            nutrient += food.getNutrient()[n1 - 1]; //index สุดท้าย
            String query = "INSERT INTO food3 (name, type, nutrient, hotLevel, price) VALUES("
                    + "'" + food.getFoodName() + "',"
                    + "'" + food.getFoodType() + "',"
                    + "'" + nutrient + "',"
                    + "'" + food.getHotLevel() + "',"
                    + "'" + food.getPrice() + "'"
                    + ")";
            System.out.println("....TEST.....SQL: " + query);
            int i = statement.executeUpdate(query); //execute ทำให้คำสั่ง INSERT ทำงาน
            if (i != 0) {
                result = true;
            }
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getLatestFoodId() {
        int maxId = 0;
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/srikai?useUnicode=true&characterEncoding=UTF-8",
                    "root", "1234"
            );

            Statement statement = connection.createStatement();
            String query = "SELECT MAX(id) AS max_id FROM food3";
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                maxId = rs.getInt("max_id");
            }

            rs.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return maxId;
    }

    public boolean editFood(Food food) {
        boolean result = false;
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/srikai?useUnicode=true&characterEncoding=UTF-8",
                    "root", "1234"
            );
            //คำสั่งใช้ Edit ข้อมูล 
            Statement statement;
            statement = connection.createStatement();

            String nutrient = "";
            int n1 = food.getNutrient().length;
            for (int i = 0; i < n1 - 1; i++) {
                nutrient += food.getNutrient()[i] + ";";
            }
            nutrient += food.getNutrient()[n1 - 1];

            String query = "UPDATE food3 SET "
                    + "name = '" + food.getFoodName() + "', "
                    + "type = '" + food.getFoodType() + "', "
                    + "nutrient = '" + nutrient + "', "
                    + "hotLevel = '" + food.getHotLevel() + "', "
                    + "price = '" + food.getPrice() + "'"
                    + " WHERE id = " + getLatestFoodId();

            System.out.println("....EDIT SQL: " + query);

            int i = statement.executeUpdate(query);
            if (i > 0) {
                result = true;
            }

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String showAll() {
        String allFood = "";
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/srikai?useUnicode=true&characterEncoding=UTF-8",
                    "root", "1234"
            );
            //คำสั่งใช้ Edit ข้อมูล 
            Statement statement;
            statement = connection.createStatement();

            String query = "SELECT name,price,type,nutrient,hotLevel FROM food3";

            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
            String name = rs.getString("name");
            String price = rs.getString("price");
            String type = rs.getString("type");
            String nutrient = rs.getString("nutrient");
            String hotLevel = rs.getString("hotLevel");

            allFood += "ชื่อ: " + name
                     + ", ราคา: " + price
                     + ", ประเภท: " + type
                     + ", สารอาหาร: " + nutrient
                     + ", ระดับความเผ็ด: " + hotLevel + "<br>";
        }
            
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return allFood;
    }
}
