package com.example.demo_dictionary.service;

import com.example.demo_dictionary.model.Dictionary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class DictionaryService implements IDictionaryService{
    private static List<Dictionary> dictionaryList = new ArrayList<>();
    static{
        dictionaryList.add(new Dictionary("xin chào","hello"));
        dictionaryList.add(new Dictionary("chào buổi sáng","good morning"));
        dictionaryList.add(new Dictionary("trường đại học","university"));
        dictionaryList.add(new Dictionary("tập trung vào","focus"));
        dictionaryList.add(new Dictionary("con chó","dog"));
        dictionaryList.add(new Dictionary("con mèo","cat"));
        dictionaryList.add(new Dictionary("con dơi","bat"));
        dictionaryList.add(new Dictionary("quyết định","decision"));
        dictionaryList.add(new Dictionary("lựa chọn","choose"));
        dictionaryList.add(new Dictionary("bữa sáng","breakfast"));
        dictionaryList.add(new Dictionary("bữa trưa","lunch"));
        dictionaryList.add(new Dictionary("bữa tối","dinner"));
    }

    @Override
    public List<Dictionary> getList() {
        return dictionaryList;
    }
}
