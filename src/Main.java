import java.io.IOException;
import java.util.Map;


public class Main {

    public static void main(String[] args) throws Exception {
        Parser parser = new Parser();
        Button button = new Button(parser);
        Menu menu = new Menu(button, parser);
        menu.StartMainMenu();


    }
}
