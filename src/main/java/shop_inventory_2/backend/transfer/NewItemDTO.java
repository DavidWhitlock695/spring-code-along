package shop_inventory_2.backend.transfer;

public class NewItemDTO {
    private String name;
    private Integer price;
    private Long batchID;
    private Long expiryDate;
    private String section;

    public NewItemDTO(String name, Integer price, Long batchID, Long expiryDate, String section) {
        this.name = name;
        this.price = price;
        this.batchID = batchID;
        this.expiryDate = expiryDate;
        this.section = section;
    }
    //Getters and Setters
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPrice() {
        return this.price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public Long getBatchID() {
        return this.batchID;
    }
    public void setBatchID(Long batchID) {
        this.batchID = batchID;
    }
    public Long getExpiryDate() {
        return this.expiryDate;
    }
    public void setExpiryDate(Long expiryDate) {
        this.expiryDate = expiryDate;
    }
    public String getSection() {
        return this.section;
    }
    public void setSection(String section) {
        this.section = section;
    }
}
