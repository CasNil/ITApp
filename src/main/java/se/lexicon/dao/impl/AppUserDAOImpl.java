package se.lexicon.dao.impl;

import se.lexicon.dao.AppUserDAO;
import se.lexicon.model.AppUser;

import java.util.ArrayList;
import java.util.List;

public class AppUserDAOImpl implements AppUserDAO {
    private final List<AppUser> appUsers;

    private static AppUserDAOImpl instance;

    private AppUserDAOImpl() {
        appUsers = new ArrayList<>();
    }

    @Override
    public AppUser persist(AppUser appUser) {
        if (findByUsername(appUser.getUsername()) != null) {
            throw new IllegalArgumentException("Username " + appUser.getUsername() + " already exists");
        }
        if (!appUsers.contains(appUser)) {
            appUsers.add(appUser);
        }
        return null;
    }

    @Override
    public AppUser findByUsername(String username) {
        for (AppUser appUser : appUsers) {
            if (appUser.getUsername().equals(username)) {
                return appUser;
            }
        }
        return null;
    }

    @Override
    public List<AppUser> findAll() {
        return new ArrayList<>(appUsers);
    }

    @Override
    public void remove(String username) {
        AppUser appUser = findByUsername(username);
        if (appUser != null) {
            appUsers.remove(appUser);
        }
    }
}
