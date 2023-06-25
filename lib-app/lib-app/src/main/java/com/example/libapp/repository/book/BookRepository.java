package com.example.libapp.repository.book;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository implements BookRepositoryInterface{
    @Override
    public void saveBook() {
        System.out.println("repo1");
    }
}
