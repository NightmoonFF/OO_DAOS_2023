package Application;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Random;

public abstract class Utility {

    public static void errorAlert(String alertMsg){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(getAngryEmoji());
        alert.setContentText(alertMsg);
        alert.showAndWait();
    }

    public static void successAlert(String alertMsg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(alertMsg);
        alert.setHeaderText(getUwUEmoji());
        Label headerLabel = (Label) alert.getDialogPane().lookup(".header-panel .label");
        headerLabel.setFont(Font.font("Noto Sans", 18)); // Change "Noto Sans" to your desired font


        System.out.println(alert.getDialogPane().getStyle());
        alert.setTitle("Success!");
        alert.show();
    }

    public static String getUwUEmoji(){
        ArrayList<String> uwuEmojis = new ArrayList<>();
        uwuEmojis.add("(*≧ω≦)");
        uwuEmojis.add("(｡♥‿♥｡)");
        uwuEmojis.add("(⁄ ⁄•⁄ω⁄•⁄ ⁄)");
        uwuEmojis.add("(* ^ ω ^)");
        uwuEmojis.add("(っ◕‿◕)っ");
        uwuEmojis.add("ʕっ•ᴥ•ʔっ");
        uwuEmojis.add("(｡♥‿♥｡)");
        uwuEmojis.add("(づ｡◕‿‿◕｡)づ");
        uwuEmojis.add("\\(^ω^\\ )");
        uwuEmojis.add("( ´･ω･)");
        uwuEmojis.add("(=^･ω･^=)");
        uwuEmojis.add("(๑•́₃•̀๑)╰⋃╯");
        uwuEmojis.add("( ´･ω･)人(・ω・｀ )");
        uwuEmojis.add("( ͡° ͜ʖ ͡°)");
        Random random = new Random();
        int randomIndex = random.nextInt(uwuEmojis.size());
        return uwuEmojis.get(randomIndex);
    }

    public static String getAngryEmoji(){
        ArrayList<String> angryEmoji = new ArrayList<>();
        angryEmoji.add(">:C");
        angryEmoji.add("ಠ_ಠ");
        angryEmoji.add("¯\\_(U‸U)_/¯");
        angryEmoji.add("ლ(ಠXಠლ)");
        angryEmoji.add("(｡ÓwÒ｡)");
        angryEmoji.add("-__- ╭∩╮");
        angryEmoji.add("╭∩╮( •̀_•́ )╭∩╮");
        angryEmoji.add("(  •̀ ᴖ •́ )");
        angryEmoji.add("ლ₍ ˃ ⤙ ˂ ₎ლ");
        angryEmoji.add("(- ‸ - )");
        Random random = new Random();
        int randomIndex = random.nextInt(angryEmoji.size());
        return angryEmoji.get(randomIndex);

    }



}
