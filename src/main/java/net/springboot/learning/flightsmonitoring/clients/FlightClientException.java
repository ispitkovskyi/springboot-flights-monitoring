package net.springboot.learning.flightsmonitoring.clients;

import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import net.springboot.learning.flightsmonitoring.dto.ValidationErrorDto;

import java.io.IOException;
import java.util.List;

/**
 * Created by igors on 4/12/20.
 */
@Slf4j
public class FlightClientException extends UnirestException {
    public FlightClientException(String message) {
        super(message);
    }

    public FlightClientException(Exception throwable) {
        super(throwable);
    }

    public FlightClientException(String message, List<ValidationErrorDto> errors) {
        super(message);
        this.validationErrorDtos = errors;
    }

    private List<ValidationErrorDto> validationErrorDtos;

    public FlightClientException(String message, Exception e) {
        super(e);
    }
}
