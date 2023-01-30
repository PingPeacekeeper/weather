package com.example.search.service;

import com.example.provider.pojo.dto.ProviderDTO;
import com.example.search.pojo.entity.SearchResult;


public interface SearchService {
    public SearchResult searchByID(int id);
}
