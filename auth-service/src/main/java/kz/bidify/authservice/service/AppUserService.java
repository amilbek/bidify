package kz.bidify.authservice.service;

import kz.bidify.authservice.model.entity.AppUser;


public interface AppUserService {

    AppUser getAppUser();

    AppUser save(AppUser appUser);

    boolean existsByEmailOrUsername(String email, String username);
}
