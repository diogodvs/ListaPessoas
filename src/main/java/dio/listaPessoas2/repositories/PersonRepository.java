package dio.listaPessoas2.repositories;

import dio.listaPessoas2.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{
}
