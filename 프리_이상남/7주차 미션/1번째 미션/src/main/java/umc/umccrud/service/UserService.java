package umc.umccrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import umc.umccrud.domain.User;
import umc.umccrud.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(String subject) {
        User user = new User(subject);
        userRepository.save(user);
    }

    public User update(Long id, String subject) {
        User findUser = userRepository.findById(id).get();
        findUser.setSubject(subject);
        userRepository.save(findUser);
        return findUser;
    }

    public String delete(String subject) {
        User deleteUser = userRepository.findBySubject(subject);
        userRepository.delete(deleteUser);
        return "bye";


    }
}
