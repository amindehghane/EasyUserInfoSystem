package amin.easyuserinfosystem.Controller;

import amin.easyuserinfosystem.Dto.CreateUserRequestDto;
import amin.easyuserinfosystem.Dto.CreateUserResponseDto;
import amin.easyuserinfosystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/apis")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public CreateUserResponseDto create(@RequestBody CreateUserRequestDto createUserRequestDto) {
        return userService.save(createUserRequestDto);
    }

    @PutMapping("/{id}")
    public CreateUserResponseDto update(@PathVariable Long id, @RequestBody CreateUserRequestDto createUserRequestDto) {
        return userService.update(id, createUserRequestDto);
    }

    @GetMapping("/{id}")
    public CreateUserResponseDto get(@PathVariable Long id) {
        return userService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
