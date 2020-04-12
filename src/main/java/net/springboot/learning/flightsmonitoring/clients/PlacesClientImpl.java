package net.springboot.learning.flightsmonitoring.clients;

/**
 * Created by igors on 4/12/20.
 */

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import net.springboot.learning.flightsmonitoring.services.UniRestService;
import net.springboot.learning.flightsmonitoring.dto.PlacesDto;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

import static net.springboot.learning.flightsmonitoring.services.UniRestServiceImpl.PLACES_FORMAT;
import static net.springboot.learning.flightsmonitoring.services.UniRestServiceImpl.PLACES_KEY;

/**
 * {@inheritDoc}
 */
//INITIALLY HERE WAS @Service - WHY???
@Component
public class PlacesClientImpl implements PlacesClient {

    @Autowired
    private UniRestService uniRestService;

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * {@inheritDoc}
     */
    @Override
    public List<PlacesDto> retrieveListPlaces(String query, String country, String currency, String locale)
            throws IOException, UnirestException {
        HttpResponse<JsonNode> response = uniRestService.get(String.format(PLACES_FORMAT, country, currency, locale, query));

        if (response.getStatus() != HttpStatus.SC_OK) {
            return null;
        }

        String jsonList = response.getBody().getObject().get(PLACES_KEY).toString();

        return objectMapper.readValue(jsonList, new TypeReference<List<PlacesDto>>() {
        });
    }
}
