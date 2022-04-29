package com.codegym.service.impl;

import com.codegym.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Set;

@Service
public class DictionaryServiceImpl implements IDictionaryService {
    @Override
    public String find(String word) {
        HashMap<String, String> dictionaryList = new HashMap<>();
        dictionaryList.put("hello","xin chao");
        dictionaryList.put("one","mot");
        dictionaryList.put("two","hai");
        String result = dictionaryList.get(word);
        if(result == null) {
            return "not found";
        }
        return result;
    }


}
