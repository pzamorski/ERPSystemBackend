package pl.patzam.pbcakend.dto;

import lombok.Data;
import pl.patzam.pbcakend.entity.Item;

@Data
public class ItemDto {

    private Long idItem;
    private String name;
    private Double quantity;
    private String quantityType;

    public static ItemDto of(Item item){
        ItemDto dto = new ItemDto();
        dto.setIdItem(item.getIdItem());
        dto.setName(item.getName());
        dto.setQuantity(item.getQuantity());
        dto.setQuantityType(item.getQuantityType().getName());
        return dto;
    }

}
