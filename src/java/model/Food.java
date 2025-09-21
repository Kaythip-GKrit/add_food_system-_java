
package model;


public class Food {


    public String getFoodName() {
        return foodName;
    }


    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodType() {
        return foodType;
    }


    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }


    public String[] getNutrient() {
        return nutrient;
    }


    public void setNutrient(String[] nutrient) {
        this.nutrient = nutrient;
    }


    public String getHotLevel() {
        return hotLevel;
    }


    public void setHotLevel(String hotLevel) {
        this.hotLevel = hotLevel;
    }


    public String getPrice() {
        return price;
    }


    public void setPrice(String price) {
        this.price = price;
    }
    
    public int  getId(){
        return id;
    }
    
    public void setId (int Id){
        this.id = Id;
        
    }
    
    public boolean getAllFood(){
        return allFood;
    }
    
    public void setAllFood(boolean AllFood){
        this.allFood = AllFood;
    }

    private String foodName;
    private String foodType;
    private String[] nutrient;
    private String hotLevel;
    private String price;
    private int id;
    private boolean allFood;
}
