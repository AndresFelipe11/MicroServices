package com.pragma.plaza_comida.application.dto.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishRequestDto {
    
    @NotNull(message = "Nombre es obligatorio")
    private String name;
    @NotNull(message = "Categoria es obligatorio")
    private Long categoryId;
    @NotNull(message = "Descripcion es obligatorio")
    private String description;
    @NotNull(message = "Precio es obligatorio")
    private Float price;
    @NotNull(message = "Identificador del restaurante es obligatorio")
    private Long restaurantId;
    @NotNull(message = "Url de la imagen es obligatorio")
    private String urlImage;
    private Boolean active = true;


}
