package RestaurantManagementSystem26Dec.Service;

import RestaurantManagementSystem26Dec.Model.Order;

public interface PaymentStrategy {
    void pay(Order order);
}
