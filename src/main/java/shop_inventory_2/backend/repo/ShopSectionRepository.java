package shop_inventory_2.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop_inventory_2.backend.entity.ShopSection;

import java.util.ArrayList;

@Repository
public interface ShopSectionRepository extends JpaRepository<ShopSection, Long> {
    public Integer countShopSectionsByName(String name);
    public ShopSection findShopSectionByName(String name);
}
