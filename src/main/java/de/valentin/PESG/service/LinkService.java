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

    public Link sendLink(String linkString) {
        Link link = new Link();
        link.setLink(linkString);
        link.setTimestamp(LocalDateTime.now());
        return linkRepository.save(link);
    }

    public List<String> getAllLinks(){
        return linkRepository.findAll().stream().map(Link::getLink).collect(Collectors.toList());
    }
}
