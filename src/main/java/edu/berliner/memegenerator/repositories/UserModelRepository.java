package edu.berliner.memegenerator.repositories;

import edu.berliner.memegenerator.models.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserModelRepository extends CrudRepository<UserModel,Long>
{
}
