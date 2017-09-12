package edu.berliner.memegenerator.repositories;

import edu.berliner.memegenerator.models.Meme;
import org.springframework.data.repository.CrudRepository;

public interface MemeRepository extends CrudRepository<Meme,Long>
{
}
