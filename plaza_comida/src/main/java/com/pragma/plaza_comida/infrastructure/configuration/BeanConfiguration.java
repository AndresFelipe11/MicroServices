package com.pragma.plaza_comida.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pragma.plaza_comida.domain.api.IRestaurantServicePort;
import com.pragma.plaza_comida.domain.spi.IRestaurantPersistencePort;
import com.pragma.plaza_comida.domain.usecase.RestaurantUseCase;
import com.pragma.plaza_comida.infrastructure.out.adapter.RestaurantJpaAdapter;
import com.pragma.plaza_comida.infrastructure.out.mapper.IRestaurantEntityMapper;
import com.pragma.plaza_comida.infrastructure.out.repository.IRestaurantRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    
    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;


    @Bean
    public IRestaurantPersistencePort restaurantPersistencePort() {
        return new RestaurantJpaAdapter(restaurantRepository, restaurantEntityMapper);
    }

    @Bean
    public IRestaurantServicePort restaurantServicePort() {
        return new RestaurantUseCase(restaurantPersistencePort());
    }

}
