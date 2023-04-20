package com.pragma.plaza_comida.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantResponseDto {
    private String name;
    private String address;
    private String ownerId;
    private String phoneNumber;
    private String urlLogo;
    private String nit;
}
