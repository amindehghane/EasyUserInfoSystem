package amin.easyuserinfosystem.BaseClasses;

import amin.easyuserinfosystem.Dto.PersianDateDto;

import java.time.LocalDate;

public class PersianDateConvertor {

    public static LocalDate convetToPersianDate(PersianDateDto persianDateDto) {

        LocalDate localDate = LocalDate.of(persianDateDto.getYear(), persianDateDto.getMonth(), persianDateDto.getDay());

        return localDate;

    }

    public static PersianDateDto convetToPersianDateDto(LocalDate localDate) {
        PersianDateDto persianDateDto = new PersianDateDto();
        persianDateDto.setYear(localDate.getYear());
        persianDateDto.setMonth(localDate.getMonthValue());
        persianDateDto.setDay(localDate.getDayOfMonth());
        return persianDateDto;
    }
}