package com.example.libapp.service.book;

import com.example.libapp.repository.book.BookRepositoryInterface;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    BookRepositoryInterface repo;

    public BookService(BookRepositoryInterface repo) {
        this.repo = repo;
    }

    public void saveBook() {
        repo.saveBook();
    }
}
