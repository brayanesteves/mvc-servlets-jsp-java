package Data;

import Domain.Person;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonDAO {
    
    private static final String SQL_SELECT                              = "SELECT `Rfrnc`, `Rfrnc_Prsn`, `Rfrnc_TypPrsn`, `Cndtn`, `Rmvd`, `Lckd`, `DtAdmssn`, `ChckTm` FROM `0_Prsn`;";
    private static final String SQL_SELECT_BY_REFERENCE                 = "SELECT `Rfrnc`, `Rfrnc_Prsn`, `Rfrnc_TypPrsn`, `Cndtn`, `Rmvd`, `Lckd`, `DtAdmssn`, `ChckTm` FROM `0_Prsn` WHERE `Rfrnc` = ?;";
    private static final String SQL_INSERT                              = "INSERT INTO `0_Prsn`(`Rfrnc_Prsn`, `Rfrnc_TypPrsn`, `Cndtn`, `Rmvd`, `Lckd`, `DtAdmssn`, `ChckTm`) VALUES(?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_UPDATE_ALL_BY_REFERENCE             = "UPDATE `0_Prsn` SET `Rfrnc_Prsn` = ?, `Rfrnc_TypPrsn` = ?, `Cndtn` = ?, `Rmvd` = ?, `Lckd` = ?, `DtAdmssn` = ?, `ChckTm` = ? WHERE `Rfrnc` = ?;";
    private static final String SQL_UPDATE_SPECIFIC_FIELDS_BY_REFERENCE = "UPDATE `0_Prsn` SET `Rfrnc_Prsn` = ?, `Rfrnc_TypPrsn` = ? WHERE `Rfrnc` = ?;";
    private static final String SQL_UPDATE_SIMULATE_DELETE_BY_REFERENCE = "UPDATE `0_Prsn` SET `Rmvd` = ? WHERE `Rfrnc` = ?;";
    private static final String SQL_DELETE_BY_REFERENCE                 = "DELETE FROM `0_Prsn` WHERE `Rfrnc` = ?;";
    
    private List<Person> list() {
        
        java.sql.Connection connection      = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet                 = null;
        Person person                       = null;
        List<Person> persons                = new ArrayList<>();
        try {            
            connection        = Connection.getConnection(1, 0);
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int    reference           = resultSet.getInt("Rfrnc");
                int    referencePerson     = resultSet.getInt("Rfrnc_Prsn");
                int    referenceTypePerson = resultSet.getInt("Rfrnc_TypPrsn");              
                int    condition              = resultSet.getInt("Cndtn");
                int    removed                = resultSet.getInt("Rmvd");
                int    locked                 = resultSet.getInt("Lckd");
                Date   dateAdmission          = resultSet.getDate("DtAdmssn");
                Time   checkTime              = resultSet.getTime("ChckTm");
                
                person = new Person(reference, referencePerson, referenceTypePerson, condition, removed, locked, dateAdmission, checkTime);
                persons.add(person);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Connection.close(resultSet);
            Connection.close(preparedStatement);
            Connection.close(connection);
        }
        
        return persons;
    }

}