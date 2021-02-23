package Service;

import Entities.MembreAssociation;

public interface IMembre {
    int addMembre(String data);
    Long updateMembre(String data);
    MembreAssociation getMembreById(Long id);
}
