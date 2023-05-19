package moderna.ifoodbackend.controller;

import lombok.AllArgsConstructor;

import moderna.ifoodbackend.model.empresa.Item;

import moderna.ifoodbackend.model.empresa.Restaurante;
import moderna.ifoodbackend.repository.ItemRepository;
import moderna.ifoodbackend.service.ItemService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("mok")
    public Item mok(){
        var item = new Item();
        var restaurante = new Restaurante();
        item.setRestaurante(restaurante);
        return item;
    }

    @GetMapping("listar")
    public List<Item> listar(){
        return itemRepository.findAll();
    }

    @GetMapping("buscar/{id}")
    public Optional<Item> buscarPorId(@PathVariable Long id){
        return itemRepository.findById(id);
    }

    @DeleteMapping("deletar/{id}")
    public void deletarPorId(@PathVariable Long id){
        itemRepository.deleteById(id);
    }

    @DeleteMapping("deletar-todos")
    public void deletarTodos(){
        itemRepository.deleteAll();
    }

}
