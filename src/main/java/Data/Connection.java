package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Connection {
    
    // <CONNECTION: LOCAL>
    private static final String JDBC_URL_LOCAL      = "jdbc:mysql://localhost:3306/MIPSS_?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER_LOCAL     = "root";
    private static final String JDBC_PASSWORD_LOCAL = "1234";
    // <.CONNECTION: LOCAL>
    
    private static BasicDataSource basicDataSource;
    
    public static DataSource getDataSource(int activate, int enviroment) {
        if(basicDataSource == null) {
            basicDataSource = new BasicDataSource();
            switch (activate) {
                case 0:                
                    break;

                case 1:
                    switch (enviroment) {
                        // <LOCAL>
                        case 0:                        
                            basicDataSource.setUrl(JDBC_URL_LOCAL);
                            basicDataSource.setUsername(JDBC_USER_LOCAL);
                            basicDataSource.setPassword(JDBC_PASSWORD_LOCAL);
                            basicDataSource.setInitialSize(50);
                            break;
                        // <.LOCAL>
                        default:
                            throw new AssertionError();
                    }
                    break;

                default:
                    throw new AssertionError();
            }
        
        }
        return basicDataSource;
        
    }
    
    // TODO: Fix
    public static java.sql.Connection getConnection(int activate, int enviroment) {
        try {
            return getDataSource(activate, enviroment).getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    public static void close(ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement preparedStatement) {
        try {
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    // TODO: Fix
    public static void close(java.sql.Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
}
