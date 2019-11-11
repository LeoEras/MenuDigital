package com.example.menudigital;

import java.util.List;

public class Utils {
    public static String[] sex_choice = {"Masculino", "Femenino"};
    public static String[] prev_age_choice = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
            "15", "16", "17", "18", "19-20", "21-25", "26-30", "31-35", "36-40", "41-45", "46-50",
            "51-55", "56-60", "61-65", "66-70", "71-75", "76+"};
    public static String[] age_choice = {"5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
            "15", "16", "17", "18"};
    public static String[] act_choice = {"Sedentario", "Moderadamente Activo", "Activo"};
    public static String[] act_choice_small = {"Sed.", "Mod. Act.", "Act."};

    public static String[] food_names = {"Empanada de queso", "Empanada de pollo", "Tortilla de verde con queso",
            "Papa con carne", "Arepas de pollo", "Tortilla de choclo con queso", "Sánduche de atún",
            "Sánduche de pollo", "Submarino de jamón con queso y vegetales", "Tostada de queso", "Tostada mixta",
            "Bolón con queso", "Bolón de maduro", "Hamburguesa", "Choclo con queso cocinado", "Pizza con jamón y queso",
            "Canguil", "Gelatina", "Ensalada de fruta"};

    public static Integer[] cal = {322, 247, 252, 159, 160, 252, 247, 168, 280, 223, 140, 211, 160, 129,
            104, 174, 79, 201, 43};

    public static Integer[] images = {R.drawable.empanadas, R.drawable.empanadas, R.drawable.tortillaverde,
            R.drawable.papacarne, R.drawable.arepa, R.drawable.tortillachoclo, R.drawable.sandatun,
            R.drawable.sandpollo, R.drawable.subma, R.drawable.tosqueso, R.drawable.tosmixta,
            R.drawable.bolonqueso, R.drawable.bolonmad, R.drawable.hamb, R.drawable.choclo,
            R.drawable.pizza, R.drawable.cang, R.drawable.gelatina, R.drawable.ensfrut};

    public static Integer[] cant = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0};

    public static int calculoAlimentos(List<Integer> cant) {
        int cal_total = 0;
        int start;
        int len = cant.size();
        for(start = 0; start < len; start++){
            if(cant.get(start) != 0){
                cal_total = cant.get(start) * cal[start] + cal_total;
            }
        }
        return cal_total;
    }

    public static int calculoTotal(String sex, String edad, String act) {
        int result = 0;
        if("Masculino".equals(sex)){
            if("Sed.".equals(act)){
                switch(edad){
                    case "5":
                        result = 1200;
                        break;
                    case "6":
                    case "7":
                    case "8":
                        result = 1400;
                        break;
                    case "9":
                    case "10":
                        result = 1600;
                        break;
                    case "11":
                    case "12":
                        result = 1800;
                        break;
                    case "13":
                    case "14":
                        result = 2000;
                        break;
                    case "15":
                        result = 2200;
                        break;
                    case "16":
                    case "17":
                    case "18":
                        result = 2400;
                        break;
                    default:
                        break;
                }
            } else if ("Mod. Act.".equals(act)){
                switch(edad){
                    case "5":
                        result = 1400;
                        break;
                    case "6":
                    case "7":
                    case "8":
                        result = 1600;
                        break;
                    case "9":
                    case "10":
                        result = 1800;
                        break;
                    case "11":
                        result = 2000;
                        break;
                    case "12":
                    case "13":
                        result = 2200;
                        break;
                    case "14":
                        result = 2400;
                        break;
                    case "15":
                        result = 2600;
                        break;
                    case "16":
                    case "17":
                    case "18":
                        result = 2800;
                        break;
                    default:
                        break;
                }
            } else if("Act.".equals(act)){
                switch(edad){
                    case "5":
                        result = 1600;
                        break;
                    case "6":
                    case "7":
                        result = 1800;
                        break;
                    case "8":
                    case "9":
                        result = 2000;
                        break;
                    case "10":
                    case "11":
                        result = 2200;
                        break;
                    case "12":
                        result = 2400;
                        break;
                    case "13":
                        result = 2600;
                        break;
                    case "14":
                        result = 2800;
                        break;
                    case "15":
                        result = 3000;
                        break;
                    case "16":
                    case "17":
                    case "18":
                        result = 3200;
                        break;
                    default:
                        break;
                }
            }
        } else {
            if("Sed.".equals(act)){
                switch(edad){
                    case "5":
                    case "6":
                    case "7":
                        result = 1200;
                        break;
                    case "8":
                    case "9":
                    case "10":
                        result = 1400;
                        break;
                    case "11":
                    case "12":
                    case "13":
                        result = 1600;
                        break;
                    case "14":
                    case "15":
                    case "16":
                    case "17":
                    case "18":
                        result = 1800;
                        break;
                    default:
                        break;
                }
            } else if ("Mod. Act.".equals(act)){
                switch(edad){
                    case "5":
                    case "6":
                        result = 1400;
                        break;
                    case "7":
                    case "8":
                    case "9":
                        result = 1600;
                        break;
                    case "10":
                    case "11":
                        result = 1800;
                        break;
                    case "12":
                    case "13":
                    case "14":
                    case "15":
                    case "16":
                    case "17":
                    case "18":
                        result = 2000;
                        break;
                    default:
                        break;
                }
            } else if("Act.".equals(act)){
                switch(edad){
                    case "5":
                    case "6":
                        result = 1600;
                        break;
                    case "7":
                    case "8":
                    case "9":
                        result = 1800;
                        break;
                    case "10":
                    case "11":
                        result = 2000;
                        break;
                    case "12":
                    case "13":
                        result = 2200;
                        break;
                    case "14":
                    case "15":
                    case "16":
                    case "17":
                    case "18":
                        result = 2400;
                        break;
                    default:
                        break;
                }
            }
        }
        return result;
    }
}
