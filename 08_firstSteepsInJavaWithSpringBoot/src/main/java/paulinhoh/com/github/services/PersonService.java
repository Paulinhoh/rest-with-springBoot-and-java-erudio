package paulinhoh.com.github.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paulinhoh.com.github.exception.ResourceNotFoundException;
import paulinhoh.com.github.model.Person;
import paulinhoh.com.github.repository.PersonRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = LoggerFactory.getLogger(PersonService.class.getName()); // craindo um logger para o service

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        logger.info("finding all people!");

        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("finding one person!");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));
    }

    public Person create(Person person) {
        logger.info("creating one person!");

        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("updating one person!");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id) {
        logger.info("deleting one person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));
        repository.delete(entity);
    }
}
