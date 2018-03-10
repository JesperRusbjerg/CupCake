
package DataAccessObject;

import MyDataSource.CupcakeDataSource;


public class Handler {
    
    private DAOCupcake dao = new DAOCupcake(new CupcakeDataSource().getDataSource());
    
}
