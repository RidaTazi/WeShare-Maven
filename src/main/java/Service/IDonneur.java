package Service;

import Entities.Donneur;
import Entities.MembreAssociation;

public interface IDonneur {
    int addDonneur(String data);
    Long updateDonneur(String data);
    Donneur getDonneurById(Long id);
    Long deleteDonneur(Long id);
}
