package Application;

import java.util.ArrayList;

/**
 * The idea is that you call these with:  if (!someValidationType) { return; },
 * before you execute something that may return an exception. Imo is a little cleaner,
 * since you can hide away the bloat *shrugs*
 */
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
}
