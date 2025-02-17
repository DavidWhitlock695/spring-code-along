package shop_inventory_2.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop_inventory_2.backend.entity.ShopItem;
import shop_inventory_2.backend.transfer.NewItemDTO;
import shop_inventory_2.backend.transfer.UpdatedItemDTO;

import java.util.ArrayList;

@RestController
public class Controller {
    @Autowired
    private Service service;

    @GetMapping("/shop-inventory-2/")
    public ArrayList<ShopItem> getShopItems() {
        return service.getShopItems();
    }

    @PostMapping("/shop-inventory-2/addItem")
    public void addShopItem(@RequestBody NewItemDTO newItemDTO) {
        service.addShopItem(newItemDTO);
    }

    @PutMapping("shop-inventory-2/updateItem")
    public void updateShopItem(@RequestBody UpdatedItemDTO updatedItemDTO) {
        service.updateItem(updatedItemDTO);
    }

    @DeleteMapping("/shop-inventory-2/deleteItem/{id}")
    public void deleteItem(@PathVariable String id) {
        Long itemID = Long.parseLong(id);
        service.deleteItem(itemID);
    }
}
