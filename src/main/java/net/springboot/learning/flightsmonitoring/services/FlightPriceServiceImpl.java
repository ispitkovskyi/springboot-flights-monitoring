package net.springboot.learning.flightsmonitoring.services;

import com.mashape.unirest.http.exceptions.UnirestException;
import net.springboot.learning.flightsmonitoring.clients.FlightPricesClient;
import net.springboot.learning.flightsmonitoring.data_entities.Subscription;
import net.springboot.learning.flightsmonitoring.dto.FlightPricesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Чтобы связать работу нашего FlightPricesClient и сервиса для обработки подписок, нужно создать сервис,
 * который будет на основании Subscription объекта выдавать полную информацию о рейсе с минимальной стоимостью.
 */

/**
 * {@inheritDoc}
 */
@Service
public class FlightPriceServiceImpl implements FlightPriceService {

    @Autowired
    private FlightPricesClient flightPricesClient;

    /**
     * Здесь у нас есть два метода: один возвращает полную информацию о полете с минимальной ценой,
     * а другой принимает эту информацию и выдает значение минимальной цены.
     */

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer findMinPrice(FlightPricesDto flightPricesDto) {
        return Integer.valueOf(flightPricesDto.getQuotas().get(0).getMinPrice());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FlightPricesDto findFlightPrice(Subscription subscription) throws UnirestException {
        if (subscription.getInboundPartialDate() == null) {
            return flightPricesClient
                    .browseQuotes(subscription.getCountry(), subscription.getCurrency(), subscription.getLocale(),
                            subscription.getOriginPlace(), subscription.getDestinationPlace(),
                            subscription.getOutboundPartialDate().toString());
        } else {
            return flightPricesClient
                    .browseQuotes(subscription.getCountry(), subscription.getCurrency(), subscription.getLocale(),
                            subscription.getOriginPlace(), subscription.getDestinationPlace(),
                            subscription.getOutboundPartialDate().toString(), subscription.getInboundPartialDate().toString());
        }
    }
}
