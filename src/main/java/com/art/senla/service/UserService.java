package com.art.senla.service;

import com.art.senla.service.dto.UserDto;
import lombok.Data;

import java.util.List;

@Data
public interface UserService {

    List<UserDto> getAll();

    UserDto getById(Long id);

    UserDto add(UserDto userDto);

    UserDto update(UserDto userDto);

    void delete(Long id);
}
