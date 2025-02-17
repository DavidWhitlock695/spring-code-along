package shop_inventory_2.backend;

import org.springframework.beans.factory.annotation.Autowired;
import shop_inventory_2.backend.entity.ShopItem;
import shop_inventory_2.backend.entity.ShopSection;
import shop_inventory_2.backend.repo.ShopItemRepository;
import shop_inventory_2.backend.repo.ShopSectionRepository;
import shop_inventory_2.backend.transfer.NewItemDTO;
import shop_inventory_2.backend.transfer.UpdatedItemDTO;

import java.util.ArrayList;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private ShopItemRepository shopItemRepository;
    @Autowired
    private ShopSectionRepository shopSectionRepository;

    private void saveSectionIfNew(String sectionName) {
        if (shopSectionRepository.countShopSectionsByName(sectionName) == 0) {
            ShopSection shopSection = new ShopSection(sectionName);
            shopSectionRepository.save(shopSection);
        }
    }

    private void ifUnusedRemoveSection(ShopSection section) {
        if (shopItemRepository.getAllByShopSection(section).isEmpty()) {
            shopSectionRepository.delete(section);
        }
    }

    public ArrayList<ShopItem> getShopItems() {
        return new ArrayList<>(shopItemRepository.findAll());
    }

    public void addShopItem(NewItemDTO newItemDTO) {
        saveSectionIfNew(newItemDTO.getSection());
        ShopSection currentShopSection = shopSectionRepository.findShopSectionByName(newItemDTO.getSection());
        ShopItem newShopItem = new ShopItem(newItemDTO.getName(), newItemDTO.getPrice(), newItemDTO.getBatchID(), newItemDTO.getExpiryDate(), currentShopSection);
        shopItemRepository.save(newShopItem);
    }

    public void updateItem(UpdatedItemDTO modifiedItemDTO) {
        //Get original Item and original Section using ID
        ShopItem originalShopItem = shopItemRepository.getReferenceById(modifiedItemDTO.getItemID());
        ShopSection originalSection = originalShopItem.getShopSection();
        //If updated section is new, add to ShopSection repo
        saveSectionIfNew(modifiedItemDTO.getSection());
        //Update all values of original ShopItem
        originalShopItem.setItemName(modifiedItemDTO.getName());
        originalShopItem.setItemPrice(modifiedItemDTO.getPrice());
        originalShopItem.setBatchID(modifiedItemDTO.getBatchID());
        originalShopItem.setExpiryDate(modifiedItemDTO.getExpiryDate());
        originalShopItem.setShopSection(shopSectionRepository.findShopSectionByName(modifiedItemDTO.getSection()));
        shopItemRepository.save(originalShopItem);
        // Clean up by checking if the original section is no longer used and delete.
        ifUnusedRemoveSection(originalSection);
    }

    public void deleteItem(Long itemID) {
        ShopItem shopItem = shopItemRepository.getReferenceById(itemID);
        shopItemRepository.deleteById(itemID);
        ifUnusedRemoveSection(shopItem.getShopSection());
    }
}
