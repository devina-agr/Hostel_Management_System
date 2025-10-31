package org.spring.hostel_management_system.Model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Document(collection = "Menu")
public class Menu {

    private String id;
    private HostelType hostelType;
    private Map<String, Map<MealType, List<String>>> meals;

    public Map<String, Map<MealType, List<String>>> getMeals() {
        return meals;
    }

    public void setMeals(Map<String, Map<MealType, List<String>>> meals) {
        this.meals = meals;
    }

    public HostelType getHostelType() {
        return hostelType;
    }

    public void setHostelType(HostelType hostelType) {
        this.hostelType = hostelType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public enum MealType{
        BREAKFAST,
        LUNCH,
        SNACKS,
        DINNER
    }





}
