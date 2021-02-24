package DAO;

import java.util.List;

import Entities.Association;
import Entities.Don;
import Entities.Publication;

public interface PublicationDao {
	public void createPub(Publication p);
	public void updatePub(Publication p);
	public void deletePub(long id);
	public Publication findById(long id);
	public List<Association> findByAssociation(Association assoc);
	public List<Publication> findAll(); //a revoir (static)
}
