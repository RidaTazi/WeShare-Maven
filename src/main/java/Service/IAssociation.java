package Service;

import Entities.Association;
import Entities.Publication;

import java.util.List;

public interface IAssociation {
    List<String> getAssociationsName();
    Long deleteAssociation(Long id);
    int addAssociation(String data);
    Long updateAssociation(String data);
    Association getAssociationById(Long id);
    List<Publication> getPublications(Long id);
}
