package com.feedRss.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest req,
                         ServletResponse res,
                         final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me, token");

        final String authHeader = request.getHeader("token");
        if (authHeader == null) {
            throw new ServletException("Missing or invalid Authorization header.");
        }

        final String token = authHeader;

        try {
            final Claims claims = Jwts.parser().setSigningKey("secretkey")
                .parseClaimsJws(token).getBody();
            request.setAttribute("claims", claims);
        }
        catch (final SignatureException e) {
            throw new ServletException("Invalid token.");
        }

        chain.doFilter(req, res);
    }

}
