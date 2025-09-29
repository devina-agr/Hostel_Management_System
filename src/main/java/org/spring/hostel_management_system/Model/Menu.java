package org.spring.hostel_management_system.Model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "Menu")
public class Menu {

    private String id;
    private String day;
    private MealType mealType;

    public Menu(String id, String day, MealType mealType) {
        this.id = id;
        this.day = day;
        this.mealType = mealType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public enum MealType{
        BREAKFAST,
        LUNCH,
        SNACKS,
        DINNER
    }





}
