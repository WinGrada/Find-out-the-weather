import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Parser {


    public String getUrl() {
        return url;
    }

    private void setUrl(String url) {
        this.url = url;
    }

    private String url = "https://world-weather.ru/pogoda/uzbekistan/";

    public Map<String, String> getCityToCityUrl() {
        return cityToCityUrl;
    }

    private Map<String, String> cityToCityUrl = new HashMap<String, String>();


    public void GetUrlCities(String url) throws IOException {
        Document doc = Jsoup.connect(url).userAgent("Mozilla").get();
        Elements links = doc.select("a[class=tooltip]");

        for (Element l : links){
            String cityUrl = l.select("a").attr("href");
            String cityName = l.select("a[class=tooltip]").text();

            cityToCityUrl.put(cityName, "https:"+cityUrl);

        }
    }
}

