package org.buy.loginservice.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class LoginResponse {

    private boolean success;
    private String message;
    private String token;
}
