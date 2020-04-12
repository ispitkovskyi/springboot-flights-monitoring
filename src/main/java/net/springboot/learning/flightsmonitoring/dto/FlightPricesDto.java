package net.springboot.learning.flightsmonitoring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by igors on 4/12/20.
 */
@Data
public class FlightPricesDto {

    @JsonProperty("Quotes")
    private List<QuoteDto> quotas;

    @JsonProperty("Places")
    private List<PlaceDto> places;

    @JsonProperty("Carriers")
    private List<CarrierDto> carriers;

    @JsonProperty("Currencies")
    private List<CurrencyDto> currencies;

    public <T> void setQuotas(List<QuoteDto> quotas) {
        this.quotas = (List<QuoteDto>) quotas;
    }


    public <T> void setCarriers(List<CarrierDto> carriers) {
        this.carriers = (List<CarrierDto>) carriers;
    }


    public <T> void setCurrencies(List<CurrencyDto> currencies) {
        this.currencies = (List<CurrencyDto>) currencies;
    }


    public <T> void setPlaces(List<PlaceDto> places) {
        this.places = (List<PlaceDto>) places;
    }
}
