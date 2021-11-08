package com.hexagonal.architecture.app.dtos;

import com.hexagonal.architecture.domain.entity.User;
import com.hexagonal.architecture.infra.config.entity.UserEntity;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String cpfCnpj;

    public User toUser(UserDto dto) {

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());
        user.setCpfCnpj(dto.getCpfCnpj());
        user.setCreatedAt(new Date());

        return user;
    }
}
