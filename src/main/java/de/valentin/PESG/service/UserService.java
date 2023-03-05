package de.valentin.PESG.service;

import de.valentin.PESG.entity.User;
import de.valentin.PESG.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findByMail(String email){
        return userRepository.findByEmail(email);
    }

    public boolean exists(String email){
        Optional<User> user = userRepository.findByEmail(email);
        System.out.println(email);
        return user.isPresent();
    }

    public boolean exists(int id){
        Optional<User> user = userRepository.findById(id);
        return user.isPresent();
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
