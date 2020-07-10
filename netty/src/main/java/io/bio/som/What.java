package io.bio.som;

import io.bio.Some;

import java.sql.*;

/**
 * @author dzl
 * 2020/6/4 9:42
 * @Description
 */
public class What {
    public static void main(String[] args) {
        Some some = new Some();
        some.printHello();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("", "", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try {
////            Statement statement = connection.createStatement();
////            PreparedStatement preparedStatement = connection.prepareStatement();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
