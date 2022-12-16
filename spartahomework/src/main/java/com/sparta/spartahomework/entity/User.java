package com.sparta.spartahomework.entity;

import jdk.dynalink.linker.LinkerServices;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "[a-z0-9]{4,10}", message = "사용자 이름은 알파벳 소문자, 숫자로 구성한 4~10자 사이로 입력해주세요.")
    private String username;

    @Column(nullable = false)
    @Pattern(regexp = "[a-zA-Z0-9]{8,15}", message = "비밀번호는 알파벳 대소문자, 숫자로 구성한 8~15자 사이로 입력해주세요.")
    private String password;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    @OneToMany
    List<Post> posts = new ArrayList<>();

    public User(String username, String password, UserRoleEnum role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
