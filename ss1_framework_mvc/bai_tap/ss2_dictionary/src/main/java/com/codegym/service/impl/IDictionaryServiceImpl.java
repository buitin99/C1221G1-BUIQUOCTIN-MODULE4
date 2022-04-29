package com.codegym.service.impl;

import com.codegym.service.IDictionaryService;
import org.springframework.stereotype.Service;

@Service
public class IDictionaryServiceImpl implements IDictionaryService {
    @Override
    public String findByWord(String word) {
        String result = null;
        switch (word) {
            case "red":
                result = "do";
                break;
            case "blue":
                result = "xanh";
                break;
            case "pink":
                result = "hong";
                break;
            default:
                result = "khong tim thay";
                break;
        }
        return result;
    }
}
