package com.partenupreview.partenup.user;


import com.partenupreview.partenup.userdb.UserDb;

public class OurUser {



    private String username;
    private String password;


    public OurUser(){}

    public OurUser(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public static UserDb fromOurUser(OurUser user){
        UserDb result = new UserDb();
        result.setUsername(user.getUsername());
        result.setPassword(user.getPassword());
        return result;
    }
}
