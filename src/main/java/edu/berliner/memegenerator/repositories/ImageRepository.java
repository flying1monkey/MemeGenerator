package edu.berliner.memegenerator.repositories;

import edu.berliner.memegenerator.models.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image,Long>
{

}
