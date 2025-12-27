package RestaurantManagementSystem26Dec.Service;

import RestaurantManagementSystem26Dec.Model.Order;
import RestaurantManagementSystem26Dec.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentService {
    //private  final Map<String,PaymentStrategy> paymentStrategy ;
    private final Map<String, PaymentStrategy> paymentStrategies;

    private final OrderRepository orderRepository;


    public PaymentService(Map<String, PaymentStrategy> paymentStrategy, OrderRepository orderRepository) {
        this.paymentStrategies = paymentStrategy;
        this.orderRepository = orderRepository;
    }

    public void pay(Long orderId,PaymentStrategy paymentStrategy)
    {
        Order order = orderRepository.findByOrderId(orderId);
        if (order == null) {
            throw new RuntimeException("Order not found");
        }
        PaymentStrategy strategy = paymentStrategies.get(paymentStrategy);
        if (strategy == null) {
            throw new RuntimeException("Invalid payment method");
        }
        strategy.pay(order);
        orderRepository.save(order);

    }
}
