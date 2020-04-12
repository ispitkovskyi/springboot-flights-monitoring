package net.springboot.learning.flightsmonitoring.clients;

/**
 * Created by igors on 4/12/20.
 */

import com.mashape.unirest.http.exceptions.UnirestException;
import net.springboot.learning.flightsmonitoring.dto.FlightPricesDto;

/**
 * Browse flight prices.
 */
public interface FlightPricesClient {

    /**
     * Browse quotes for current flight based on provided arguments. One-way ticket.
     *
     * @param country the country from
     * @param currency the currency to get price
     * @param locale locale for the response
     * @param originPlace origin place
     * @param destinationPlace destination place
     * @param outboundPartialDate outbound date
     * @return {@link FlightPricesDto} object.
     */
    FlightPricesDto browseQuotes(String country, String currency, String locale, String originPlace,
                                 String destinationPlace, String outboundPartialDate) throws UnirestException;

    /**
     * Browse quotes for current flight based on provided arguments. Round trip ticket.
     *
     * @param country the country from
     * @param currency the currency to get price
     * @param locale locale for the response
     * @param originPlace origin place
     * @param destinationPlace destination place
     * @param outboundPartialDate outbound date
     * @param inboundPartialDate inbound date
     * @return {@link FlightPricesDto} object.
     */
    FlightPricesDto browseQuotes(String country, String currency, String locale, String originPlace,
                                 String destinationPlace, String outboundPartialDate, String inboundPartialDate) throws UnirestException;
}
