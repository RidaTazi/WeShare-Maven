package Service;

import java.util.List;

import Entities.Don;
import Entities.Donneur;

public interface IDonneur {
    int addDonneur(String data);
    Boolean updateDonneur(String data);
    Donneur getDonneurById(Long id);
    Long deleteDonneur(Long id);
    List<Don> getDons(Long id);
    int addDon(Long id,String don);
    int updateDon(Long idDon, String data);
    int deleteDon(Long id);
    int donateToPub(Long idPub,String data);
    int donateToAssociation(Long idAssoc,String data);
}
