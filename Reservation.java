package RestaurantManagementSystem26Dec.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    private Long reservationId;
    private Long userId;
    private Long tableId;
    private String timeslot;
}
