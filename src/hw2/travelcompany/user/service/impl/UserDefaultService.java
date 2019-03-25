package hw2.travelcompany.user.service.impl;

import hw2.travelcompany.order.service.OrderService;
import hw2.travelcompany.user.domain.User;
import hw2.travelcompany.user.repo.UserRepo;
import hw2.travelcompany.user.search.UserSearchCondition;
import hw2.travelcompany.user.service.UserService;

import java.util.List;

public class UserDefaultService implements UserService {

    private final UserRepo userRepo;
    private final OrderService orderService;

    public UserDefaultService(UserRepo userRepo, OrderService orderService) {
        this.userRepo = userRepo;
        this.orderService = orderService;
    }

    @Override
    public void insert(User user) {
        if (user != null) {
            userRepo.insert(user);
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
            this.deleteById(user.getId());
        }
    }

    @Override
    public List<? extends User> search(UserSearchCondition searchCondition) {
        return userRepo.search(searchCondition);
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
}