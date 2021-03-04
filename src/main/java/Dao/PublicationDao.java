package Dao;

import java.util.List;

import Entities.Association;
import Entities.Publication;

public interface PublicationDao {
	int createPub(Publication p);
	int updatePub(Publication p);
	int deletePub(long id);
	Publication findById(long id);
	List<Publication> findByAssociation(Association assoc);
	List<Publication> findAll(); //a revoir (static)
}
