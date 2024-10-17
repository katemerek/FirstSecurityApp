package com.github.katemerek.FirstSecurityApp.mapper;

import com.github.katemerek.FirstSecurityApp.dto.PersonDto;
import com.github.katemerek.FirstSecurityApp.models.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonMapper {
    Person toPerson (PersonDto personDto);
    PersonDto toPersonDto (Person person);
}
