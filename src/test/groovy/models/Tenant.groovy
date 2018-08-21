package models

class Tenant {

    public String name = 'München'
    public String currency = 'Euro'
    public String minimumAge = '18'

    private static randomNumber = new Random()

    Tenant(String name){
        this.name = name
    }

    static createTenantWithRandomName(String nameBase){

        String randomTenantName = nameBase + randomNumber.nextInt(100000)

        return new Tenant(randomTenantName)

    }
}
