package de.valentin.PESG.controller;

import de.valentin.PESG.entity.Link;
import de.valentin.PESG.repository.LinkRepository;
import de.valentin.PESG.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @PostMapping("/upload")
    public Link sendLink(@RequestBody String linkString) {
        return linkService.sendLink(linkString);
    }

    @GetMapping("/getall")
    public List<String> getAllLinks(){
        return linkService.getAllLinks();
    }

}