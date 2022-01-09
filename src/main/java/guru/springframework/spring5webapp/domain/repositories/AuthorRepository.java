package guru.springframework.spring5webapp.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import guru.springframework.spring5webapp.domain.Author;

/**
*	Created by muhamedsuhail on 09-Jan-2022
*/

public interface AuthorRepository extends CrudRepository<Author,Long>{

}
