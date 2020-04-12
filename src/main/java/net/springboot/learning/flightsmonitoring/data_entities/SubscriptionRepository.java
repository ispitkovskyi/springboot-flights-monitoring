package net.springboot.learning.flightsmonitoring.data_entities;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Additional method to be added to what we have in the Spring Data framework (org.springframework.data.jpa.repository.JpaRepository
/**
 * Аннотация @Repository нужна для того, чтобы потом можно было этот интерфейс инъектировать в другие классы)
 * И всё…) Вот так просто работать со Spring Data.
 */
@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByEmail(String email);
}
