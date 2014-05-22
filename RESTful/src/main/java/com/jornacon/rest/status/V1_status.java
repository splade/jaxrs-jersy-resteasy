package com.jornacon.rest.status;

import com.jornacon.dao.HSQLDB;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by User on 22/05/2014.
 */
@Path("/v1/status/*")
public class V1_status {

    private static final String api_version = "00.01.00";

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String returnTitle(){
        return "<p>Java Web Service</p>";
    }

    @Path("/version")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String returnVersion(){
        return "<p>Version:</p>" + api_version;
    }

    @Path("/database")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String returnDatabaseStatus() throws Exception{
        PreparedStatement query = null;
        String myString = null;
        String returnString = null;
        Connection conn = null;

        try{
            conn = HSQLDB.HSQLDBConn().getConnection();
            query = conn.prepareStatement("select to_char(sysdate,'YYYY-MM-DD HH24:MI:SS') DATETIME" + "from sys.dual");
            ResultSet rs = query.executeQuery();
            while(rs.next()){
                myString = rs.getString("DATETIME");
            }
            query.close();
            returnString = "<p>Database Status</p>" + "<p>Database Date/Time return: " + myString + "</p>";
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(conn != null){
                query.close();
            }
        }
        return returnString;
    }
}