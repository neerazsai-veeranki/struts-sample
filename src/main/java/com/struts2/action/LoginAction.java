package com.struts2.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
    private final String url = "jdbc:postgresql://postgres:5432/postgres";
    private final String user = "postgres";
    private final String password = "postgres";

    private String name, pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String connect(String loginUsername, String loginPassword) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

            if (conn != null) {
                System.out.println("Connected to the PostgreSQL server successfully.");
                System.out.println(loginUsername);
                System.out.println(loginPassword);
                String sql = "select username, password from users where username = \'" + loginUsername + "\'";
                System.out.println("SQL : " + sql);
                ResultSet re = conn.createStatement().executeQuery(sql);
                while(re.next()) {
                    System.out.println("USERNAME : " + re.getString("username"));
                    System.out.println("PASSWORD : " + re.getString("password"));
                    if (loginUsername.equals(re.getString("username")) && loginPassword.equals(re.getString("password"))) {
                        return "SUCCESS";
                    }
                    return "FAILURE";
                }
                return "NO-USER";
            } else {
                System.out.println("Failed to make connection!");
                return "NO-CONNECTION";
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String execute() {
        LoginAction app = new LoginAction();
        String result = app.connect(name, pass);
        System.out.println(result);
        return result;
    }
}
