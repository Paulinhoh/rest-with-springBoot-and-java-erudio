package paulinhoh.com.github.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import paulinhoh.com.github.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
