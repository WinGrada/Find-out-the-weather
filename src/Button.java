import java.io.IOException;

public class Button {

    public Button(Parser parser) {
        this.parser = parser;
    }

    private final Parser parser;

    public boolean isFlag_exit() {
        return flag_exit;
    }

    public void setFlag_exit(boolean flag_exit) {
        this.flag_exit = flag_exit;
    }

    private boolean flag_exit = false;

    public int getIdButton() {
        return idButton;
    }
    public void setIdButton(int idButton) {
        this.idButton = idButton;
    }
    private int idButton;

    public void ShowMainMenuButtons(){
        System.out.println("\n======================================================");
        System.out.println("\t\tПрограмма - Погода рядом!");
        System.out.println("------------------------------------------------------");
        System.out.println("1) Узнать погоду \t\t\t2) Записать данные о погоде в файл");
        System.out.println("3) Завершить программу \t\t4) FAQ - Как пользоваться программой");
        System.out.println("======================================================");
        System.out.print("> Выберите свой вариант: ");
    }

    public void ExitButton(){
        flag_exit = true;
    }

    public void FindOutWeatherButton(String cityName) throws Exception {
        parser.StartParseWeather(cityName);
    }


    public void WriteDataToFileButton(){
       // TODO переход к методу который записывает в файл погоду
    }

    public void FaqButton(){
        System.out.println("FAQ - Информация");
        System.out.println("");
    }
}
