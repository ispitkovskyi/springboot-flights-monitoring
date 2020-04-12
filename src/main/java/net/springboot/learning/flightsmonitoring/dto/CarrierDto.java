package net.springboot.learning.flightsmonitoring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by igors on 4/12/20.
 */
@Data
public class CarrierDto {
    @JsonProperty("CarrierId")
    private String carrierId;

    @JsonProperty("Name")
    private String name;
}
