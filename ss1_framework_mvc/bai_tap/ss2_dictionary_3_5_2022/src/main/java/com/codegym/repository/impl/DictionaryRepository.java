package com.codegym.repository.impl;
import com.codegym.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class DictionaryRepository implements IDictionaryRepository {

    @Override
    public String search(String word) {
        HashMap<String, String> dictionaryList = new HashMap<>();
        dictionaryList.put("hello","xin chao");
        dictionaryList.put("one","mot");
        dictionaryList.put("two","hai");
        String result = dictionaryList.get(word);
        if(result == null){
            return "not found";
        }
        return result;
    }
}
