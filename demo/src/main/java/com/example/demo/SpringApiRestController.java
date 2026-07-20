package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/items")
class SpringApiRestController {
    @Autowired
    private final ItemRepository itemRepository;

    public SpringApiRestController(ItemRepository itemRepository){
        this.itemRepository = itemRepository;

    }

    @GetMapping
    Iterable<Item> getItems() {return itemRepository.findAll();}

    @GetMapping("/{id}")
    Optional<Item> getItemById(@PathVariable String id) {
        return itemRepository.findById(id);
    }

    @PostMapping
    Item postItem(@RequestBody Item item){
        return itemRepository.save(item);
    }

    @PutMapping("/{id}")
    ResponseEntity<Item> putItem(@PathVariable String id, @RequestBody Item item){
        item.setId(id);
        return (!itemRepository.existsById(id))
                ? new ResponseEntity<>(itemRepository.save(item),HttpStatus.CREATED)
                : new ResponseEntity<>(itemRepository.save(item), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteItem(@PathVariable String id){
        itemRepository.deleteById(id);
    }

}
