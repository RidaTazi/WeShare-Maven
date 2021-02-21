package Service;

import Entities.Association;

import java.sql.SQLException;
import java.util.List;

public interface IAssociation {
    List<String> getAssociationsName();
    Long deleteAssociation(Long id);
    Long addAssociation(String data);
    Long updateAssociation(String data);
    Association getAssociationById(Long id);
}
