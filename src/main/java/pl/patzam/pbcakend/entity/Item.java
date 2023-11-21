package pl.patzam.pbcakend.entity;

import lombok.Data;
import pl.patzam.pbcakend.dto.ItemSaveDto;

import jakarta.persistence.*;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;

    @Column
    private String name;

    @Column
    private Double quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idQuantityType")
    private QuantityType quantityType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idWarehouse")
    private Warehouse warehouse;

    public static Item of(ItemSaveDto dto) {
        Item item = new Item();
        item.setName(dto.getName());
        item.setQuantity(dto.getQuantity());
        return item;
    }
}
