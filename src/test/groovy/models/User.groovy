package models

class User {

    public static final String ADMIN_EMAIL                      = "rac-superadmin@creamteam.de"
    public static final String ADMIN_PASSWORD                   = "creamteam"

    String email
    String password

    User(){
        this.email = ADMIN_EMAIL
        this.password = ADMIN_PASSWORD
    }

    User(String username, String password){
        this.email = username
        this.password = password
    }

}
