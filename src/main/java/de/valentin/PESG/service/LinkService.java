package de.valentin.PESG.service;

import de.valentin.PESG.entity.Link;
import de.valentin.PESG.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private UserService userService;

    public Link sendLink(String linkString, String email) {
        Link link = Link.builder()
                        .link(linkString).user(userService.findByMail(email).get()).timestamp(LocalDateTime.now()).build();
        return linkRepository.save(link);
    }

    public List<String> getAllLinks(){
        return linkRepository.findAll().stream().map(Link::getLink).collect(Collectors.toList());
    }
}
