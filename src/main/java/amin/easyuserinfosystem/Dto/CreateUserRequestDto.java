package amin.easyuserinfosystem.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class CreateUserRequestDto {

    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @NotBlank(message = "National ID is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "The phone number must be exactly 10 digits.")
    private String nationalCode;
    @NotBlank(message = "Birthdate is required")
    private PersianDateDto birthDate;
    @NotBlank(message = "Mobile number is required")
    private String mobileNumber;
    @NotBlank(message = "Address is required")
    private String address;
    private String postalCode;
    @Email
    private String email;
    @NotBlank
    @Size(min = 10, max = 10)
    private String password;

    public @NotBlank(message = "First name is required") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "First name is required") String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank(message = "Last name is required") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "Last name is required") String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank(message = "National ID is required") @Pattern(regexp = "^[0-9]{10}$", message = "The phone number must be exactly 10 digits.") String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(@NotBlank(message = "National ID is required") @Pattern(regexp = "^[0-9]{10}$", message = "The phone number must be exactly 10 digits.") String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public @NotBlank(message = "Birthdate is required") PersianDateDto getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@NotBlank(message = "Birthdate is required") PersianDateDto birthDate) {
        this.birthDate = birthDate;
    }

    public @NotBlank(message = "Mobile number is required") String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(@NotBlank(message = "Mobile number is required") String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public @NotBlank(message = "Address is required") String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "Address is required") String address) {
        this.address = address;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @NotBlank @Size(min = 10, max = 10) String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank @Size(min = 10, max = 10) String password) {
        this.password = password;
    }
}