package kz.bidify.authservice.repository;

import kz.bidify.authservice.model.entity.AppUser;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepository extends MongoRepository<AppUser, ObjectId> {

    List<AppUser> findAllByEmailOrUsername(String email, String username);

    Optional<AppUser> findAppUserByUsername(String username);
}
