package shop_inventory_2.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shop-items")
public class ShopItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private Integer itemPrice;
    private Long batchID;
    private Long expiryDate;
    @ManyToOne
    @JoinColumn(name = "shop-sections")
    private ShopSection shopSection;

    public ShopItem() {}
    public ShopItem(String itemName, Integer itemPrice, Long batchID, Long expiryDate, ShopSection shopSection) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.batchID = batchID;
        this.expiryDate = expiryDate;
        this.shopSection = shopSection;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public Integer getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }
    public Long getBatchID() {
        return batchID;
    }
    public void setBatchID(Long batchID) {
        this.batchID = batchID;
    }
    public Long getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(Long expiryDate) {
        this.expiryDate = expiryDate;
    }
    public ShopSection getShopSection() {
        return shopSection;
    }
    public void setShopSection(ShopSection shopSection) {
        this.shopSection = shopSection;
    }
}
