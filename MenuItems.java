package RestaurantManagementSystem26Dec.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItems {
    private Long id;
    private String name;
    private double price;
}
