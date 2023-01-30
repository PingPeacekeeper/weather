package com.example.provider.service.impl;

import com.example.provider.pojo.entity.Provider;
import com.example.provider.repository.ProviderRepository;
import com.example.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ProviderServiceImpl implements ProviderService {
    private final ProviderRepository repository;

    @Autowired
    public ProviderServiceImpl(ProviderRepository repo) {
        this.repository = repo;
    }

    @Override
    @Transactional
    public Provider getByID(int id) {
        Optional<Provider> p = repository.findById(id);
        return p.orElse(null);
    }

    @Transactional
    @Override
    public Provider insert(Provider provider) {
        return repository.save(provider);
    }
}
