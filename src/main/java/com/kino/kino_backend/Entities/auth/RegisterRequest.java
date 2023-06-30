
/**

 Represents a registration request with user information.
 */
package com.kino.kino_backend.Entities.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    /**
     * The email of the user.
     */
    private String email;
    /**
     * The name of the user.
     */
    private String name;
    /**
     * The surname of the user.
     */
    private String surname;
    /**
     * The password of the user.
     */
    private String password;
}
