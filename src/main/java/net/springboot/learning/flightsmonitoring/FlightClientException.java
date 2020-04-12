package net.springboot.learning.flightsmonitoring;

import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by igors on 4/12/20.
 */
@Slf4j
public class FlightClientException extends UnirestException {
    public FlightClientException(String msg, UnirestException e) {
        super(e);
    }
}
