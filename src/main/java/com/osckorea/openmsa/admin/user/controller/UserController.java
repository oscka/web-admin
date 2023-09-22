package com.osckorea.openmsa.admin.user.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.osckorea.openmsa.admin.user.dto.UserDto;
import com.osckorea.openmsa.admin.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "사용자 CRUD API")
@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(summary = "특정 사용자 정보 검색")
    @GetMapping("admin/user/{userId}")
    public void findUserById(@PathVariable("userId") String userId) {
        this.userService.getUserById(userId);
    }

    @Operation(summary = "사용자 계정 정보 생성")
    @PostMapping("admim/user")
    public void createUserAccount(@RequestBody UserDto.Save data) {
        this.userService.saveUser(data);
    }

    @Operation(summary = "사용자 계정 정보 갱신")
    @PutMapping("admin/user/{userId}")
    public void modifyUserAccount(@PathVariable("userId") String userId, @RequestBody UserDto.Update data) {
        this.userService.updateUser(userId, data);
    }

    @Operation(summary = "특정 사용자 정보 삭제")
    @DeleteMapping("admin/user/{userId}")
    public void removeUserById(@PathVariable("userId") String userId) {
        this.userService.deleteUser(userId);
    }
}
