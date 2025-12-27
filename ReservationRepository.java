package RestaurantManagementSystem26Dec.Repository;

import RestaurantManagementSystem26Dec.Model.Reservation;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ReservationRepository {
    private final Map<Long , Reservation> reservationMap = new ConcurrentHashMap<>();
    private AtomicLong reservationIdGen = new AtomicLong(1L);

    public Reservation save(Reservation reservation)
    {
        reservation.setReservationId(reservationIdGen.getAndIncrement());
        reservationMap.put(reservation.getReservationId(),reservation);
        return reservation;
    }
}
