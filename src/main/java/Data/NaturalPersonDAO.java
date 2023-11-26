package Data;

import Domain.NaturalPerson;
import Util.Convert;
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
            resultSet         = preparedStatement.executeQuery();
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
    
    public NaturalPerson findByReference(NaturalPerson naturalPerson) {
        
        java.sql.Connection connection      = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet                 = null;
        
        try {
            
            connection        = Connection.getConnection(1, 0);
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_REFERENCE);
            preparedStatement.setInt(1, naturalPerson.getReference());
            resultSet         = preparedStatement.executeQuery();
            resultSet.absolute(1); // We position ourselves at the first record.
            
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
                
            naturalPerson.setReference(reference);
            naturalPerson.setReferenceNacionality(referenceNacionality);
            naturalPerson.setReferenceCountry(referenceCountry);
            naturalPerson.setIdentificationDocument(identificationDocument);
            naturalPerson.setNames(names);
            naturalPerson.setSurnames(surnames);
            naturalPerson.setReferentialPhoneNumber(referentialPhoneNumber);
            naturalPerson.setTaxAddress(taxAddress);
            naturalPerson.setCondition(condition);
            naturalPerson.setRemoved(removed);
            naturalPerson.setLocked(locked);
            naturalPerson.setDateAdmission(dateAdmission);
            naturalPerson.setCheckTime(checkTime);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Connection.close(resultSet);
            Connection.close(preparedStatement);
            Connection.close(connection);
        }
        
        return naturalPerson;
        
    }
    
    public NaturalPerson findByIdentificationDocument(NaturalPerson naturalPerson) {
        
        java.sql.Connection connection      = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet                 = null;
        
        try {
            
            connection        = Connection.getConnection(1, 0);
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_IDENTIFICATION_DOCUMENT);
            preparedStatement.setString(1, naturalPerson.getIdentificationDocument());
            resultSet         = preparedStatement.executeQuery();
            resultSet.absolute(1); // We position ourselves at the first record.
            
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
                
            naturalPerson.setReference(reference);
            naturalPerson.setReferenceNacionality(referenceNacionality);
            naturalPerson.setReferenceCountry(referenceCountry);
            naturalPerson.setIdentificationDocument(identificationDocument);
            naturalPerson.setNames(names);
            naturalPerson.setSurnames(surnames);
            naturalPerson.setReferentialPhoneNumber(referentialPhoneNumber);
            naturalPerson.setTaxAddress(taxAddress);
            naturalPerson.setCondition(condition);
            naturalPerson.setRemoved(removed);
            naturalPerson.setLocked(locked);
            naturalPerson.setDateAdmission(dateAdmission);
            naturalPerson.setCheckTime(checkTime);            
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Connection.close(resultSet);
            Connection.close(preparedStatement);
            Connection.close(connection);
        }
        
        return naturalPerson;
        
    }
    
    public int add(NaturalPerson naturalPerson) {
        
        java.sql.Connection connection      = null;
        PreparedStatement preparedStatement = null;
        int rows                            = 0;
        
        try {
            connection        = Connection.getConnection(1, 0);
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            
            preparedStatement.setInt(1, naturalPerson.getReferenceNacionality());
            preparedStatement.setInt(2, naturalPerson.getReferenceCountry());
            preparedStatement.setString(3, naturalPerson.getIdentificationDocument());
            preparedStatement.setString(4, naturalPerson.getNames());
            preparedStatement.setString(5, naturalPerson.getSurnames());
            preparedStatement.setString(6, naturalPerson.getReferentialPhoneNumber());
            preparedStatement.setString(7, naturalPerson.getTaxAddress());                
            preparedStatement.setInt(8, naturalPerson.getCondition());
            preparedStatement.setInt(9, naturalPerson.getRemoved());
            preparedStatement.setInt(10, naturalPerson.getLocked());
            preparedStatement.setDate(11, Convert.convertUtilDateToSQLDate(naturalPerson.getDateAdmission()));
            preparedStatement.setTime(12, naturalPerson.getCheckTime());
            
            rows = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Connection.close(preparedStatement);
            Connection.close(connection);
        }
        
        return rows;
    }
    
    public int updateAllByReference(NaturalPerson naturalPerson) {
        
        java.sql.Connection connection      = null;
        PreparedStatement preparedStatement = null;
        int rows                            = 0;
        
        try {
            
            connection        = Connection.getConnection(1, 0);
            preparedStatement = connection.prepareStatement(SQL_UPDATE_ALL_BY_REFERENCE);
            
            preparedStatement.setInt(1, naturalPerson.getReferenceNacionality());
            preparedStatement.setInt(2, naturalPerson.getReferenceCountry());
            preparedStatement.setString(3, naturalPerson.getIdentificationDocument());
            preparedStatement.setString(4, naturalPerson.getNames());
            preparedStatement.setString(5, naturalPerson.getSurnames());
            preparedStatement.setString(6, naturalPerson.getReferentialPhoneNumber());
            preparedStatement.setString(7, naturalPerson.getTaxAddress());                
            preparedStatement.setInt(8, naturalPerson.getCondition());
            preparedStatement.setInt(9, naturalPerson.getRemoved());
            preparedStatement.setInt(10, naturalPerson.getLocked());
            preparedStatement.setDate(11, Convert.convertUtilDateToSQLDate(naturalPerson.getDateAdmission()));
            preparedStatement.setTime(12, naturalPerson.getCheckTime());
            preparedStatement.setInt(13, naturalPerson.getReference());
            
            rows = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Connection.close(preparedStatement);
            Connection.close(connection);
        }
        
        return rows;
    }
    
    public int updateAllByIdentificationDocument(NaturalPerson naturalPerson) {
        
        java.sql.Connection connection      = null;
        PreparedStatement preparedStatement = null;
        int rows                            = 0;
        
        try {
            
            connection        = Connection.getConnection(1, 0);
            preparedStatement = connection.prepareStatement(SQL_UPDATE_ALL_BY_IDENTIFICATION_DOCUMENT);
            
            preparedStatement.setInt(1, naturalPerson.getReferenceNacionality());
            preparedStatement.setInt(2, naturalPerson.getReferenceCountry());
            preparedStatement.setString(3, naturalPerson.getNames());
            preparedStatement.setString(4, naturalPerson.getSurnames());
            preparedStatement.setString(5, naturalPerson.getReferentialPhoneNumber());
            preparedStatement.setString(6, naturalPerson.getTaxAddress());                
            preparedStatement.setInt(7, naturalPerson.getCondition());
            preparedStatement.setInt(8, naturalPerson.getRemoved());
            preparedStatement.setInt(9, naturalPerson.getLocked());
            preparedStatement.setDate(10, Convert.convertUtilDateToSQLDate(naturalPerson.getDateAdmission()));
            preparedStatement.setTime(12, naturalPerson.getCheckTime());
            preparedStatement.setString(13, naturalPerson.getIdentificationDocument());
            
            rows = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Connection.close(preparedStatement);
            Connection.close(connection);
        }
        
        return rows;
        
    }
    
    public int updateEspecificFieldsByReference(NaturalPerson naturalPerson) {
        
        java.sql.Connection connection      = null;
        PreparedStatement preparedStatement = null;
        int rows                            = 0;
        
        try {
            
            connection        = Connection.getConnection(1, 0);
            preparedStatement = connection.prepareStatement(SQL_UPDATE_SPECIFIC_FIELDS_BY_REFERENCE);
            
            preparedStatement.setInt(1, naturalPerson.getReferenceNacionality());
            preparedStatement.setInt(2, naturalPerson.getReferenceCountry());
            preparedStatement.setString(3, naturalPerson.getIdentificationDocument());
            preparedStatement.setString(4, naturalPerson.getNames());
            preparedStatement.setString(5, naturalPerson.getSurnames());
            preparedStatement.setString(6, naturalPerson.getReferentialPhoneNumber());
            preparedStatement.setString(7, naturalPerson.getTaxAddress());
            preparedStatement.setInt(8, naturalPerson.getReference());
            
            rows = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Connection.close(preparedStatement);
            Connection.close(connection);
        }
        
        return rows;
        
    }
    
    public int updateEspecificFieldsByIdentificationDocument(NaturalPerson naturalPerson) {
       
        java.sql.Connection connection      = null;
        PreparedStatement preparedStatement = null;
        int rows                            = 0;
        
        try {
            
            connection        = Connection.getConnection(1, 0);
            preparedStatement = connection.prepareStatement(SQL_UPDATE_SPECIFIC_FIELDS_BY_IDENTIFICATION_DOCUMENT);
            
            preparedStatement.setInt(1, naturalPerson.getReferenceNacionality());
            preparedStatement.setInt(2, naturalPerson.getReferenceCountry());
            preparedStatement.setString(3, naturalPerson.getNames());
            preparedStatement.setString(4, naturalPerson.getSurnames());
            preparedStatement.setString(5, naturalPerson.getReferentialPhoneNumber());
            preparedStatement.setString(6, naturalPerson.getTaxAddress());
            preparedStatement.setString(13, naturalPerson.getIdentificationDocument());
            
            rows = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Connection.close(preparedStatement);
            Connection.close(connection);
        }
        
        return rows;
        
    }
    
    public int updateSimulateDeleteByReference(NaturalPerson naturalPerson) {
        
        java.sql.Connection connection      = null;
        PreparedStatement preparedStatement = null;
        int rows                            = 0;
        
        try {
            
            connection        = Connection.getConnection(1, 0);
            preparedStatement = connection.prepareStatement(SQL_UPDATE_SIMULATE_DELETE_BY_REFERENCE);
            
            preparedStatement.setInt(1, naturalPerson.getRemoved());
            preparedStatement.setInt(2, naturalPerson.getReference());
            
            rows = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Connection.close(preparedStatement);
            Connection.close(connection);
        }
        
        return rows;
        
    }
    
    public int updateSimulateDeleteByIdentificationDocument(NaturalPerson naturalPerson) {
        
        java.sql.Connection connection      = null;
        PreparedStatement preparedStatement = null;
        int rows                            = 0;
        
        try {
            
            connection        = Connection.getConnection(1, 0);
            preparedStatement = connection.prepareStatement(SQL_UPDATE_SIMULATE_DELETE_BY_IDENTIFICATION_DOCUMENT);
            
            preparedStatement.setInt(1, naturalPerson.getRemoved());
            preparedStatement.setString(2, naturalPerson.getIdentificationDocument());
            
            rows = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Connection.close(preparedStatement);
            Connection.close(connection);
        }
        
        return rows;
        
    }
    
    public int deleteByReference(NaturalPerson naturalPerson) {
        
        java.sql.Connection connection      = null;
        PreparedStatement preparedStatement = null;
        int rows                            = 0;
        
        try {
            
            connection        = Connection.getConnection(1, 0);
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_REFERENCE);
            
            preparedStatement.setInt(1, naturalPerson.getReference());
            
            rows = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Connection.close(preparedStatement);
            Connection.close(connection);
        }
        
        return rows;
        
    }
    
    public int deleteByIdentificationDocument(NaturalPerson naturalPerson) {
        
        java.sql.Connection connection      = null;
        PreparedStatement preparedStatement = null;
        int rows                            = 0;
        
        try {
            
            connection        = Connection.getConnection(1, 0);
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_IDENTIFICATION_DOCUMENT);
            
            preparedStatement.setString(1, naturalPerson.getIdentificationDocument());
            
            rows = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Connection.close(preparedStatement);
            Connection.close(connection);
        }
        
        return rows;
        
    }

}