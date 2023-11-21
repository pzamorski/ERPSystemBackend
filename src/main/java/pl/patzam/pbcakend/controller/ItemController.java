package pl.patzam.pbcakend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.patzam.pbcakend.dto.ItemDto;
import pl.patzam.pbcakend.dto.ItemEditViewDto;
import pl.patzam.pbcakend.dto.ItemSaveDto;
import pl.patzam.pbcakend.entity.Item;
import pl.patzam.pbcakend.repository.ItemRepository;
import pl.patzam.pbcakend.repository.QuantityTypeRepository;
import pl.patzam.pbcakend.service.ItemService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;
    private final QuantityTypeRepository quantityTypeRepository;

    @PostMapping("/items")
    public ItemDto newItem(@RequestBody ItemSaveDto dto){
        if(dto.getIdItem() == null) {
            return ItemDto.of(itemService.saveItem(dto));
        } else{
            Item item = itemRepository.findById(dto.getIdItem()).get();
            item.setName(dto.getName());
            item.setQuantity(dto.getQuantity());
            item.setQuantityType(quantityTypeRepository.findById(dto.getIdQuantityType()).get());
            return ItemDto.of(itemRepository.save(item));
        }
    }

    @GetMapping("/items")
    public List<ItemDto> listItems(){
        return itemRepository.findAll()
                .stream()
                .map(ItemDto::of)
                .collect(Collectors.toList());
    }

    @GetMapping("/items/{idItem}")
    public ItemDto getItem(@PathVariable Long idItem) throws InterruptedException {
        Optional<Item> optionalItem = itemRepository.findById(idItem);
        return ItemDto.of(optionalItem.get());
    }

    @GetMapping("/item_edit_data/{idItem}")
    public ItemEditViewDto getItemEditDto(@PathVariable Long idItem){
        Item item = itemRepository.findById(idItem).get();
        ItemEditViewDto dto  =ItemEditViewDto.of(item, quantityTypeRepository.findAll());
        return dto;
    }


    @DeleteMapping("/items/{idItem}")
    public ResponseEntity deleteItem(@PathVariable Long idItem){
        itemRepository.deleteById(idItem);
        return ResponseEntity.ok().build();
    }

}
