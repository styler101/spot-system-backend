package br.com.aircnc.aircnc.services;

import br.com.aircnc.aircnc.dtos.UserDTO;
import br.com.aircnc.aircnc.entities.User;
import br.com.aircnc.aircnc.repositories.UserRepository;
import br.com.aircnc.aircnc.services.exceptions.InvalidParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDTO create(UserDTO dto) {
        try {
            User user = new User();
            User userAlreadyExists = repository.findByEmail(dto.getEmail());
            if(userAlreadyExists != null){
                throw new InvalidParam("This email is already taken");
            }
            user.setEmail(dto.getEmail());
            user = repository.save(user);
            return new UserDTO(user);

        } catch (IncorrectResultSizeDataAccessException e) {
            throw new InvalidParam("Invalid Query");
        }
    }
}
