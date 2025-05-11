package main.java.services;

import com.google.gson.Gson;
import main.java.models.ExchangeRate;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;


public class ExchangeRateServices {

    private final String apikey;
    private final String url;

    public ExchangeRateServices(){
        this.apikey = ConfigLoader.GetApiKey();
        this.url = "https://v6.exchangerate-api.com/v6/" ;
    }

    public ExchangeRate PairConversion(String base_code, String target_code, double amountBase)
    {
        var urlPairConversion = url + URLEncoder
                .encode((apikey + "/pair/" + base_code + "/" + target_code + "/" + amountBase), StandardCharsets.UTF_8) + "/";
        var urlURI = URI.create(urlPairConversion);

        try
        {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(urlURI)
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), ExchangeRate.class);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
