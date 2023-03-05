package de.valentin.PESG.controller;

import de.valentin.PESG.config.JwtService;
import de.valentin.PESG.entity.Link;
import de.valentin.PESG.repository.LinkRepository;
import de.valentin.PESG.service.GeneralService;
import de.valentin.PESG.service.LinkService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private GeneralService generalService;

    @PostMapping("/upload")
    public Link sendLink(@RequestBody String linkString, HttpServletRequest request){
        String email = generalService.getEmailFromRequest(request);
        return linkService.sendLink(linkString, email);
    }

    @GetMapping("/getall")
    public List<String> getAllLinks(){
        return linkService.getAllLinks();
    }

}