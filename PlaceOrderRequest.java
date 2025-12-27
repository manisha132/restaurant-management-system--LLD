package RestaurantManagementSystem26Dec.Model;

import lombok.Data;

import java.util.List;

@Data
public class PlaceOrderRequest {
    private Long userId;
    private List<OrderItemRequest> itemRequestList;
}
