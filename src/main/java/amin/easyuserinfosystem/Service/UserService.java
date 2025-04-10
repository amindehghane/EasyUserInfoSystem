package amin.easyuserinfosystem.Service;

import amin.easyuserinfosystem.Dto.CreateUserRequestDto;
import amin.easyuserinfosystem.Dto.CreateUserResponseDto;

public interface UserService {

    CreateUserResponseDto save(CreateUserRequestDto createUserRequestDto);

    CreateUserResponseDto update(Long id, CreateUserRequestDto createUserRequestDto);

    CreateUserResponseDto get(Long id);

    void delete(Long id);


}
