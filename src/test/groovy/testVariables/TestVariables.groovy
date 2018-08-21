package testVariables

class TestVariables {

    public static final String URL                                      = "http://ws2k12ce31:8080/rac/"

    // Login Block
    public static final String ADMIN_EMAIL                              = "rac-superadmin@creamteam.de"
    public static final String ADMIN_PASSWORD                           = "creamteam"
    public static final String EMPTY_EMAIL_ERROR_MESSAGE 		        = "Das Passwort ist falsch oder der Benutzer ist inaktiv. \nBitte versuchen Sie es erneut."
    public static final String EMPTY_PASSWORD_ERROR_MESSAGE 	        = "Das Passwort ist falsch oder der Benutzer ist inaktiv. \nBitte versuchen Sie es erneut."
    public static final String EMPTY_FIELDS_ERROR_MESSAGE 		        = "Das Passwort ist falsch oder der Benutzer ist inaktiv. \nBitte versuchen Sie es erneut."
    public static final String USER_NOT_EXISTS_ERROR_MESSAGE            = "Das Passwort ist falsch oder der Benutzer ist inaktiv. \nBitte versuchen Sie es erneut."
    public static final String WRONG_PASSWORD_ERROR_MESSAGE             = "Das Passwort ist falsch oder der Benutzer ist inaktiv. \nBitte versuchen Sie es erneut."

    // User Block
    public static final String ADD_ROLE_MESSAGE                         = "Rolle hinzugefügt"
    public static final String DELETE_ROLE_MESSAGE                      = "Die Rolle wurde entfernt."
    public static final String PIN_SUCCESS_MESSAGE                      = "Ihre PIN wurde wieder aktiviert."

    // Success and empty mandatory field error messages
    public static final String SUCCESS_MESSAGE                          = "Die Daten wurden gespeichert."
    public static final String EMPTY_MANDATORY_FIELD_ERROR_MESSAGE      = "Darf nicht leer sein."

    // Vehicle Block
    public static final String EXISTED_LICENSE_NR_ERROR_MESSAGE         = "Es existiert bereits ein Fahrzeug mit dem gleichen Kennzeichen."
    public static final String EXISTED_VIN_ERROR_MESSAGE                = "Es existiert bereits ein Fahrzeug mit der gleichen Fahrgestellnummer."
}
