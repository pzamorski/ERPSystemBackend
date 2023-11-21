package pl.patzam.pbcakend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.patzam.pbcakend.dto.QuantityTypeDto;
import pl.patzam.pbcakend.entity.QuantityType;
import pl.patzam.pbcakend.repository.QuantityTypeRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class QuantityTypeController {

    private final QuantityTypeRepository quantityTypeRepository;

    @PostMapping("/quantity_types")
    QuantityType newQuantityType(@RequestBody QuantityType quantityType){
        return quantityTypeRepository.save(quantityType);
    }

    @GetMapping("/quantity_types")
    List<QuantityTypeDto> listQuantityTypes(){
        return quantityTypeRepository.findAll().stream().map(QuantityTypeDto::of).collect(Collectors.toList());
    }

    @DeleteMapping("/quantity_types")
    ResponseEntity deleteQuantityType(@RequestBody Long idQuantityType){
        quantityTypeRepository.deleteById(idQuantityType);
        return ResponseEntity.ok().build();
    }

}
