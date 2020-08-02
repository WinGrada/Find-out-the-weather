import java.util.Scanner;

public class Menu {

    public String GetCityFromUser(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введи город, чтобы узнать погоду: ");
        return in.nextLine();
    }
}
