import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parser {


    private String url = "https://world-weather.ru/pogoda/uzbekistan/";
    private String dataDays;
    private String temperatureAtMorning;
    private String temperatureAtNight;

    private Map<String, String> cityToUrlCity = new HashMap<String, String>();
    private Map<String, String> datesToWeather = new HashMap<String, String>();
    private Map<String, String> daysOfWeekToWeather = new HashMap<String, String>();

    public void GetUrlCities(String url) throws IOException {
        Document doc = Jsoup.connect(url).userAgent("Mozilla").get();
        Elements links = doc.select("a[class=tooltip]");

        for (Element l : links){
            String cityUrl = l.select("a").attr("href");
            String cityName = l.select("a[class=tooltip]").text();

            cityToUrlCity.put(cityName, "https:"+cityUrl);

        }
    }

    private void GetDataWeather(String cityUrl) throws Exception {
        Document doc = Jsoup.connect(cityUrl).userAgent("Mozilla").get();
        Elements WeatherDataBlock = doc.select("div[id=defSet-3]");

        dataDays = WeatherDataBlock.attr("data-days");
        temperatureAtMorning = WeatherDataBlock.attr("data-td");
        temperatureAtNight = WeatherDataBlock.attr("data-tn");
    }

    private void SplitWeatherDataByDay(){

        String[] arrDataDays = dataDays.split(",");
        String[] arrTemperatureAtMorning = temperatureAtMorning.split(",");
        String[] arrTemperatureAtNight = temperatureAtNight.split(",");

        ArrayList<String> dates = new ArrayList<>();
        ArrayList<String> daysOfWeek = new ArrayList<>();
        ArrayList<String> dayTemperature = CombineTemperature(arrTemperatureAtMorning, arrTemperatureAtNight);


    }

    public ArrayList<String> CombineTemperature(String[] morningTemp, String[] nightTemp){
        ArrayList<String> dayTemperature = new ArrayList<>();
        for (int i = 0; i < morningTemp.length; i++){
            dayTemperature.add("Температура днем: "+morningTemp[i]+
                               "\tТемпература ночью: "+nightTemp[i]);
        }
        return dayTemperature;
    }

    public void WriteDataOfWeatherToFile(){
        //TODO дописать этот метод
        System.out.println("Идет запись в файл");
    }
}

