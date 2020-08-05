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
        }
    }

    private void ProcessButtonId(int idButton){
        switch (idButton) {
            case 1 -> button.FindOutWeatherButton();
            case 2 -> button.WriteDataToFileButton();
            case 3 -> button.ExitButton();
            case 4 -> button.FaqButton();
            default -> System.out.println("Такой кнопки не существует");
        }
    }

    private String GetCityFromUser(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введи город, чтобы узнать погоду: ");
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
