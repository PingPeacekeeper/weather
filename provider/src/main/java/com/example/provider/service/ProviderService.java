package com.example.provider.service;


import com.example.provider.pojo.entity.Provider;

public interface ProviderService {
    Provider getByID(int id);

    Provider insert(Provider provider);
}
