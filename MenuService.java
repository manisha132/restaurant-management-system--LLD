package RestaurantManagementSystem26Dec.Service;

import RestaurantManagementSystem26Dec.Model.MenuItems;
import RestaurantManagementSystem26Dec.Repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Collection<MenuItems> viewAll()
    {
        return menuRepository.finalAll();
    }
}
