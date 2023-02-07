package org.example.services;

import org.example.exceptions.InvalidUserId;
import org.example.models.User;

import java.util.Map;
import java.util.TreeMap;

public class UserService {
    private Map<String, User> users;

    public UserService() {
        this.users = new TreeMap<>();
    }

    public void addUser(User user) {
        users.putIfAbsent(user.getUserId(), user);
    }

    public boolean validateUserId(String userId) {
        if(!users.containsKey(userId)) {
            throw new InvalidUserId("User with userId: " + userId + " does not exists", null);
        }
        return true;
    }
}
