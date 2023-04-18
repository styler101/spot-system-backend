package br.com.aircnc.aircnc.services;

import br.com.aircnc.aircnc.dtos.SpotDTO;
import br.com.aircnc.aircnc.entities.Spot;
import br.com.aircnc.aircnc.entities.User;
import br.com.aircnc.aircnc.repositories.SpotRepository;
import br.com.aircnc.aircnc.repositories.UserRepository;
import br.com.aircnc.aircnc.services.exceptions.InvalidParam;
import br.com.aircnc.aircnc.utils.Formatters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpotService {
    @Autowired
    private SpotRepository repository;

    @Autowired
    private UserRepository userRepository;


    public SpotDTO insert(SpotDTO dto){
        Spot spot = new Spot();
        Optional<User> user = userRepository.findByMongoId(dto.getUser().getId());
        user.orElseThrow(() -> new InvalidParam("Does not exists any user with this id " + dto.getId()));
        parseDTOtoEntity(dto, spot);
        System.out.println(dto.toString());
        System.out.println(spot.toString());
        spot = repository.save(spot);
        return parseEntityToDTO(spot);
    }
    @Transactional(readOnly = true)
    public List<SpotDTO> findAll(){
        List<Spot> spots = repository.findAll();

        List<SpotDTO> dtos = spots.stream().map(x -> new SpotDTO(
                x.getId(),
                x.getCompany(),
                x.getPrice(),
                x.getThumbnail(),
                Formatters.parseStringToArrayString(x.getTechs()),
                 x.getUser())).toList();


        return dtos;
    }

    private void parseDTOtoEntity(SpotDTO dto, Spot entity){
        entity.setCompany(dto.getCompany());
        entity.setPrice(dto.getPrice());
        entity.setTechs(Formatters.parseArrayStringToString(dto.getTechs()));
        entity.setThumbnail(dto.getThumbnail());
        entity.setUser(dto.getUser());
    }
    private SpotDTO parseEntityToDTO(Spot spot){
        return new SpotDTO(spot.getId(), spot.getCompany(), spot.getPrice(), spot.getThumbnail(),spot.getTechs().split(","), spot.getUser());
    }





}
