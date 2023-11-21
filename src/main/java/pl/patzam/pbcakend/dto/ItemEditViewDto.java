package pl.patzam.pbcakend.dto;

import lombok.Data;
import pl.patzam.pbcakend.entity.Item;
import pl.patzam.pbcakend.entity.QuantityType;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ItemEditViewDto {

    private Long idItem;
    private String name;
    private Double quantity;
    private Long idQuantityType;
    private List<QuantityTypeDto> quantityTypeDtoList;

    public static ItemEditViewDto of(Item item, List<QuantityType> quantityTypeList){
        ItemEditViewDto dto = new ItemEditViewDto();
        dto.setIdItem(item.getIdItem());
        dto.setName(item.getName());
        dto.setQuantity(item.getQuantity());
        dto.setIdQuantityType(item.getQuantityType().getIdQuantityType());
        dto.setQuantityTypeDtoList(quantityTypeList.stream().map(QuantityTypeDto::of).collect(Collectors.toList()));
        return dto;
    }

}
