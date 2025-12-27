package RestaurantManagementSystem26Dec.Repository;

import RestaurantManagementSystem26Dec.Model.MenuItems;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MenuRepository {
    private final Map<Long, MenuItems> menuItemsMap = new ConcurrentHashMap<>();

    public MenuRepository()
    {
        menuItemsMap.put(1L,new MenuItems(1L, "Paneer Butter Masala", 250));
        menuItemsMap.put(2L,new MenuItems(2L, "Veg Biryani", 200));
        menuItemsMap.put(3L,new MenuItems(3L, "Butter Naan", 40));
        menuItemsMap.put(4L,new MenuItems(4L, "halwa", 140));
    }

    public Collection<MenuItems> finalAll()
    {
        return menuItemsMap.values();
    }
    public MenuItems findById(Long id)
    {
        return menuItemsMap.get(id);
    }

}
