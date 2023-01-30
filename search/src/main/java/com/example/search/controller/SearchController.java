package com.example.search.controller;

import com.example.provider.pojo.dto.ProviderDTO;
import com.example.provider.pojo.entity.Provider;
import com.example.search.pojo.dto.SearchResponseDTO;
import com.example.search.pojo.entity.SearchResult;
import com.example.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SearchController {

    private final SearchService service;

    @Autowired
    public SearchController(SearchService service) {
        this.service = service;
    }

    @GetMapping("/search/")
    public ResponseEntity<?> getDetails() {
        //TODO
        return new ResponseEntity<>("this is search service", HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<SearchResponseDTO> getByID(@PathVariable int id) {
        SearchResult result = service.searchByID(id);
        SearchResponseDTO dto = new SearchResponseDTO();

        dto.setProviderDTO(result.getProviderDTO());
        dto.setTeacherDTO(result.getTeacherDTO());
        dto.setStudentDTO(result.getStudentDTO());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
