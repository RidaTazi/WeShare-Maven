package Dao;

import java.util.List;

import Entities.Association;
import Entities.Publication;

public interface PublicationDao {
	public int createPub(Publication p);
	public int updatePub(Publication p);
	public int deletePub(long id);
	public Publication findById(long id);
	public List<Publication> findByAssociation(Association assoc);
	public List<Publication> findAll(); //a revoir (static)
}
