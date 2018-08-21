package models

class Location {

    // Mandatory location properties
    public String name = 'Munich'
    public String address = 'Krumpterstr 6a'
    public String phoneNr = '015776399466'
    public String emailMerchant = 'service@example.com'
    public String emailSender = 'info@example.com'
    public String info = 'Info'
    public String contact = '<p>Example contact information<p>'
    public String tenant = 'München'
    public String defaultLanguage = 'Deutsch'
    public String country = 'Deutschland'

    private static randomNumber = new Random()

    Location(String name, String address, String phoneNr, String emailMerchant, String emailSender, String info, String contact, String tenant, String defaultLanguage, String country) {
        this.name = name
        this.address = address
        this.phoneNr = phoneNr
        this.emailMerchant = emailMerchant
        this.emailSender = emailSender
        this.info = info
        this.contact = contact
        this.tenant = tenant
        this.defaultLanguage = defaultLanguage
        this.country = country
    }

    Location(String name) {
        this.name = name
    }

    static createLocationWithRandomName(String nameBase){

        String randomLocationName = nameBase + randomNumber.nextInt(100000)

        return new Location(randomLocationName)

    }


}


