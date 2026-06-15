package service.user_service.controller;

import service.user_service.entity.User;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
        import service.user_service.entity.User;
import service.user_service.repository.UserRepository;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
