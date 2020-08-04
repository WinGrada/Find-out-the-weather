public class Button {

    public int getIdButton() {
        return idButton;
    }

    public void setIdButton(int idButton) {
        this.idButton = idButton;
    }

    private int idButton;

    public void ShowDefaultButtons(){
        System.out.println("Нажмите кнопку:");
        System.out.println("1 - В главное меню");
        System.out.println("2 - Завершить программу");
    }

    public void ShowStartButtons(){
        System.out.println("3 - Узнать погоду");
    }

    public void ExitButton(){
        System.exit(0);
    }

    public void BackToMainMenuButton(){
        ShowDefaultButtons();
        ShowStartButtons();
    }

    public void FindOutWeatherButton(){
        //TODO: Переход к методу которы находит погоду.
        System.out.println("Погода");
    }
}
