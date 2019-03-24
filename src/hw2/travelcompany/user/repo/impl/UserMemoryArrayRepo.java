package hw2.travelcompany.user.repo.impl;

import hw2.travelcompany.common.solutions.utils.ArrayUtils;
import hw2.travelcompany.storage.SequenceGenerator;
import hw2.travelcompany.user.domain.User;
import hw2.travelcompany.user.repo.UserRepo;
import hw2.travelcompany.user.search.UserSearchCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static hw2.travelcompany.storage.Storage.usersArray;

public class UserMemoryArrayRepo implements UserRepo {

    private int userIndex = 0;
    private UserSortingComponent sortingComponent = new UserSortingComponent();


    @Override
    public void insert(User user) {
        if (userIndex == usersArray.length) {
            User[] newUsers = new User[usersArray.length * 2];
            System.arraycopy(usersArray, 0, newUsers, 0, usersArray.length);
            usersArray = newUsers;
        }
        usersArray[userIndex] = user;
        user.setId(SequenceGenerator.getNextValue());
        userIndex++;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User findById(Long id) {
        Integer userIndex = findUserIndexById(id);
        if (userIndex != null) {
            return usersArray[userIndex];
        }
        return null;
    }

    @Override
    public List<? extends User> search(UserSearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            List<? extends User> result = doSearch(searchCondition);
            boolean needSorting = !result.isEmpty() && searchCondition.needSorting();

            if (needSorting) {
                sortingComponent.applySorting(result, searchCondition);
            }
            return result;
        }
    }

    private List<? extends User> doSearch(UserSearchCondition searchCondition) {
        User[] result = new User[usersArray.length];
        int resultIndex = 0;

        for (User user : usersArray) {
            if (user != null) {
                boolean found = true;

                if (searchCondition.searchByFirstName()) {
                    found = searchCondition.getFirstName().equals(user.getFirstName());
                }
                if (found && searchCondition.searchByLastName()) {
                    found = searchCondition.getLastName().equals(user.getLastName());
                }
                if (found && searchCondition.searchByPassport()) {
                    found = searchCondition.getPassport().equals(user.getPassport());
                }
                if (found && searchCondition.searchByClientType()) {
                    found = searchCondition.getClientType().equals(user.getClientType());
                }
                if (found && searchCondition.searchByOrder()) {
                    found = searchCondition.getOrder().equals(user.getClientType());
                }
                if (found) {
                    result[resultIndex] = user;
                    resultIndex++;
                }
            }
        }
        if (resultIndex > 0) {
            User[] toReturn = new User[resultIndex];
            System.arraycopy(result, 0, toReturn, 0, resultIndex);
            return new ArrayList<>(Arrays.asList(toReturn));
        }
        return Collections.emptyList();
    }

    @Override
    public void deleteById(Long id) {
        Integer userIndex = findUserIndexById(id);

        if (userIndex != null) {
            deleteUserByIndex(userIndex);
        }
    }

    private void deleteUserByIndex(Integer userIndex) {
        ArrayUtils.removeElement(usersArray, userIndex);
        userIndex--;
    }

    @Override
    public void printAll() {
        for (User user : usersArray) {
            System.out.println(user);
        }
    }

    private Integer findUserIndexById(Long id) {
        for (int i = 0; i < usersArray.length; i++) {
            if (usersArray[i].getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return Arrays.asList(usersArray);
    }

}
