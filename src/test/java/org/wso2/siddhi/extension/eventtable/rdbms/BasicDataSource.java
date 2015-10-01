/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.siddhi.extension.eventtable.rdbms;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Logger;

public class BasicDataSource implements DataSource {

    @Override
    public Connection getConnection() throws SQLException {
        try {
            Class.forName(RDBMSTestConstants.MYSQL_DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection(RDBMSTestConstants.CONNECTION_URL, RDBMSTestConstants.USERNAME, RDBMSTestConstants.PASSWORD);
        } catch (Exception ex) {
            Connection connection = DriverManager.getConnection(RDBMSTestConstants.CONNECTION_URL.replace("cepdb",""), RDBMSTestConstants.USERNAME, RDBMSTestConstants.PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE cepdb");
            statement.close();
            return DriverManager.getConnection(RDBMSTestConstants.CONNECTION_URL, RDBMSTestConstants.USERNAME, RDBMSTestConstants.PASSWORD);

        }
    }


    //H2 Connection Configuration
//    @Override
//    public Connection getConnection() throws SQLException {
//        try {
//            Class.forName(RDBMSTestConstants.H2_DRIVER_CLASS);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            return DriverManager.getConnection(RDBMSTestConstants.H2_CONNECTION_URL, RDBMSTestConstants.H2USERNAME, RDBMSTestConstants.H2PASSWORD);
//        } catch (Exception ex) {
//            Connection connection = DriverManager.getConnection(RDBMSTestConstants.H2_CONNECTION_URL, RDBMSTestConstants.H2USERNAME, RDBMSTestConstants.H2PASSWORD);
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("CREATE DATABASE cepdb");
//            statement.close();
//            return DriverManager.getConnection(RDBMSTestConstants.H2_CONNECTION_URL, RDBMSTestConstants.H2USERNAME, RDBMSTestConstants.H2PASSWORD);
//
//        }
//    }


    //Oracle Connection Configuration
//    @Override
//    public Connection getConnection() throws SQLException {
//        try {
//            Class.forName(RDBMSTestConstants.ORACLE_DRIVER_CLASS);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            return DriverManager.getConnection(RDBMSTestConstants.ORACLE_CONNECTION_URL, RDBMSTestConstants.ORACLEUSERNAME, RDBMSTestConstants.ORACLEPASSWORD);
//        } catch (Exception ex) {
//            Connection connection = DriverManager.getConnection(RDBMSTestConstants.ORACLE_CONNECTION_URL, RDBMSTestConstants.ORACLEUSERNAME, RDBMSTestConstants.ORACLEPASSWORD);
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("CREATE DATABASE daniddb");
//            statement.close();
//            return DriverManager.getConnection(RDBMSTestConstants.ORACLE_CONNECTION_URL, RDBMSTestConstants.ORACLEUSERNAME, RDBMSTestConstants.ORACLEPASSWORD);
//
//        }
//    }


    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    /**
     * Return the parent Logger of all the Loggers used by this data source. This
     * should be the Logger farthest from the root Logger that is
     * still an ancestor of all of the Loggers used by this data source. Configuring
     * this Logger will affect all of the log messages generated by the data source.
     * In the worst case, this may be the root Logger.
     *
     * @return the parent Logger for this data source
     * @throws java.sql.SQLFeatureNotSupportedException
     *          if the data source does not use <code>java.util.logging<code>.
     * @since 1.7
     */
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

}
