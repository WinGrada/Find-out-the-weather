import java.io.IOException;
import java.util.Map;


public class Main {

    public static void main(String[] args) throws Exception {
        Parser parser = new Parser();
        Menu menu = new Menu();

        //parser.GetUrlCities(parser.getUrl());
        //System.out.println(parser.getCityToCityUrl().get(menu.GetCityFromUser()));

        parser.GetCityWeather(parser.cityAngren);
    }
}