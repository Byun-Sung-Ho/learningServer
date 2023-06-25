package com.example.libapp.repository.book;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class BookSqlRepository implements BookRepositoryInterface{
    @Override
    public void saveBook() {
        System.out.println("repo2");
    }
}
