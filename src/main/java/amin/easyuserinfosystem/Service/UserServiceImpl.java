package amin.easyuserinfosystem.Service;

import amin.easyuserinfosystem.BaseClasses.PersianDateConvertor;
import amin.easyuserinfosystem.Dto.CreateUserRequestDto;
import amin.easyuserinfosystem.Dto.CreateUserResponseDto;
import amin.easyuserinfosystem.Entity.User;
import amin.easyuserinfosystem.Repository.UserRepo;
import amin.easyuserinfosystem.Validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserValidation userValidation;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, UserValidation userValidation) {
        this.userRepo = userRepo;
        this.userValidation = userValidation;
    }

    @Override
    public CreateUserResponseDto save(CreateUserRequestDto dto) {

        try {
            User user = new User();

            if (userValidation.nationalCodeValidation(dto))
                throw new RuntimeException("national code is wrong");
            if (userValidation.mobileValidation(dto))
                throw new RuntimeException("mobile number is wrong");
            if (userValidation.passwordValidation(dto))
                throw new RuntimeException("password is wrong");

            user.setFirstName(dto.getFirstName());
            user.setLastName(dto.getLastName());
            user.setNationalCode(dto.getNationalCode());
            user.setBirthDate(PersianDateConvertor.convetToPersianDate(dto.getBirthDate()));
            user.setEmail(dto.getEmail());
            user.setPassword(dto.getPassword());
            user.setAddress(dto.getAddress());
            user.setPostalCode(dto.getPostalCode());
            user.setMobileNumber(dto.getMobileNumber());

            userRepo.save(user);
            return mapToCreateUserResponseDto(user);

        } catch (Exception e) {
            throw new RuntimeException("Error saving user", e);
        }
    }

    @Override
    public CreateUserResponseDto update(Long id, CreateUserRequestDto dto) {

        try {

            User user = userRepo.findById(id)
                    .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));

            if (userValidation.nationalCodeValidation(dto))
                throw new RuntimeException("national code is wrong");
            if (userValidation.mobileValidation(dto))
                throw new RuntimeException("mobile number is wrong");
            if (userValidation.passwordValidation(dto))
                throw new RuntimeException("password is wrong");

            user.setFirstName(dto.getFirstName());
            user.setLastName(dto.getLastName());
            user.setNationalCode(dto.getNationalCode());
            user.setBirthDate(PersianDateConvertor.convetToPersianDate(dto.getBirthDate()));
            user.setEmail(dto.getEmail());
            user.setPassword(dto.getPassword());
            user.setAddress(dto.getAddress());
            user.setPostalCode(dto.getPostalCode());
            user.setMobileNumber(dto.getMobileNumber());
            userRepo.save(user);
            return mapToCreateUserResponseDto(user);
        } catch (Exception e) {
            throw new RuntimeException("Error updating user", e);
        }
    }

    @Override
    public CreateUserResponseDto get(Long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
        return mapToCreateUserResponseDto(user);
    }


    @Override
    public void delete(Long id) {

        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
        userRepo.deleteById(id);
    }

    private CreateUserResponseDto mapToCreateUserResponseDto(User user) {
        CreateUserResponseDto createUserResponseDto = new CreateUserResponseDto();
        createUserResponseDto.setId(user.getId());
        createUserResponseDto.setFirstName(user.getFirstName());
        createUserResponseDto.setLastName(user.getLastName());
        createUserResponseDto.setNationalCode(user.getNationalCode());
        createUserResponseDto.setBirthDate(user.getBirthDate());
        createUserResponseDto.setEmail(user.getEmail());
        createUserResponseDto.setPassword(user.getPassword());
        createUserResponseDto.setAddress(user.getAddress());
        createUserResponseDto.setPostalCode(user.getPostalCode());
        createUserResponseDto.setMobileNumber(user.getMobileNumber());

        return createUserResponseDto;
    }

}