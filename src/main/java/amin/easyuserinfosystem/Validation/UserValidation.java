package amin.easyuserinfosystem.Validation;

import amin.easyuserinfosystem.Dto.CreateUserRequestDto;
import org.springframework.stereotype.Component;

@Component
public class UserValidation {

    public boolean nationalCodeValidation(CreateUserRequestDto requestDto) {

        if (requestDto.getNationalCode() == null || requestDto.getNationalCode().length() != 10) {
            return false;
        }
        Long change = Long.parseLong(requestDto.getNationalCode());
        Long[] arrayCod = new Long[requestDto.getNationalCode().length()];
        for (int i = arrayCod.length - 1; i >= 0; i--) {
            arrayCod[i] = change % 10;
            change /= 10;
        }
        long controlNumber = arrayCod[arrayCod.length - 1];
        long sum = 0;
        for (int i = 0; i < arrayCod.length - 1; i++) {
            sum += arrayCod[i] * (10 - 1);
        }
        sum %= 11;
        if (sum <= 2) {
            return controlNumber == sum;
        } else if (sum > 2)
            return 11 - sum == controlNumber;
        else return false;

    }

    public boolean mobileValidation(CreateUserRequestDto requestDto) {

        return (requestDto.getMobileNumber() == null ||
                requestDto.getMobileNumber().length() != 11 ||
                requestDto.getMobileNumber().charAt(0) != '0' ||
                requestDto.getMobileNumber().charAt(1) != '9');

    }

    public boolean passwordValidation(CreateUserRequestDto requestDto) {
        return (requestDto.getPassword() == null && requestDto.getPassword().length() != 8);
    }

}