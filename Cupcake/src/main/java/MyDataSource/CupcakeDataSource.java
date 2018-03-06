/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyDataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 *
 * @author Rasmus
 */
public class CupcakeDataSource
{
    private MysqlDataSource dataSource = new MysqlDataSource();

    public CupcakeDataSource()
    {
        dataSource.setServerName("159.89.107.124");
        dataSource.setPort(3306);
        dataSource.setUser("kirsten");
        dataSource.setPassword("kirsten");
        dataSource.setDatabaseName("cupcakes");
    }
    
     public CupcakeDataSource(boolean admin)
    {
        
    }
     
    
    
    

    public MysqlDataSource getDataSource()
    {
        return dataSource;
    }
}