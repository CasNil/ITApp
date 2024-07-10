package se.lexicon.model;

import java.util.Collection;

public interface AppUserDAO {
    AppUser persist(String appUser);

    AppUser findByUsername(String username);

    Collection<AppUser> findAll();

    void remove(String username);
}
