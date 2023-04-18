package br.com.aircnc.aircnc.repositories;

import br.com.aircnc.aircnc.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    @Query("{ 'email' : email }")
    public User findByEmail(String email);

    @Query("{_id: ?0}")
    public Optional<User> findByMongoId(String id);

}
