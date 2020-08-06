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

    private final String url = "https://world-weather.ru/pogoda/uzbekistan/";
    private String dataDays;
    private String temperatureAtMorning;
    private String temperatureAtNight;

    private Map<String, String> cityToUrlCity = new HashMap<String, String>();
    public Map<String, String> datesToWeather = new HashMap<String, String>();
    public Map<String, String> daysOfWeekToWeather = new HashMap<String, String>();

    public void StartParseWeather(String cityName) throws Exception {
        GetUrlCities(url); // Заполняет cityToUrlCity.
        GetDataWeather(cityToUrlCity.get(cityName)); //Заполняет dataDays, temperatureAtMorning, temperatureAtNight
        SplitWeatherDataByDay(); // Заполняет datesToWeather, daysOfWeekToWeather

    }

    private void GetUrlCities(String url) throws IOException {
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

        ArrayList<String> dates = GetDates(arrDataDays);
        ArrayList<String> daysOfWeek = GetDaysOfWeek(arrDataDays);
        ArrayList<String> daysTemperature = CombineTemperature(arrTemperatureAtMorning, arrTemperatureAtNight);

        //----> Цикл заполняет 2 Map'а, пример k-> дата(08.10) или день недели(Пн) v-> температура днем и ночью.
        for (int i = 0; i < arrDataDays.length; i++){
            datesToWeather.put(dates.get(i), daysTemperature.get(i));
            daysOfWeekToWeather.put(daysOfWeek.get(i), daysTemperature.get(i));
        }
    }

    private ArrayList<String> CombineTemperature(String[] morningTemp, String[] nightTemp){
        ArrayList<String> daysTemperature = new ArrayList<>();
        for (int i = 0; i < morningTemp.length; i++){
            daysTemperature.add("Температура днем: "+morningTemp[i]+
                              "\tТемпература ночью: "+nightTemp[i]);
        }
        return daysTemperature;
    }

    private ArrayList<String> GetDates(String[] arrDataDays){
        ArrayList<String> dataDays = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\d{2}.\\d{2})");

        for (var dataDay : arrDataDays){
            Matcher matcher = pattern.matcher(dataDay);
            if (matcher.find()){
                dataDays.add(matcher.group());
            }
            else {
                dataDays.add("empty");
            }
        }
        return  dataDays;
    }

    private ArrayList<String> GetDaysOfWeek(String[] arrDataDays){
        ArrayList<String> dataDays = new ArrayList<>();
        Pattern pattern = Pattern.compile("(.{2})");

        for (var dataDay : arrDataDays){
            Matcher matcher = pattern.matcher(dataDay);
            if (matcher.find()){
                dataDays.add(matcher.group());
            }
            else {
                dataDays.add("empty");
            }
        }
        return  dataDays;
    }

    public void WriteDataOfWeatherToFile(){
        //TODO дописать этот метод
        System.out.println("Идет запись в файл");
    }
}

