package Service;

import Entities.Association;
import Entities.Don;
import Entities.Publication;
import java.util.List;

public interface IAssociation {
    List<String> getAssociationsName();
    Long deleteAssociation(Long id);
    int addAssociation(String data);
    Long updateAssociation(String data);
    Association getAssociationById(Long id);
    List<Publication> getPublications(Long id);
    int addPublication(Long id,String pub);
    int updatePublication(Long idAssoc, Long idPub, String data);
    int deletePublication(Long id);
    int acceptRefuseDon(String data);
    List<Publication> getAllPublications();
    List<Don> getDonsByPublication(Long pubId);
    long acceptDon(long id);
    long refuseDon(long id);
    List<Don> findDonByAssociation(Long id);
}
