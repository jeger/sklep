package com.example.sklep;

import com.example.sklep.product.entites.ProductDetailsEntity;
import com.example.sklep.product.entites.ProductEntity;
import com.example.sklep.product.repository.ProductRepository;
import com.example.sklep.user.UserService;
import com.example.sklep.user.requests.CreateUserRequest;
import com.example.sklep.warehouse.WarehouseEntity;
import com.example.sklep.warehouse.WarehouseRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class DatabaseInitializer implements ApplicationListener<ApplicationReadyEvent> {
    private final UserService userService;
    private final ProductRepository productRepository;
    private final WarehouseRepository warehouseRepository;

    public DatabaseInitializer(UserService userService, ProductRepository productRepository, WarehouseRepository warehouseRepository) {
        this.userService = userService;
        this.productRepository = productRepository;
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        userService.create(CreateUserRequest.builder()
                .username("krzysieksr")
                .password("dupa")
                .rePassword("dupa")
                .build());

        createProducts();
    }

    @Transactional
    public void createProducts() {
        List<ProductEntity> productsList = List.of(
                ProductEntity.builder()
                        .name("Samsung S21")
                        .price(new BigDecimal("69"))
                        .productDetailsEntity(ProductDetailsEntity.builder()
                                .description("No w choj fajny telefon")
                                .imagesPaths("/parth/to/samsung/photos")
                                .build())
                        .build(),
                ProductEntity.builder()
                        .name("Pixel 4a")
                        .price(new BigDecimal("274"))
                        .productDetailsEntity(ProductDetailsEntity.builder()
                                .description("Tez fajny")
                                .imagesPaths("/parth/to/pixel/photos")
                                .build())
                        .build(),
                ProductEntity.builder()
                        .name("Ksjomi")
                        .price(new BigDecimal("666"))
                        .productDetailsEntity(ProductDetailsEntity.builder()
                                .description("Ksjajomi lepsze")
                                .imagesPaths("/parth/to/xaomi/photos")
                                .build())
                        .build(),
                ProductEntity.builder()
                        .name("Mtorola")
                        .price(new BigDecimal("1000"))
                        .productDetailsEntity(ProductDetailsEntity.builder()
                                .description("Lepiej zylo sie na Motorolach")
                                .imagesPaths("/parth/to/motorola/photos")
                                .build())
                        .build(),
                ProductEntity.builder()
                        .name("Sony")
                        .price(new BigDecimal("1400"))
                        .productDetailsEntity(ProductDetailsEntity.builder()
                                .description("Sony srony")
                                .imagesPaths("/parth/to/sony/photos")
                                .build())
                        .build(),
                ProductEntity.builder()
                        .name("Redmi")
                        .price(new BigDecimal("700"))
                        .productDetailsEntity(ProductDetailsEntity.builder()
                                .description("Redmi Note")
                                .imagesPaths("/parth/to/redmi/photos")
                                .build())
                        .build()
        );

        List<ProductEntity> productEntitiesList = productRepository.saveAll(productsList);

        Random random = new Random();
        int min = 20;
        int max = 101;
        List<WarehouseEntity> warehouseEntityList = productEntitiesList.stream()
                .map(productEntity -> WarehouseEntity.builder()
                        .productEntity(productEntity)
                        .amount(random.nextInt(max - min) + min)
                        .build())
                .collect(Collectors.toList());

        warehouseRepository.saveAll(warehouseEntityList);
    }
}
