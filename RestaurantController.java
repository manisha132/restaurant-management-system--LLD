package RestaurantManagementSystem26Dec.Controller;

import RestaurantManagementSystem26Dec.Model.MenuItems;
import RestaurantManagementSystem26Dec.Model.Order;
import RestaurantManagementSystem26Dec.Model.PlaceOrderRequest;
import RestaurantManagementSystem26Dec.Service.MenuService;
import RestaurantManagementSystem26Dec.Service.OrderService;
import RestaurantManagementSystem26Dec.Service.PaymentService;
import RestaurantManagementSystem26Dec.Service.PaymentStrategy;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class RestaurantController {
    private final MenuService menuService;
    private final OrderService orderService;
    private final PaymentService paymentService;
    private final Map<String, PaymentStrategy> paymentStrategies;

    public RestaurantController(MenuService menuService, OrderService orderService, PaymentService paymentService, Map<String, PaymentStrategy> paymentStrategies) {
        this.menuService = menuService;
        this.orderService = orderService;
        this.paymentService = paymentService;
        this.paymentStrategies = paymentStrategies;
    }


    @GetMapping("/viewMenu")
    public Collection<MenuItems> viewMenu() {
        return menuService.viewAll();
    }

    @PostMapping("/Orders/place")
    public Order place(@RequestBody PlaceOrderRequest request) {
        return orderService.placeOrder(request);
    }

    @PostMapping("/pay")
    public String pay(@RequestParam Long orderId,
                      @RequestParam String method) {
        paymentService.pay(orderId, paymentStrategies.get(method));
        return "Payment Successful";
    }

}
