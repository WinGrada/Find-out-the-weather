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


    public String getUrl() { return url; }

    private void setUrl(String url) { this.url = url; }

    private String url = "https://world-weather.ru/pogoda/uzbekistan/";

    public Map<String, String> getCityToCityUrl() { return cityToCityUrl; }

    private Map<String, String> cityToCityUrl = new HashMap<String, String>();


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
        


    }

    private void GetDataFromPageWeather(String pageWeather) throws Exception {
        Pattern pattern = Pattern.compile("(\\d{2}.\\d{2})");
        Matcher matcher = pattern.matcher(pageWeather);

//        if (matcher.find()){
//            return matcher.group();
//        }
//        throw new Exception("Дата не найдена!");
    }
}

