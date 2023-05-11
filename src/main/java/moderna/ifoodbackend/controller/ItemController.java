package moderna.ifoodbackend.controller;

import lombok.AllArgsConstructor;
import moderna.ifoodbackend.model.empresa.Item;
import moderna.ifoodbackend.model.empresa.Restaurante;
import moderna.ifoodbackend.repository.ItemRepository;
import moderna.ifoodbackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
@AllArgsConstructor
public class ItemController {
    ItemService itemService;
    ItemRepository itemRepository;

    @PostMapping("/criar")
    public Item novo(@RequestBody Item item){
        return itemRepository.save(item);
    }

    @GetMapping("/listar")
    public List<Item> listar(){
        return itemRepository.findAll();
    }
}
