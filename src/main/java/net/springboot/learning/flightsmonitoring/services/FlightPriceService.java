package net.springboot.learning.flightsmonitoring.services;

import com.mashape.unirest.http.exceptions.UnirestException;
import net.springboot.learning.flightsmonitoring.data_entities.Subscription;
import net.springboot.learning.flightsmonitoring.dto.FlightPricesDto;

/**
 * Service, for getting details based on {@link Subscription} object.
 */
public interface FlightPriceService {
    /**
     * Finds minPrice based on {@link Subscription}.
     *
     * @param flightPricesDto provided {@link FlightPricesDto} object.
     * @return
     */
    Integer findMinPrice(FlightPricesDto flightPricesDto);

    /**
     * Finds all the flight data related to {@link Subscription} object.
     *
     * @param subscription provided {@link Subscription} object
     * @return {@link FlightPricesDto} with all the data related to flight specific in {@link Subscription}.
     */
    FlightPricesDto findFlightPrice(Subscription subscription) throws UnirestException;
}
