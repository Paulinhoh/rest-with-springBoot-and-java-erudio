package paulinhoh.com.github.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paulinhoh.com.github.data.dto.PersonDTO;
import paulinhoh.com.github.exception.ResourceNotFoundException;
import paulinhoh.com.github.model.Person;
import paulinhoh.com.github.repository.PersonRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static paulinhoh.com.github.mapper.ObjectMapper.*;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = LoggerFactory.getLogger(PersonService.class.getName()); // craindo um logger para o service

    @Autowired
    PersonRepository repository;

    public List<PersonDTO> findAll() {
        logger.info("finding all people!");

        return parseListObjects(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        logger.info("finding one person!");

        var entity =  repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));

        return parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {
        logger.info("creating one person!");

        var entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity),  PersonDTO.class);
    }

    public PersonDTO update(PersonDTO person) {
        logger.info("updating one person!");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(repository.save(entity),  PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("deleting one person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));
        repository.delete(entity);
    }
}
