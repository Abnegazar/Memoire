package com.memoire.wohaya.security;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginView {
    private String telephone;
    private String pwd;
}
