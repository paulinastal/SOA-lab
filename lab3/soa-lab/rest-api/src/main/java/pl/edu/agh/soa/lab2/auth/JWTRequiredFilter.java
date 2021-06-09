package pl.edu.agh.soa.lab2.auth;

import io.jsonwebtoken.Jwts;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.security.Key;

@Provider
@JWTRequired
@Priority(Priorities.AUTHENTICATION)
public class JWTRequiredFilter implements ContainerRequestFilter {

    @Inject
    private KeyGenerator keyGenerator;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) {

        try {
            String authorizationHeader = containerRequestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
            authorizationHeader = authorizationHeader.replace("Bearer", "").replaceAll("\\s","");

            String token = authorizationHeader.substring("token".length()).trim();

            Key key = keyGenerator.generateKey();
            Jwts.parser().setSigningKey(key).parseClaimsJws(token);
        } catch (Exception e) {
            containerRequestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }

    }
}
