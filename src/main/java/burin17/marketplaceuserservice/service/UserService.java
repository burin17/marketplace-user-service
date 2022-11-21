package burin17.marketplaceuserservice.service;

import burin17.marketplaceuserservice.dao.UserRepository;
import burin17.marketplaceuserservice.exception.UserNotFoundException;
import burin17.marketplaceuserservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User userById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    public User createUser(User userData) {
        User newUser = new User();
        setAllField(userData, newUser);
        return userRepository.save(newUser);
    }

    public User updateUser(Long userId, User userData) {
        User fetchedUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        setAllField(userData, fetchedUser);
        userRepository.save(fetchedUser);
        return fetchedUser;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    private void setAllField(User source, User target) {
        target.setEmail(source.getEmail());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setPatronymic(source.getPatronymic());
    }
}
