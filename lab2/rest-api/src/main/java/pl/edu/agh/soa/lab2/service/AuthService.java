package pl.edu.agh.soa.lab2.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pl.edu.agh.soa.lab2.auth.KeyGen;
import pl.edu.agh.soa.lab2.auth.KeyGenerator;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.*;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Path("/auth")
@Api(value = "Authentication API")
public class AuthService {

    @Inject
    private KeyGenerator keyGenerator;

    @Context
    private UriInfo uriInfo;

    @POST
    @Path("login")
    @ApiOperation("Returns new token")
    @ApiResponses({
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 200, message = "Token generated")
    })
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_JSON})
    public Response authenticateUser(@FormParam("login") String login,
                                     @FormParam("password") String password) {
        try {
            String token = null;

            boolean isValid = authenticate(login, password);

            if (isValid)
                token = issueToken(login);

            if (token != null) {
                return Response
                        .ok()
                        .header(HttpHeaders.AUTHORIZATION, "token " + token)
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                        .build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                        .build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                    .build();
        }
    }

    private boolean authenticate(String login, String password) throws SecurityException {
        if ("user".equals(login) && "user".equals(password)) {
            return true;
        } else {
            throw new SecurityException("Invalid user/password");
        }
    }

    private String issueToken(String login) {
        keyGenerator = new KeyGen();
        Key key = keyGenerator.generateKey();
        String jwtToken = Jwts.builder()
                .setSubject(login)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        return jwtToken;
    }

    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

}
