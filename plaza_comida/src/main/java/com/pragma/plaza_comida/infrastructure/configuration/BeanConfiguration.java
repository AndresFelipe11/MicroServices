package com.pragma.plaza_comida.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pragma.plaza_comida.domain.api.ICategoryServicePort;
import com.pragma.plaza_comida.domain.api.IDishServicePort;
import com.pragma.plaza_comida.domain.api.IRestaurantServicePort;
import com.pragma.plaza_comida.domain.spi.ICategoryPersistencePort;
import com.pragma.plaza_comida.domain.spi.IDishPersistencePort;
import com.pragma.plaza_comida.domain.spi.IRestaurantPersistencePort;
import com.pragma.plaza_comida.domain.usecase.CategoryUseCase;
import com.pragma.plaza_comida.domain.usecase.DishUseCase;
import com.pragma.plaza_comida.domain.usecase.RestaurantUseCase;
import com.pragma.plaza_comida.infrastructure.out.adapter.CategoryJpaAdapter;
import com.pragma.plaza_comida.infrastructure.out.adapter.DishJpaAdapter;
import com.pragma.plaza_comida.infrastructure.out.adapter.RestaurantJpaAdapter;
import com.pragma.plaza_comida.infrastructure.out.mapper.ICategoryEntityMapper;
import com.pragma.plaza_comida.infrastructure.out.mapper.IDishEntityMapper;
import com.pragma.plaza_comida.infrastructure.out.mapper.IRestaurantEntityMapper;
import com.pragma.plaza_comida.infrastructure.out.repository.ICategoryRepository;
import com.pragma.plaza_comida.infrastructure.out.repository.IDishRepository;
import com.pragma.plaza_comida.infrastructure.out.repository.IRestaurantRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    
    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;
    private final IDishRepository dishRepository;
    private final IDishEntityMapper dishEntityMapper;

    @Bean
    public IRestaurantPersistencePort restaurantPersistencePort() {
        return new RestaurantJpaAdapter(restaurantRepository, restaurantEntityMapper);
    }

    @Bean
    public IRestaurantServicePort restaurantServicePort() {
        return new RestaurantUseCase(restaurantPersistencePort());
    }

    @Bean
    public ICategoryPersistencePort categoryPersistencePort() {
        return new CategoryJpaAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

    @Bean
    public IDishPersistencePort dishPersistencePort() {
        return new DishJpaAdapter(dishRepository, dishEntityMapper);
    }

    @Bean
    public IDishServicePort dishServicePort() {
        return new DishUseCase(dishPersistencePort());
    }


}
