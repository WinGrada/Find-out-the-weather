import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public Menu(Button button, Parser parser) {
        this.button = button;
        this.parser = parser;
    }

    private final Button button;
    private  final Parser parser;


    public void StartMainMenu() throws Exception {
        while (!button.isFlag_exit()) {
            button.ShowMainMenuButtons();
            button.setIdButton(GetIdButtonFromUser());
            ProcessButtonId(button.getIdButton());

            if(button.isFlag_exit()){ continue; }
            if(button.getIdButton() != 1) { continue; }
            if(!parser.isExistKey()) { continue; }

            String dateOrDayOfWeek = GetDateOrDayOfWeekFromUser();
            if (dateOrDayOfWeek.length() == 2){
                System.out.println(parser.daysOfWeekToWeather.get(dateOrDayOfWeek));
            }
            else if (dateOrDayOfWeek.length() == 5){
                System.out.println(parser.datesToWeather.get(dateOrDayOfWeek));
            }

        }
    }

    private void ProcessButtonId(int idButton) throws Exception {
        switch (idButton) {
            case 1 -> button.FindOutWeatherButton(GetCityFromUser());
            case 2 -> button.ShowListCitiesButton();
            case 3 -> button.ExitButton();
            default -> {
                System.out.println("Такой кнопки не существует");
                button.setFlag_exit(true);
            }
        }
    }

    private String GetDateOrDayOfWeekFromUser(){
        Scanner in = new Scanner(System.in);
        System.out.println("\tДаты: "+parser.datesToWeather.keySet());
        System.out.println("\tДни недели: "+parser.daysOfWeekToWeather.keySet());
        System.out.print("\n\t> Введите дату или день недели: ");
        return in.nextLine();
    }
    private String GetCityFromUser(){
        Scanner in = new Scanner(System.in);
        System.out.print("\t> Введите город, чтобы узнать погоду: ");
        return in.nextLine();
    }

    private int GetIdButtonFromUser() throws Exception {
        Scanner in = new Scanner(System.in);
        if(in.hasNextInt()){
            return in.nextInt();
        }
        String errorMessage = "Введеное значение не число";
        System.out.println(errorMessage);
        throw new Exception(errorMessage);
    }


}
