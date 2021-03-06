package travelcompany.user.repo.impl.memory;

import travelcompany.common.business.search.Paginator;
import travelcompany.storage.SequenceGenerator;
import travelcompany.user.domain.User;
import travelcompany.user.repo.UserRepo;
import travelcompany.user.repo.impl.UserSortingComponent;
import travelcompany.user.search.UserSearchCondition;

import java.util.*;

import static travelcompany.common.solutions.utils.CollectionUtils.getPageableData;
import static travelcompany.storage.Storage.usersArray;
import static travelcompany.storage.Storage.usersList;

public class UserCollectionRepo implements UserRepo {
    private UserSortingComponent sortingComponent = new UserSortingComponent();

    @Override
    public User insert(User user) {
        usersList.add(user);
        user.setId(SequenceGenerator.getNextValue());

        return user;
    }

    @Override
    public void insert(Collection<User> users) {
        for (User user : users) {
            insert(user);
        }
    }

    @Override
    public void update(User user) {}

    @Override
    public Optional<User> findById(Long id) {
        return findUserById(id);
    }

    @Override
    public List<? extends User> search(UserSearchCondition searchCondition) {
        List<? extends User> result = doSearch(searchCondition);
        boolean needSorting = !result.isEmpty() && searchCondition.needSorting();
        boolean shouldPaginate = !result.isEmpty() && searchCondition.shouldPaginate();

        if (needSorting) {
            sortingComponent.applySorting(result, searchCondition);
        }

        if (shouldPaginate) {
            result = getPageableUserData(result, searchCondition.getPaginator());
        }

        return result;
    }

    private List<? extends User> getPageableUserData(List<? extends User> result, Paginator paginator) {
        return getPageableData(result, paginator.getLimit(), paginator.getOffset());
    }

    private List<? extends User> doSearch(UserSearchCondition searchCondition) {
        List<User> result = new ArrayList<>();

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
                    result.add(user);
                }
            }
        }

        return result;
    }

    @Override
    public void deleteById(Long id) {
        findUserById(id).map(user -> usersList.remove(user));
    }

    @Override
    public void printAll() {
        for (User user : usersList) {
            System.out.println(user);
        }
    }

    private Optional<User> findUserById(long id) {
        return usersList.stream().filter(user -> Long.valueOf(id).equals(user.getId())).findAny();
    }

    @Override
    public List<User> findAll() {
        return usersList;
    }

    @Override
    public int countAll() {
        return usersList.size();
    }
}
