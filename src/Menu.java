import java.util.Scanner;

public class Menu {

    public Menu(Button button) {
        this.button = button;
    }

    private final Button button;


    public void StartMenu() throws Exception {
        while (true) {
            button.ShowDefaultButtons();
            button.ShowStartButtons();

            button.setIdButton(GetIdButtonFromUser());

            ProcessButtonId(button.getIdButton());



        }
    }

    private void ProcessButtonId(int idButton){
        switch (idButton) {
            case 1 -> button.BackToMainMenuButton();
            case 2 -> button.ExitButton();
            case 3 -> button.FindOutWeatherButton();
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
        System.out.print("Введите ваш выбор: ");
        if(in.hasNextInt()){
            return in.nextInt();
        }
        String errorMessage = "Введеное значение не число";
        System.out.println(errorMessage);
        throw new Exception(errorMessage);
    }


}
