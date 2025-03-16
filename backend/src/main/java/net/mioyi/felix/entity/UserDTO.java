package net.mioyi.felix.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String description;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.description = user.getDescription();
    }
}
