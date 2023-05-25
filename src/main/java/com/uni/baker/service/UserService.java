package com.uni.baker.service;



import com.uni.baker.entity.Category;
import com.uni.baker.entity.User;
import com.uni.baker.repository.IUserRepository;
import com.uni.baker.utils.SlugUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    public List<User> getAllUser()
    {
        return userRepository.findAll();
    }
    public User getUserById(Long id)
    {
        return userRepository.findById(id).orElse(null);
    }
    public User save(User user)
    {
        return userRepository.save(user);
    }

    public void addUser(User user)
    {
        String slug = SlugUtils.createSlug(user.getName());
        save(user);
    }
    public void deleteUser(Long id)
    {
        userRepository.deleteById(id);
    }
    public void updateUser(User user)
    {
        save(user);
    }

}
