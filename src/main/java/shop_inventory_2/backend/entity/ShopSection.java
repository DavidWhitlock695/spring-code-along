package shop_inventory_2.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shop-sections")
public class ShopSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public ShopSection() {}

    public ShopSection(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
