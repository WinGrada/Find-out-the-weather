import java.util.Scanner;

public class Menu {

    private Button button = new Button();

    public void StartMenu() throws Exception {
        while (true){
            //TODO: отсюда идет запуск программы, и вызов всех основных функций для меню
            break;

        }
    }

    private void ProcessButtonId(int idButton){
        switch (idButton){
            case 2:
                button.ExitButton();
                break;
            default:
                break;
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
