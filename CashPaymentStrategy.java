package RestaurantManagementSystem26Dec.Service;

import RestaurantManagementSystem26Dec.Model.Order;
import RestaurantManagementSystem26Dec.Model.OrderStatus;
import org.springframework.stereotype.Component;

@Component("CASH")
public class CashPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(Order order) {
        order.setStatus(OrderStatus.Paid);
    }
}
