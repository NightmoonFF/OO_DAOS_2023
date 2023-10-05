package Application;

import java.util.ArrayList;

public class Validation {

    public static boolean intValidation(String s){

        try {
            int i = Integer.parseInt(s);
            if (i < 0) {
                // Error, negative input
                return false;
            }
            return true;

        } catch (NumberFormatException e) {
            // Error, not a number.
            return false;
        }
    }

    public static <T>  boolean nullValidation(T input, String valueName){
        if (input == null) { Utility.errorAlert(valueName + " er ikke udfyldt"); return false;}

        else {
            System.out.println("Debug Log: " + input.toString() + " validated successfully as not null");;
        }   return true;
    }
    public static <T>  boolean nullValidation(ArrayList<T> input, String valueName){

        for(int i = 0; i < input.size(); i++){
            if(input.get(i) == null) { Utility.errorAlert(valueName + " er ikke udfyldt"); return false;}
        }
        return true;
    }
}
