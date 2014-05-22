package com.jornacon.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * Created by User on 22/05/2014.
 */
public class HSQLDB {

    private static DataSource HSQLDB = null;
    private static Context context = null;

    public static DataSource HSQLDBConn() throws Exception{
        if(HSQLDB != null){
            return HSQLDB;
        }
        try{
            if(context == null){
                context = new InitialContext();
            }

            HSQLDB = (DataSource) context.lookup("RESTful");
        }catch (Exception e){
            e.printStackTrace();
        }
        return HSQLDB;
    }
}
