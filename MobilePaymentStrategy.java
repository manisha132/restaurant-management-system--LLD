package RestaurantManagementSystem26Dec.Service;

import RestaurantManagementSystem26Dec.Model.Order;
import RestaurantManagementSystem26Dec.Model.OrderStatus;
import org.springframework.stereotype.Component;

@Component("MOBILE")
public class MobilePaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(Order order) {
        order.setStatus(OrderStatus.Paid);
    }
}
