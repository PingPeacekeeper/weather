package com.example.provider.config;

import com.example.provider.pojo.dto.ProviderDTO;
import com.example.provider.pojo.dto.ProviderRequestDTO;
import com.example.provider.pojo.entity.Provider;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({Provider.class, ProviderDTO.class, ProviderRequestDTO.class})
public @interface EnableProvider {

}
