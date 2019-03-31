package travelcompany.user.service.impl;

import travelcompany.order.service.OrderService;
import travelcompany.user.domain.User;
import travelcompany.user.repo.UserRepo;
import travelcompany.user.search.UserSearchCondition;
import travelcompany.user.service.UserService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserDefaultService implements UserService {
    private final UserRepo userRepo;
    private final OrderService orderService;

    public UserDefaultService(UserRepo userRepo, OrderService orderService) {
        this.userRepo = userRepo;
        this.orderService = orderService;
    }

    @Override
    public User insert(User user) {
        if (user != null) {
            userRepo.insert(user);
        }

        return user;
    }

    @Override
    public void insert(Collection<User> users) {
        if (users != null && !users.isEmpty()) {
            userRepo.insert(users);
        }
    }

    @Override
    public User findById(Long id) {
        if (id != null) {
            return userRepo.findById(id);
        }

        return null;
    }

    @Override
    public void delete(User user) {
        if (user != null) {
            deleteById(user.getId());
        }
    }

    @Override
    public List<? extends User> search(UserSearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            return userRepo.search(searchCondition);
        }
    }

    @Override
    public void update(User user) {
        if (user.getId() != null) {
            userRepo.update(user);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id != null) {
            userRepo.deleteById(id);
        }
    }

    @Override
    public void printAll() {
        userRepo.printAll();
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public int countAll() {
        return userRepo.countAll();
    }
}
