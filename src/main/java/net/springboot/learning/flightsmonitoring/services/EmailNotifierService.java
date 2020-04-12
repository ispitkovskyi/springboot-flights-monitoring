package net.springboot.learning.flightsmonitoring.services;

import net.springboot.learning.flightsmonitoring.data_entities.Subscription;

/**
 * Send email notifications
 */
public interface EmailNotifierService {
    /**
     * Notifies subscriber, that the minPrice has decreased.
     *
     * @param subscription the {@link Subscription} object.
     * @param oldMinPrice minPrice before recount.
     * @param newMinPrice minPrice after recount.
     */
    void notifySubscriber(Subscription subscription, Integer oldMinPrice, Integer newMinPrice);

    /**
     * Notifies subscriber, that subscription has added.
     *
     * @param subscription the {@link Subscription} object.
     */
    void notifyAddingSubscription(Subscription subscription);
}
