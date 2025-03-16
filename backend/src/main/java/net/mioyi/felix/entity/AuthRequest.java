package net.mioyi.felix.entity;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class AuthRequest {
    public String name;
    public String password;
}
