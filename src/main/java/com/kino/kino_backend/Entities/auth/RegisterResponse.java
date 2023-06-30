/**

 Represents a registration response containing a token.
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
public class RegisterResponse {
    /**
     * The registration token.
     */
    private String token;
}
