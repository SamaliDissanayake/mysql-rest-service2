package pizzaloop;

import org.springframework.data.repository.CrudRepository;

public interface paymentRepository extends CrudRepository<PizzaDetails, Integer> {
}
