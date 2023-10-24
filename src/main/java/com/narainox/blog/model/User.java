package com.narainox.blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Integer id;
    private String email;
    private String password;
    @Column(name="user_name",nullable = false,length=100)
    private String name;
    private String about;

}
