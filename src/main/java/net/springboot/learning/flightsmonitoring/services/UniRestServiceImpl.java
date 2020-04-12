package net.springboot.learning.flightsmonitoring.services;

//import com.github.romankh3.flightsmonitoring.exception.FlightClientException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import net.springboot.learning.flightsmonitoring.clients.FlightClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by igors on 4/12/20.
 */

/**
 * {@inheritDoc}
 */
@Slf4j
@Service
public class UniRestServiceImpl implements UniRestService {

    public static final String HOST = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";

    public static final String PLACES_FORMAT = "/apiservices/autosuggest/v1.0/%s/%s/%s/?query=%s";
    public static final String CURRENCIES_FORMAT = "/apiservices/reference/v1.0/currencies";
    public static final String COUNTRIES_FORMAT = "/apiservices/reference/v1.0/countries/%s";

    public static final String PLACES_KEY = "Places";
    public static final String CURRENCIES_KEY = "Currencies";
    public static final String COUNTRIES_KEY = "Countries";

    //"x.rapid.api.key" property is expected to be available in the application.properties file in "resources"
    @Value("${x.rapid.api.key}")
    private String xRapidApiKey;

    /**
     * {@inheritDoc}
     */
    @Override
    public HttpResponse<JsonNode> get(String path) throws FlightClientException {
        HttpResponse<JsonNode> response = null;
        //todo: to get all currencies, "path" should be equal to "/apiservices/reference/v1.0/currencies"
        //todo: to get all countries, "path" should be equal to "/apiservices/reference/v1.0/countries"
        try {
            response = Unirest.get(HOST + path)
                    .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                    .header("x-rapidapi-key", xRapidApiKey)
                    .asJson();
        } catch (UnirestException e) {
            throw new FlightClientException(String.format("Request failed, path=%s", HOST + path), e);
        }

        log.info("Response from Get request, on path={}, statusCode={}, response={}", path, response.getStatus(), response.getBody().toString());
        return response;
    }
}
