package br.com.aircnc.aircnc.services;

import br.com.aircnc.aircnc.dtos.SpotDTO;
import br.com.aircnc.aircnc.entities.Spot;
import br.com.aircnc.aircnc.entities.User;
import br.com.aircnc.aircnc.repositories.SpotRepository;
import br.com.aircnc.aircnc.repositories.UserRepository;
import br.com.aircnc.aircnc.services.exceptions.InvalidParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpotService {
    @Autowired
    private SpotRepository repository;

    @Autowired
    private UserRepository userRepository;


    public SpotDTO insert(SpotDTO dto){
        Spot spot = new Spot();
        System.out.println("USER" + dto.getUser().toString());
        Optional<User> user = userRepository.findByMongoId(dto.getUser().getId());
        user.orElseThrow(() -> new InvalidParam("Does not exists any user with this id " + dto.getId()));
        parseDTOtoEntity(dto, spot);
        spot = repository.save(spot);
        return parseEntityToDTO(spot);
    }

    private void parseDTOtoEntity(SpotDTO dto, Spot entity){
        entity.setCompany(dto.getCompany());
        entity.setPrice(dto.getPrice());
        entity.setTechs(dto.getTechs());
        entity.setThumbnail(dto.getThumbnail());
        entity.setUser(dto.getUser());
    }

    private SpotDTO parseEntityToDTO(Spot spot){
        return new SpotDTO(spot.getId(), spot.getCompany(), spot.getPrice(), spot.getThumbnail(), spot.getTechs(), spot.getUser());
    }
}
