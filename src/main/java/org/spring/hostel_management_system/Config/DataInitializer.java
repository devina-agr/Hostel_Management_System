package org.spring.hostel_management_system.Config;

import org.spring.hostel_management_system.Model.HostelType;
import org.spring.hostel_management_system.Model.Menu;
import org.spring.hostel_management_system.Repository.MenuRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataInitializer implements CommandLineRunner {


    private final MenuRepo menuRepo;

    public DataInitializer(MenuRepo menuRepo) {
        this.menuRepo = menuRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        if(menuRepo.count()==0){
            Menu menuForBoys=new Menu();
            menuForBoys.setHostelType(HostelType.BOYS_HOSTEL);
            Map<String, Map<Menu.MealType, List<String>>> boysMeals=new HashMap<>();
            Map<Menu.MealType, List<String>> boysMondayMeal=new HashMap<>();
            boysMondayMeal.put(Menu.MealType.BREAKFAST,Arrays.asList("Bread", "Butter","Cornflakes","Milk","Tea","Fruits"));
            boysMondayMeal.put(Menu.MealType.LUNCH,Arrays.asList("Rajma", "Rice","Chapati","French Beans","Curd","Salad","Lemon"));
            boysMondayMeal.put(Menu.MealType.SNACKS,Arrays.asList("Bread Pakoda", "Tomamto Sauce","Green Chutney","Tea"));
            boysMondayMeal.put(Menu.MealType.DINNER,Arrays.asList("Aloo Tamatar", "Bhindi","Plain Parantha","Rice","Gulab Jamun","Plain Chhach"));
            boysMeals.put("MONDAY", boysMondayMeal);
            Map<Menu.MealType, List<String>> boysTuesdayMeal=new HashMap<>();
            boysTuesdayMeal.put(Menu.MealType.BREAKFAST,Arrays.asList("Matra", "Cucumber","Onion","Kulcha","Tea","Milk","Fruits"));
            boysTuesdayMeal.put(Menu.MealType.LUNCH,Arrays.asList("Arhar Daal", "Rice","Mix Veg","Boondi Raita","Chapati","Salad","Lemon"));
            boysTuesdayMeal.put(Menu.MealType.SNACKS,Arrays.asList("Chowmein", "Tomamto Sauce","Tang"));
            boysTuesdayMeal.put(Menu.MealType.DINNER,Arrays.asList("Aloo Soyabean", "Veg Pulao","Chapati","Green Chutney","Shahi Toast","Masala Chhach"));
            boysMeals.put("TUESDAY", boysTuesdayMeal);
            Map<Menu.MealType, List<String>> boysWednesdayMeal=new HashMap<>();
            boysWednesdayMeal.put(Menu.MealType.BREAKFAST,Arrays.asList("Fried Idly", "Sambhar","Nariyal Chutney","Milk","Tea","Fruits"));
            boysWednesdayMeal.put(Menu.MealType.LUNCH,Arrays.asList("Kadhi", "Rice","Chapati","Aloo Jeera","Papad","Salad","Lemon","Fried Mirchi"));
            boysWednesdayMeal.put(Menu.MealType.SNACKS,Arrays.asList("Poha", "Tomamto Sauce","Green Chutney","Tea"));
            boysWednesdayMeal.put(Menu.MealType.DINNER,Arrays.asList("Lauki Chana Dal", "Arbi","Chapati","Rice","Fruit Custard"));
            boysMeals.put("WEDNESDAY", boysWednesdayMeal);
            Map<Menu.MealType, List<String>> boysThursdayMeal=new HashMap<>();
            boysThursdayMeal.put(Menu.MealType.BREAKFAST,Arrays.asList("Plain Parantha", "Aloo Jeera Dry","Milk","Tea","Fruits"));
            boysThursdayMeal.put(Menu.MealType.LUNCH,Arrays.asList("Rajma", "Rice","Chapati","Aloo Jeera","Curd","Salad","Lemon"));
            boysThursdayMeal.put(Menu.MealType.SNACKS,Arrays.asList("Black Chana Chaat", "Coffee"));
            boysThursdayMeal.put(Menu.MealType.DINNER,Arrays.asList("Sabut Lal Masoor Daal", "Kathal","Chapati","Rice","Ice Cream","Plain Chhach"));
            boysMeals.put("THURSDAY", boysThursdayMeal);
            Map<Menu.MealType, List<String>> boysFridayMeal=new HashMap<>();
            boysFridayMeal.put(Menu.MealType.BREAKFAST,Arrays.asList("Aloo Paratha", "Green Chutney","Pickle","Milk","Tea","Fruits"));
            boysFridayMeal.put(Menu.MealType.LUNCH,Arrays.asList("Arhar Daal", "Rice","Chapati","Baingan","Boondi Raita","Salad","Lemon"));
            boysFridayMeal.put(Menu.MealType.SNACKS,Arrays.asList("Macroni", "Tomamto Sauce","Shikanji"));
            boysFridayMeal.put(Menu.MealType.DINNER,Arrays.asList("Chhole", "Bhature","Rice","Cold Drink","Masala Onion","Fried Mirch"));
            boysMeals.put("FRIDAY", boysFridayMeal);
            Map<Menu.MealType, List<String>> boysSaturdayMeal=new HashMap<>();
            boysSaturdayMeal.put(Menu.MealType.BREAKFAST,Arrays.asList("Pav","Bhaji","Butter","Milk","Tea","Fruits"));
            boysSaturdayMeal.put(Menu.MealType.LUNCH,Arrays.asList("Black Chana", "Rice","Lauki Kofta","Chapati","Veg Raita","Salad","Lemon"));
            boysSaturdayMeal.put(Menu.MealType.SNACKS,Arrays.asList("Samosa", "Green Chutney","Saunth","Tea"));
            boysSaturdayMeal.put(Menu.MealType.DINNER,Arrays.asList("Daal Makhani", "Aloo Shimla","Chapati","Rice","Kheer","Mirch"));
            boysMeals.put("SATURDAY", boysSaturdayMeal);
            Map<Menu.MealType, List<String>> boysSundayMeal=new HashMap<>();
            boysSundayMeal.put(Menu.MealType.BREAKFAST,Arrays.asList("Aloo Tomato Sabji", "Poori","Pickle","Milk","Tea","Fruits"));
            boysSundayMeal.put(Menu.MealType.LUNCH,Arrays.asList("Chhole","Chapati", "Rice","Aloo Pyaaz","Boondi Raita","Salad","Lemon"));
            boysSundayMeal.put(Menu.MealType.SNACKS,Arrays.asList("OFF"));
            boysSundayMeal.put(Menu.MealType.DINNER,Arrays.asList("Matar Paneer", "Aloo Chokha","Chapati","Rice","Jalebi","Masala Chhach"));
            boysMeals.put("SUNDAY", boysSundayMeal);

            menuForBoys.setMeals(boysMeals);

            Menu menuForGirls=new Menu();
            menuForGirls.setHostelType(HostelType.GIRLS_HOSTEL);
            Map<String, Map<Menu.MealType, List<String>>> girlsMeals=new HashMap<>();
            Map<Menu.MealType, List<String>> girlsMondayMeal=new HashMap<>();
            girlsMondayMeal.put(Menu.MealType.BREAKFAST,Arrays.asList("Matra", "Cucumber","Onion","Kulcha","Tea","Milk","Fruits"));
            girlsMondayMeal.put(Menu.MealType.LUNCH,Arrays.asList("Arhar Daal", "Rice","Mix Veg","Boondi Raita","Chapati","Salad","Lemon"));
            girlsMondayMeal.put(Menu.MealType.SNACKS,Arrays.asList("Bread Pakoda", "Tomamto Sauce","Green Chutney","Tea"));
            girlsMondayMeal.put(Menu.MealType.DINNER,Arrays.asList("Matar Paneer", "Aloo Chokha","Chapati","Rice","Jalebi","Masala Chhach"));
            girlsMeals.put("MONDAY", girlsMondayMeal);
            Map<Menu.MealType, List<String>> girlsTuesdayMeal=new HashMap<>();
            girlsTuesdayMeal.put(Menu.MealType.BREAKFAST,Arrays.asList("Fried Idly", "Sambhar","Nariyal Chutney","Milk","Tea","Fruits"));
            girlsTuesdayMeal.put(Menu.MealType.LUNCH,Arrays.asList("Rajma", "Rice","Chapati","French Beans","Curd","Salad","Lemon"));
            girlsTuesdayMeal.put(Menu.MealType.SNACKS,Arrays.asList("Chowmein", "Tomamto Sauce","Tang"));
            girlsTuesdayMeal.put(Menu.MealType.DINNER,Arrays.asList("Aloo Tamatar", "Bhindi","Plain Parantha","Rice","Gulab Jamun","Plain Chhach"));
            girlsMeals.put("TUESDAY", girlsTuesdayMeal);
            Map<Menu.MealType, List<String>> girlsWednesdayMeal=new HashMap<>();
            girlsWednesdayMeal.put(Menu.MealType.BREAKFAST,Arrays.asList("Bread", "Butter","Cornflakes","Milk","Tea","Fruits"));
            girlsWednesdayMeal.put(Menu.MealType.LUNCH,Arrays.asList("Kadhi", "Rice","Chapati","Aloo Jeera","Papad","Salad","Lemon","Fried Mirchi"));
            girlsWednesdayMeal.put(Menu.MealType.SNACKS,Arrays.asList("Poha", "Tomamto Sauce","Green Chutney","Tea"));
            girlsWednesdayMeal.put(Menu.MealType.DINNER,Arrays.asList("Aloo Soyabean", "Veg Pulao","Chapati","Green Chutney","Shahi Toast","Masala Chhach"));
            girlsMeals.put("WEDNESDAY", girlsWednesdayMeal);
            Map<Menu.MealType, List<String>> girlsThursdayMeal=new HashMap<>();
            girlsThursdayMeal.put(Menu.MealType.BREAKFAST,Arrays.asList("Plain Parantha", "Aloo Jeera Dry","Milk","Tea","Fruits"));
            girlsThursdayMeal.put(Menu.MealType.LUNCH,Arrays.asList("Rajma", "Rice","Chapati","Aloo Jeera","Curd","Salad","Lemon"));
            girlsThursdayMeal.put(Menu.MealType.SNACKS,Arrays.asList("Black Chana Chaat", "Coffee"));
            girlsThursdayMeal.put(Menu.MealType.DINNER,Arrays.asList("Chhole", "Bhature","Rice","Cold Drink","Masala Onion","Fried Mirch"));
            girlsMeals.put("THURSDAY", girlsThursdayMeal);
            Map<Menu.MealType, List<String>> girlsFridayMeal=new HashMap<>();
            girlsFridayMeal.put(Menu.MealType.BREAKFAST,Arrays.asList("Pav","Bhaji","Butter","Milk","Tea","Fruits"));
            girlsFridayMeal.put(Menu.MealType.LUNCH,Arrays.asList("Arhar Daal", "Rice","Chapati","Baingan","Boondi Raita","Salad","Lemon"));
            girlsFridayMeal.put(Menu.MealType.SNACKS,Arrays.asList("Macroni", "Tomamto Sauce","Shikanji"));
            girlsFridayMeal.put(Menu.MealType.DINNER,Arrays.asList("Sabut Lal Masoor Daal", "Kathal","Chapati","Rice","Ice Cream","Plain Chhach"));
            girlsMeals.put("FRIDAY", girlsFridayMeal);
            Map<Menu.MealType, List<String>> girlsSaturdayMeal=new HashMap<>();
            girlsSaturdayMeal.put(Menu.MealType.BREAKFAST,Arrays.asList("Aloo Paratha", "Green Chutney","Pickle","Milk","Tea","Fruits"));
            girlsSaturdayMeal.put(Menu.MealType.LUNCH,Arrays.asList("Black Chana", "Rice","Lauki Kofta","Chapati","Veg Raita","Salad","Lemon"));
            girlsSaturdayMeal.put(Menu.MealType.SNACKS,Arrays.asList("Samosa", "Green Chutney","Saunth","Tea"));
            girlsSaturdayMeal.put(Menu.MealType.DINNER,Arrays.asList("Daal Makhani", "Aloo Shimla","Chapati","Rice","Kheer","Mirch"));
            girlsMeals.put("SATURDAY", girlsSaturdayMeal);
            Map<Menu.MealType, List<String>> girlsSundayMeal=new HashMap<>();
            girlsSundayMeal.put(Menu.MealType.BREAKFAST,Arrays.asList("Aloo Tomato Sabji", "Poori","Pickle","Milk","Tea","Fruits"));
            girlsSundayMeal.put(Menu.MealType.LUNCH,Arrays.asList("Chhole","Chapati", "Rice","Aloo Pyaaz","Boondi Raita","Salad","Lemon"));
            girlsSundayMeal.put(Menu.MealType.SNACKS,Arrays.asList("OFF"));
            girlsSundayMeal.put(Menu.MealType.DINNER,Arrays.asList("Lauki Chana Dal", "Arbi","Chapati","Rice","Fruit Custard"));
            girlsMeals.put("SUNDAY", girlsSundayMeal);

            menuForGirls.setMeals(girlsMeals);


            menuRepo.save(menuForBoys);
            menuRepo.save(menuForGirls);
        }
    }
}
