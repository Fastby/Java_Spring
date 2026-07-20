package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
class DataLoader {
    private final ItemRepository itemRepository;

    public DataLoader(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @PostConstruct
    private void loadData(){
        itemRepository.saveAll(List.of(
            new Item("ID_0", "OBJ_0"),
            new Item("ID_1", "OBJ_1")
        ));
    }
}
