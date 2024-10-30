package org.example.Food;

public class Food {
    private int id;
    private String foodType;

    public Food(String foodType) {
        this.foodType = foodType;
    }
    public Food(){
        //What doing?
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }
}
