package Util;

public class Convert {
    
    public static java.sql.Date convertUtilDateToSQLDate(java.util.Date utilDateInput) {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate   = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }
    
}
