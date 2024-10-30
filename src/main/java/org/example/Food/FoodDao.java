package org.example.Food;

public interface FoodDao {
    void readFood(String no) throws Exception;
    void readAllFoods() throws Exception;
    void createFood(Food food) throws Exception;
}
