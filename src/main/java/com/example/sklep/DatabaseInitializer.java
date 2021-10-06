package com.example.sklep;

import com.example.sklep.user.requests.CreateUserRequest;
import com.example.sklep.user.UserService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements ApplicationListener<ApplicationReadyEvent> {
    private final UserService userService;

    public DatabaseInitializer(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        userService.create(CreateUserRequest.builder()
                .username("krzysieksr")
                .password("dupa")
                .rePassword("dupa")
                .build());
    }
}
