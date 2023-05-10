package com.Mobile.SpringBootMobileShop.service.Impl;

import com.Mobile.SpringBootMobileShop.model.Login;
import com.Mobile.SpringBootMobileShop.model.User;
import com.Mobile.SpringBootMobileShop.repository.LoginRepository;
import com.Mobile.SpringBootMobileShop.repository.UserRepository;
import com.Mobile.SpringBootMobileShop.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private LoginRepository loginRepository;

    public UserServiceImpl(UserRepository userRepository, LoginRepository loginRepository) {
        this.userRepository = userRepository;
        this.loginRepository = loginRepository;
    }

    @Override
    public User registerUser(User user) {
        String email =user.getEmail();
        String password =  user.getPassword();
        Login login = new Login();
        login.setEmail(email);
        login.setPassword(password);
        login.setRole("User");
        loginRepository.save(login);
        return userRepository.save(user);

    }
}
