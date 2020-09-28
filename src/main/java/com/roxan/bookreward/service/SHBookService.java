package com.roxan.bookreward.service;

import com.roxan.bookreward.model.SHBook;
import com.roxan.bookreward.repository.SHBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ISHBookService")
public class SHBookService {


    @Autowired
    private SHBookRepository shBookRepository;

    public List<SHBook> findAll() {
        return shBookRepository.findAll();
    }

    public void save(SHBook shBook) {
        shBookRepository.save(shBook);
    }

    public SHBook findById(Integer id) {
        Optional<SHBook> shBook = shBookRepository.findById(id);
        if(shBook.isPresent()){
            return shBook.get();
        }
        return null;
    }

    public void deleteById(Integer id) {
        shBookRepository.deleteById(id);
    }
}
