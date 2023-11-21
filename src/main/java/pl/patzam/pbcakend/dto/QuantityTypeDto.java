package pl.patzam.pbcakend.dto;

import lombok.Data;
import pl.patzam.pbcakend.entity.QuantityType;

@Data
public class QuantityTypeDto {

    private Long idQuantityType;
    private String name;

    public static QuantityTypeDto of(QuantityType quantityType){
        QuantityTypeDto dto = new QuantityTypeDto();
        dto.setName(quantityType.getName());
        dto.setIdQuantityType(quantityType.getIdQuantityType());
        return dto;
    }

}
