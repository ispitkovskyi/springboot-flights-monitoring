package net.springboot.learning.flightsmonitoring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by igors on 4/12/20.
 */
@Data
public class QuoteDto {
    @JsonProperty("QuoteId")
    private String quoteId;

    @JsonProperty("MinPrice")
    private String minPrice;

    @JsonProperty("Direct")
    private String direct;

    @JsonProperty("QuoteDateTime")
    private String quoteDateTime;
}
