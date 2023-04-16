package br.com.aircnc.aircnc.repositories;

import br.com.aircnc.aircnc.entities.Spot;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SpotRepository extends MongoRepository<Spot, String> {

}
