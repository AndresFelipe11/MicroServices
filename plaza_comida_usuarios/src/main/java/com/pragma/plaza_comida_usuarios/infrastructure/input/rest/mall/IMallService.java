package com.pragma.plaza_comida_usuarios.infrastructure.input.rest.mall;

import com.pragma.plaza_comida_usuarios.application.dto.request.RestaurantEmployeeRequestDto;
import com.pragma.plaza_comida_usuarios.application.dto.response.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "plaza-service", path = "/api/v1/restaurantemployee/create", url = "http://localhost:8090")
public interface IMallService {
    @PostMapping("/")
    public ResponseEntity<ResponseDto> saveRestaurantEmployee(@RequestBody RestaurantEmployeeRequestDto restaurantEmployeeRequestDto);

}