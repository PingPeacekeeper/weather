package com.example.search.service.impl;

import com.example.provider.pojo.dto.ProviderDTO;
import com.example.search.pojo.entity.SearchResult;
import com.example.search.service.SearchService;
import com.example.university.pojo.dto.StudentDTO;
import com.example.university.pojo.dto.TeacherDTO;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class SearchServiceImpl implements SearchService {
    private final RestTemplate restTemplate;

    public SearchServiceImpl(RestTemplate template) {
        this.restTemplate = template;
    }

    @Async("searchExecutor")
    public CompletableFuture<ProviderDTO> findProvider(int id) {
        String url = String.format("http://PROVIDER-SERVICE/provider/userinfo/%d", id);
//        url="http://PROVIDER-SERVICE/provider/userinfo/1";
        try {
            ProviderDTO result = restTemplate.getForObject(url, ProviderDTO.class);
            return CompletableFuture.completedFuture(result);
        } catch (HttpClientErrorException e) {
            // log todo
            System.out.println("resource not found");
        }
        return CompletableFuture.completedFuture(null);
    }

    @Async("searchExecutor")
    public CompletableFuture<TeacherDTO> findTeacher(int id) {
        String url = String.format("http://UNIVERSITY-SERVICE/teacher/%d", id);
//        url="http://PROVIDER-SERVICE/provider/userinfo/1";
        try {
            TeacherDTO result = restTemplate.getForObject(url, TeacherDTO.class);
            return CompletableFuture.completedFuture(result);
        } catch (HttpClientErrorException e) {
            // log todo
            System.out.println("resource not found");
        }
        return CompletableFuture.completedFuture(null);
    }

    @Async("searchExecutor")
    public CompletableFuture<StudentDTO> findStudent(int id) {
        String url = String.format("http://UNIVERSITY-SERVICE/student/%d", id);
//        url="http://PROVIDER-SERVICE/provider/userinfo/1";
        try {
            StudentDTO result = restTemplate.getForObject(url, StudentDTO.class);
            return CompletableFuture.completedFuture(result);
        } catch (HttpClientErrorException e) {
            // log todo
            System.out.println("resource not found");
        }
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public SearchResult searchByID(int id) {
        CompletableFuture<ProviderDTO> provider = findProvider(id);
        CompletableFuture<StudentDTO> student = findStudent(id);
        CompletableFuture<TeacherDTO> teacher = findTeacher(id);
        CompletableFuture<Void> future = CompletableFuture.allOf(provider, student, teacher);

        future.join();

        SearchResult result = new SearchResult();
        try {
            result.setProviderDTO(provider.get());
            result.setTeacherDTO(teacher.get());
            result.setStudentDTO(student.get());
        } catch (ExecutionException | InterruptedException e) {
            // todo
        }
        return result;
    }
}
