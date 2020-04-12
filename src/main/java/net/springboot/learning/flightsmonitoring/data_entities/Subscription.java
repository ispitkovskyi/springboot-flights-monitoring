package net.springboot.learning.flightsmonitoring.data_entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * Configuration of H2 database is in "resources/application.properties" file
 */

/**
 * @Entity — аннотация из JPA, которая говорит, что это будет сущность из базы данных;
 * @Table(name = “subscription”) — также из JPA, которая определяет, с какой таблицей будет соединяться эта сущность.
 */
@Data
@Entity
@Table(name = "subscription")
public class Subscription implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "country")
    private String country;

    @Column(name = "currency")
    private String currency;

    @Column(name = "locale")
    private String locale;

    @Column(name = "origin_place")
    private String originPlace;

    @Column(name = "destination_place")
    private String destinationPlace;

    @Column(name = "outbound_partial_date")
    private LocalDate outboundPartialDate;

    @Column(name = "inbound_partial_date")
    private LocalDate inboundPartialDate;

    @Column(name = "min_price")
    private Integer minPrice;
}
