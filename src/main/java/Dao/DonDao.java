package Dao;

import java.util.List;

import Entities.Association;
import Entities.Don;
import Entities.Donneur;
import Entities.Publication;

public interface DonDao {
	public void createDon(Don d);
	public void updateDon(Don p);
	public void deleteDon(long id);
	public Don findById(long id);
	public List<Don> findByDonneur(Donneur donneur);
	public List<Don> findByPublication(Publication pub);
	public List<Don> findByAssociation(Association assoc);
	public List<Don> findAll(); //a revoir (static)
}
