package RestaurantManagementSystem26Dec.Service;

import RestaurantManagementSystem26Dec.Model.*;
import RestaurantManagementSystem26Dec.Repository.MenuRepository;
import RestaurantManagementSystem26Dec.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;

    public OrderService(OrderRepository orderRepository, MenuRepository menuRepository) {
        this.orderRepository = orderRepository;
        this.menuRepository = menuRepository;
    }

    public synchronized Order placeOrder(PlaceOrderRequest placeOrderRequest)
    {
        Map<Long,Integer> itemMap = new HashMap<>();
        double totalPrice = 0;
        for(OrderItemRequest itemRequest : placeOrderRequest.getItemRequestList())
        {
            MenuItems menuItems = menuRepository.findById(itemRequest.getMenuItemId());
            totalPrice = menuItems.getPrice()*itemRequest.getQuantity();
            itemMap.put(itemRequest.getMenuItemId(), itemRequest.getQuantity());
        }
        Order order = new Order(null, placeOrderRequest.getUserId(),itemMap, OrderStatus.Preparing,totalPrice);
        return order;
    }
}
