package com.example.demo;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "items")
class Item {
    @Id
    private String id;  // Убрать final
    @Column(name = "name", nullable = false)
    private String name;

    // Добавить конструктор по умолчанию
    public Item() {
        this.id = UUID.randomUUID().toString();
        this.name = null;
    }

    public Item(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Геттеры и сеттеры
    public String getId() { return this.id; }
    public void setId(String id) { this.id = id; }  // Добавить сеттер

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
}


