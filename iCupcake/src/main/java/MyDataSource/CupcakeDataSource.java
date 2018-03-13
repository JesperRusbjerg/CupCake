package MyDataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class CupcakeDataSource {

    private MysqlDataSource dataSource = new MysqlDataSource();

    public CupcakeDataSource() {
        dataSource.setServerName("159.89.107.124");
        dataSource.setPort(3306);
        dataSource.setUser("kirsten");
        dataSource.setPassword("kirsten");
        dataSource.setDatabaseName("cupcake");
    }

    public MysqlDataSource getDataSource() {
        return dataSource;
    }
}