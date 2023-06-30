/**

 The JwtService class provides utility methods for handling JSON Web Tokens (JWT).
 It can generate a JWT, extract claims from a JWT, validate a JWT, and extract the email from a JWT.
 */
package com.kino.kino_backend.Configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY =
            "5971337436773979244226452948404D635166546A576E5A7234753778214125";

    /**
     * Extracts the email from a JWT.
     *
     * @param jwt The JWT string.
     * @return The email extracted from the JWT.
     */
    public String extractEmail(String jwt) {
        return extractClaim(jwt, Claims::getSubject);
    }

    /**
     * Extracts a claim from a JWT using the specified claims resolver function.
     *
     * @param token          The JWT string.
     * @param claimsResolver The claims resolver function.
     * @param <T>            The type of the claim.
     * @return The claim value extracted from the JWT.
     */
    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Generates a JWT for the specified user details.
     *
     * @param userDetails The user details.
     * @return The generated JWT.
     */
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }


    /**
     * Generates a JWT with additional claims for the specified user details.
     *
     * @param extraClaims   Additional claims to be included in the JWT.
     * @param userDetails  The user details.
     * @return The generated JWT.
     */
    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
            ) {
        return Jwts.builder().setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Checks if a JWT is valid for the specified user details.
     *
     * @param token       The JWT string.
     * @param userDetails The user details.
     * @return true if the JWT is valid, false otherwise.
     */
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String email = extractEmail(token);
        return (email.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


    /**

     Checks if a JWT is expired.
     @param token The JWT string.
     @return true if the JWT is expired, false otherwise.
     */
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }


    /**

     Extracts the expiration date from a JWT.
     @param token The JWT string.
     @return The expiration date extracted from the JWT.
     */
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }


    /**

     Extracts all claims from a JWT.
     @param token The JWT string.
     @return The claims extracted from the JWT.
     */
    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    /**

     Retrieves the signing key used to verify the JWT signature.
     @return The signing key.
     */
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
