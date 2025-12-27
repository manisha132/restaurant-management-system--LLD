package RestaurantManagementSystem26Dec.Model;

import lombok.Data;

@Data
public class OrderItemRequest {
    private Long menuItemId;
    private int quantity;
}
