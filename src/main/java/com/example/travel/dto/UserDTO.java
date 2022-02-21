package com.example.travel.dto;

import com.example.travel.entity.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Column;
import java.beans.ConstructorProperties;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private int id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fullName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phone;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String address;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String username;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean active;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Role role;

    public UserDTO(int id) {
        this.id = id;
    }
}
