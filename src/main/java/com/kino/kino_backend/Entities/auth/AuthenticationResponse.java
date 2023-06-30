/**

 Represents an authentication response containing a token.
 */
package com.kino.kino_backend.Entities.auth;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    /**
     * The authentication token.
     */
    private String token;
}
