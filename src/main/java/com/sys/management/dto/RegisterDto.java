package com.sys.management.dto;

import com.sys.management.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {
    public String fullName;
    public String username;
    public String email;
    public String password;
    public String phone;
    public String address;
    public String gender;
    public Role role;
}
