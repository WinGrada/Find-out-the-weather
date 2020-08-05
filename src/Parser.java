import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parser {


    private String url = "https://world-weather.ru/pogoda/uzbekistan/";

    private Map<String, String> cityToCityUrl = new HashMap<String, String>();

    // Временая переменная
    public String cityAngren = "https://world-weather.ru/pogoda/uzbekistan/angren/";


    public void GetUrlCities(String url) throws IOException {
        Document doc = Jsoup.connect(url).userAgent("Mozilla").get();
        Elements links = doc.select("a[class=tooltip]");

        for (Element l : links){
            String cityUrl = l.select("a").attr("href");
            String cityName = l.select("a[class=tooltip]").text();

            cityToCityUrl.put(cityName, "https:"+cityUrl);

        }
    }

    public void GetCityWeather(String cityUrl) throws Exception {
        Document doc = Jsoup.connect(cityUrl).userAgent("Mozilla").get();
        String pageWeather = doc.select("ul[class=tabs tabs-db]").toString();
        
        //TODO Дописать эту функцию, она должна записывать погоду города в список.

    }

    private void GetDataFromPageWeather(String pageWeather) throws Exception {
        Pattern pattern = Pattern.compile("(\\d{2}.\\d{2})");
        Matcher matcher = pattern.matcher(pageWeather);
        //TODO функция должна возвращать всю дату, а не только первую.
//        if (matcher.find()){
//            return matcher.group();
//        }
//        throw new Exception("Дата не найдена!");
    }

    public void WrtiteDataOfWeatherToFile(){
        //TODO дописать этот метод
        System.out.println("Идет запись в файл");
    }
}

