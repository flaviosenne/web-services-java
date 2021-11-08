package com.hexagonal.architecture.infra.config.entity;

import com.hexagonal.architecture.domain.entity.User;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "tb_user")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cpf_cnpj")
    private String cpfCnpj;

    @Column(name = "created_at")
    private Date createdAt;

    private String name;

    private String email;

    private String password;

    private String phone;

    public static UserEntity toEntity(User user){
        return UserEntity.builder()
                .cpfCnpj(user.getCpfCnpj())
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .phone(user.getPhone())
                .createdAt(new Date())
                .build();
    }

    public static User toUser(UserEntity entity){
        User user = new User();
        user.setCpfCnpj(entity.getCpfCnpj());
        user.setEmail(entity.getEmail());
        user.setName(entity.getName());
        user.setPassword(entity.getPassword());
        user.setPhone(entity.getPhone());
        user.setCreatedAt(entity.getCreatedAt());
        user.setId(entity.getId());

        return user;
    }

}
