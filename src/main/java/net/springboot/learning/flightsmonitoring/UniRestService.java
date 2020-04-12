package net.springboot.learning.flightsmonitoring;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
/**
 * Created by igors on 4/12/20.
 */
/**
 * Service, which is manipulating with Rest calls.
 */
public interface UniRestService {

    /**
     * Create GET request based on provided {@param path} with needed headers.
     *
     * @param path provided path with all the needed data
     * @return {@link HttpResponse<JsonNode>} response object.
     */
    HttpResponse<JsonNode> get(String path) throws UnirestException;

}