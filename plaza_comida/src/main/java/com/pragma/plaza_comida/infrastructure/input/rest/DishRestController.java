package com.pragma.plaza_comida.infrastructure.input.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pragma.plaza_comida.application.dto.request.DishRequestDto;
import com.pragma.plaza_comida.application.dto.request.DishUpdateRequestDto;
import com.pragma.plaza_comida.application.dto.response.DishResponseDto;
import com.pragma.plaza_comida.application.handler.IDishHandler;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dish")
@RequiredArgsConstructor
public class DishRestController {

    private final IDishHandler dishHandler;

    @PostMapping("/")
    public ResponseEntity<Void> saveDish(@RequestBody DishRequestDto dishRequestDto) {
        dishHandler.saveDish(dishRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<DishResponseDto>> getAllDishes() {
        return ResponseEntity.ok(dishHandler.getAllDishes());
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateDish(@RequestBody DishUpdateRequestDto dishUpdateRequestDto) {
        dishHandler.updateDish(dishUpdateRequestDto);
        return ResponseEntity.noContent().build();
    }


}
