package com.osckorea.openmsa.admin.user.service;

import org.springframework.stereotype.Service;
import com.osckorea.openmsa.admin.user.dto.UserDto;
import com.osckorea.openmsa.admin.user.repository.UserRepository;
import com.osckorea.openmsa.global.exception.Exception400;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto.Response getUserById(String userId) {
        return this.userRepository.findById(userId).orElseThrow(() -> new Exception400(userId, "Not Exist User")).toDto();
    }

    public UserDto.Response saveUser(UserDto.Save dto) {
        return this.userRepository.save(dto.toEntity()).toDto();
    }

    public UserDto.Response updateUser(String userId, UserDto.Update dto) {
        return this.userRepository.updateById(dto.toEntity(userId)).toDto();
    }

    public void deleteUser(String userId) {
        this.userRepository.deleteById(userId);
    }
}
