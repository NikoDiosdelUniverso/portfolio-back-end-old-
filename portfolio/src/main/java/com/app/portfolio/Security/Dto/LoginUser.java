
package com.app.portfolio.Security.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LoginUser {
    
    @NotBlank
    private String username;
    private String password;
}
