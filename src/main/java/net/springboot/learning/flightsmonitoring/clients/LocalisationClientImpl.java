package net.springboot.learning.flightsmonitoring.clients;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import net.springboot.learning.flightsmonitoring.UniRestService;
import net.springboot.learning.flightsmonitoring.dto.CountryDto;
import net.springboot.learning.flightsmonitoring.dto.CurrencyDto;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import static net.springboot.learning.flightsmonitoring.UniRestServiceImpl.*;

/**
 * Created by igors on 4/12/20.
 */

/**
 * @Component — аннотация, которая говорит, что этот объект нужно добавить в Application Context,
 * чтобы в дальнейшем его можно было инъектировать при помощи аннотации @Autowired;
 */
@Component
public class LocalisationClientImpl implements LocalisationClient {

    /**
     * @Autowired — это аннотация, которая говорит о том, что нужно инъектировать объект в этот класс и использовать его без создания,
     * то есть без операции "new Object";
     */
    @Autowired
    private UniRestService uniRestService;

    /**
     * ObjectMapper objectMapper — объект из Jackson Project, который переводит это все в Java объекты.
     * CurrencyDTO и CountryDto:
     */
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CountryDto> retrieveCountries(String locale) throws IOException, UnirestException {
        HttpResponse<JsonNode> response = uniRestService.get(String.format(COUNTRIES_FORMAT, locale));

        if (response.getStatus() != HttpStatus.SC_OK) {
            return null;
        }

        String jsonList = response.getBody().getObject().get(COUNTRIES_KEY).toString();

        return objectMapper.readValue(jsonList, new TypeReference<List<CountryDto>>() {
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CurrencyDto> retrieveCurrencies() throws IOException, UnirestException {

        HttpResponse<JsonNode> response = uniRestService.get(CURRENCIES_FORMAT);
        if (response.getStatus() != HttpStatus.SC_OK) {
            return null;
        }

        String jsonList = response.getBody().getObject().get(CURRENCIES_KEY).toString();

        return objectMapper.readValue(jsonList, new TypeReference<List<CurrencyDto>>() {
        });
    }
}
