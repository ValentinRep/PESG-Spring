package de.valentin.PESG.service;

import de.valentin.PESG.entity.User;
import de.valentin.PESG.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public User changePassword(Integer id, String newPassword) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            return userRepository.save(user);
        }
        return null;
    }
}
