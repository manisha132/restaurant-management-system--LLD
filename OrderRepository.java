package RestaurantManagementSystem26Dec.Repository;

import RestaurantManagementSystem26Dec.Model.Order;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class OrderRepository {
    private final Map<Long, Order> orderMap = new ConcurrentHashMap<>();
    private AtomicLong orderIdGen = new AtomicLong(1L);

    public Order save(Order order)
    {
       order.setOrderId(orderIdGen.getAndIncrement());
       orderMap.put(order.getOrderId(), order);
       return order;
    }

    public Order findByOrderId(Long orderId)
    {
        return orderMap.get(orderId);
    }
}
