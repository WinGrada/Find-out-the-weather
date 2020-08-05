import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) throws Exception {

        String cityAngren = "https://world-weather.ru/pogoda/uzbekistan/angren/";

        Parser parser = new Parser();
        Button button = new Button(parser);
        Menu menu = new Menu(button, parser);
//        menu.StartMainMenu();



    }
}
