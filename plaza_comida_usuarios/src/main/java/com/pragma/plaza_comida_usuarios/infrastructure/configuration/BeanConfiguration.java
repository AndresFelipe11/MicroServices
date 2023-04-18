// package com.pragma.plaza_comida_usuarios.infrastructure.configuration;

// import lombok.RequiredArgsConstructor;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// import com.pragma.plaza_comida_usuarios.domain.api.IUserServicePort;
// import com.pragma.plaza_comida_usuarios.domain.spi.IUserPersistencePort;

// @Configuration
// @RequiredArgsConstructor
// public class BeanConfiguration {
//     private final IUserRepository userRepository;
//     private final IUserEntityMapper userEntityMapper;

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public IUserPersistencePort userPersistencePort() {
//         return new UserJpaAdapter(userRepository, userEntityMapper);
//     }

//     @Bean
//     public IUserServicePort userServicePort() {
//         return new UserUseCase(userPersistencePort());
//     }

// }