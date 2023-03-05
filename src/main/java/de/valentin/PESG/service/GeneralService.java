package de.valentin.PESG.service;


import de.valentin.PESG.config.JwtService;
import de.valentin.PESG.entity.Link;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GeneralService {

    @Autowired
    private JwtService jwtService;

    public String getJwtFromRequest(HttpServletRequest request){
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;

        jwt = authHeader.substring(7);
        return jwt;
    }

    public String getEmailFromRequest(HttpServletRequest request){
        return jwtService.extractUsername(getJwtFromRequest(request));
    }

}
