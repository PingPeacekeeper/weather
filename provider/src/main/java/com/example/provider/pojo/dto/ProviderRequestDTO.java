package com.example.provider.pojo.dto;

import com.example.provider.pojo.entity.Provider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProviderRequestDTO {
    private Provider provider;
}
