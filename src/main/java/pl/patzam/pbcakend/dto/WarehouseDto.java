package pl.patzam.pbcakend.dto;

import lombok.Data;
import pl.patzam.pbcakend.entity.Warehouse;

@Data
public class WarehouseDto {

    private Long idWarehouse;
    private String name;

    public static WarehouseDto of(Warehouse warehouse){
        WarehouseDto dto = new WarehouseDto();
        dto.setIdWarehouse(warehouse.getIdWarehouse());
        dto.setName(warehouse.getName());
        return dto;
    }

}
