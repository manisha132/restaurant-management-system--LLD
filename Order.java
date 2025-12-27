package RestaurantManagementSystem26Dec.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long orderId;
    private Long UserId;
    private Map<Long,Integer> items ;
    private OrderStatus status;
    private double totalPrice;

}
