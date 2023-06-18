package kz.bidify.authservice.service;

import kz.bidify.authservice.model.dto.AppUserCreateDTO;
import kz.bidify.authservice.model.dto.AppUserDTO;
import org.springframework.stereotype.Service;


@Service
public interface AppUserService {

    AppUserDTO getAppUser();
}
