package de.valentin.PESG.repository;

import de.valentin.PESG.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LinkRepository extends JpaRepository<Link, Integer> {
    List<Link> findByUserId(Integer userId);
}
