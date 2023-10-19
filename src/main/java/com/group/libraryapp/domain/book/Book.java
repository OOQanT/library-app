package com.group.libraryapp.domain.book;

import org.springframework.util.StringUtils;

import jakarta.persistence.*;

@Entity(name = "book")
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255,name = "name")
    private String name;

    protected Book(){

    }

    public Book(String name) {
        if(!StringUtils.hasText(name)){
            throw new IllegalArgumentException("잘못된 이름");
        }
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
