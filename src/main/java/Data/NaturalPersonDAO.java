package Data;

import Domain.NaturalPerson;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NaturalPersonDAO {
    
    private static final String SQL_SELECT                                            = "SELECT `Rfrnc`, `Rfrnc_Ncnlty`, `Rfrnc_Cntry`, `IdntfctnDcmnt`, `Nms`, `Srnms`, `RfrntlPhnNmbr`, `TxAddrss`, `Cndtn`, `Rmvd`, `Lckd`, `DtAdmssn`, `ChckTm` FROM `0_NtrlPrsn`;";
    private static final String SQL_SELECT_BY_REFERENCE                               = "SELECT `Rfrnc`, `Rfrnc_Ncnlty`, `Rfrnc_Cntry`, `IdntfctnDcmnt`, `Nms`, `Srnms`, `RfrntlPhnNmbr`, `TxAddrss`, `Cndtn`, `Rmvd`, `Lckd`, `DtAdmssn`, `ChckTm` FROM `0_NtrlPrsn` WHERE `Rfrnc` = ?;";
    private static final String SQL_SELECT_BY_IDENTIFICATION_DOCUMENT                 = "SELECT `Rfrnc`, `Rfrnc_Ncnlty`, `Rfrnc_Cntry`, `IdntfctnDcmnt`, `Nms`, `Srnms`, `RfrntlPhnNmbr`, `TxAddrss`, `Cndtn`, `Rmvd`, `Lckd`, `DtAdmssn`, `ChckTm` FROM `0_NtrlPrsn` WHERE `IdntfctnDcmnt` = ?;";
    private static final String SQL_INSERT                                            = "INSERT INTO `0_NtrlPrsn`(`Rfrnc_Ncnlty`, `Rfrnc_Cntry`, `IdntfctnDcmnt`, `Nms`, `Srnms`, `RfrntlPhnNmbr`, `TxAddrss`, `Cndtn`, `Rmvd`, `Lckd`, `DtAdmssn`, `ChckTm`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_UPDATE_ALL_BY_REFERENCE                           = "UPDATE `0_NtrlPrsn` SET `Rfrnc_Ncnlty` = ?, `Rfrnc_Cntry` = ?, `IdntfctnDcmnt` = ?, `Nms` = ?, `Srnms` = ?, `RfrntlPhnNmbr` = ?, `TxAddrss` = ?, `Cndtn` = ?, `Rmvd` = ?, `Lckd` = ?, `DtAdmssn` = ?, `ChckTm` = ? WHERE `Rfrnc` = ?;";
    private static final String SQL_UPDATE_ALL_BY_IDENTIFICATION_DOCUMENT             = "UPDATE `0_NtrlPrsn` SET `Rfrnc_Ncnlty` = ?, `Rfrnc_Cntry` = ?, `Nms` = ?, `Srnms` = ?, `RfrntlPhnNmbr` = ?, `TxAddrss` = ?, `Cndtn` = ?, `Rmvd` = ?, `Lckd` = ?, `DtAdmssn` = ?, `ChckTm` = ? WHERE `IdntfctnDcmnt` = ?;";
    private static final String SQL_UPDATE_SPECIFIC_FIELDS_BY_REFERENCE               = "UPDATE `0_NtrlPrsn` SET `Rfrnc_Ncnlty` = ?, `Rfrnc_Cntry` = ?, `IdntfctnDcmnt` = ?, `Nms` = ?, `Srnms` = ?, `RfrntlPhnNmbr` = ?, `TxAddrss` = ? WHERE `Rfrnc` = ?;";
    private static final String SQL_UPDATE_SPECIFIC_FIELDS_BY_IDENTIFICATION_DOCUMENT = "UPDATE `0_NtrlPrsn` SET `Rfrnc_Ncnlty` = ?, `Rfrnc_Cntry` = ?, `Nms` = ?, `Srnms` = ?, `RfrntlPhnNmbr` = ?, `TxAddrss` = ? WHERE `IdntfctnDcmnt` = ?;";
    private static final String SQL_UPDATE_SIMULATE_DELETE_BY_REFERENCE               = "UPDATE `0_NtrlPrsn` SET `Rmvd` = ? WHERE `Rfrnc` = ?;";
    private static final String SQL_UPDATE_SIMULATE_DELETE_BY_IDENTIFICATION_DOCUMENT = "UPDATE `0_NtrlPrsn` SET `Rmvd` = ? WHERE `IdntfctnDcmnt` = ?;";
    private static final String SQL_DELETE_BY_REFERENCE                               = "DELETE FROM `0_NtrlPrsn` WHERE `Rfrnc` = ?;";
    private static final String SQL_DELETE_BY_IDENTIFICATION_DOCUMENT                 = "DELETE FROM `0_NtrlPrsn` WHERE `IdntfctnDcmnt` = ?;";
    
    private List<NaturalPerson> list() {
        
        java.sql.Connection connection      = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet                 = null;
        NaturalPerson naturalPerson         = null;
        List<NaturalPerson> naturalPersons  = new ArrayList<>();
        try {            
            connection        = Connection.getConnection(1, 0);
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int    reference              = resultSet.getInt("Rfrnc");
                int    referenceNacionality   = resultSet.getInt("Rfrnc_Ncnlty");
                int    referenceCountry       = resultSet.getInt("Rfrnc_Cntry");
                String identificationDocument = resultSet.getString("IdntfctnDcmnt");
                String names                  = resultSet.getString("Nms");
                String surnames               = resultSet.getString("Srnms");
                String referentialPhoneNumber = resultSet.getString("RfrntlPhnNmbr");
                String taxAddress             = resultSet.getString("TxAddrss");                
                int    condition              = resultSet.getInt("Cndtn");
                int    removed                = resultSet.getInt("Rmvd");
                int    locked                 = resultSet.getInt("Lckd");
                Date   dateAdmission          = resultSet.getDate("DtAdmssn");
                Time   checkTime              = resultSet.getTime("ChckTm");
                
                naturalPerson = new NaturalPerson(reference, referenceNacionality, referenceCountry, identificationDocument, names, surnames, referentialPhoneNumber, taxAddress, condition, removed, locked, dateAdmission, checkTime);
                naturalPersons.add(naturalPerson);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Connection.close(resultSet);
            Connection.close(preparedStatement);
            Connection.close(connection);
        }
        
        return naturalPersons;
    }

}