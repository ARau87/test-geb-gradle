package models

class Reservation {

    public String reservationNr
    public String customerType = 'private'
    public String salutation = 'Mr'
    public String firstname = 'John'
    public String lastname = 'Doe'
    public String street = 'Doe\'s Street'
    public String houseNr = '23'
    public String postcode = '37856'
    public String city = 'Doe City'
    public boolean emailForBookingcode = true
    public boolean phoneNumberForBookingcode = false
    public String email = 'john.doe@example.com'
    public String phoneNumber = '015776399466'
    public String company = 'CreamTeam GmbH'

    public String pricePerDay = '5.00'
    public String numberOfDays = '10'
    public String totalCost = '50'
    public String deposit = '100'
    public String freeKMPerDay = '15'
    public String pricePerKM = '2.5'

    public String pickUpTimeHrs = '11'
    public String pickUpTimeMins = '30'

    public String returnTimeHrs = '18'
    public String returnTimeMins = '30'

    public String pickUpDate = '10.12.2018'
    public String returnDate = '20.12.2018'

    public vehicle = 'BS-EM1410'
    public vehicleId = '1129899'

    Reservation(String reservationNr, String customerType, String salutation, String firstname, String lastname, String street, String houseNr, String postcode, boolean emailForBookingcode, boolean phoneNumberForBookingcode, String email, String phoneNumber, String pricePerDay, String numberOfDays, String totalCost, String deposit, String freeKMPerDay, String pricePerKM, String pickUpTimeHrs, String pickUpTimeMins, String returnTimeHrs, String returnTimeMins, String pickUpDate, String returnDate, vehicle) {
        this.reservationNr = reservationNr
        this.customerType = customerType
        this.salutation = salutation
        this.firstname = firstname
        this.lastname = lastname
        this.street = street
        this.houseNr = houseNr
        this.postcode = postcode
        this.emailForBookingcode = emailForBookingcode
        this.phoneNumberForBookingcode = phoneNumberForBookingcode
        this.email = email
        this.phoneNumber = phoneNumber
        this.pricePerDay = pricePerDay
        this.numberOfDays = numberOfDays
        this.totalCost = totalCost
        this.deposit = deposit
        this.freeKMPerDay = freeKMPerDay
        this.pricePerKM = pricePerKM
        this.pickUpTimeHrs = pickUpTimeHrs
        this.pickUpTimeMins = pickUpTimeMins
        this.returnTimeHrs = returnTimeHrs
        this.returnTimeMins = returnTimeMins
        this.pickUpDate = pickUpDate
        this.returnDate = returnDate
        this.vehicle = vehicle
    }

    Reservation(String reservationNr, String customerType, String salutation, String firstname, String lastname, String street, String houseNr, String postcode, boolean emailForBookingcode, boolean phoneNumberForBookingcode, String email, String phoneNumber) {
        this.reservationNr = reservationNr
        this.customerType = customerType
        this.salutation = salutation
        this.firstname = firstname
        this.lastname = lastname
        this.street = street
        this.houseNr = houseNr
        this.postcode = postcode
        this.emailForBookingcode = emailForBookingcode
        this.phoneNumberForBookingcode = phoneNumberForBookingcode
        this.email = email
        this.phoneNumber = phoneNumber
    }

    Reservation(String reservationNr, String customerType, String company, String street, String houseNr, String postcode, boolean emailForBookingcode, boolean phoneNumberForBookingcode, String email, String phoneNumber) {
        this.reservationNr = reservationNr
        this.customerType = customerType
        this.company = company
        this.street = street
        this.houseNr = houseNr
        this.postcode = postcode
        this.emailForBookingcode = emailForBookingcode
        this.phoneNumberForBookingcode = phoneNumberForBookingcode
        this.email = email
        this.phoneNumber = phoneNumber

    }

    Reservation(String reservationNr) {
        this.reservationNr = reservationNr
    }

    Reservation(){
        this.reservationNr = this.getRandomNumber(1000000)
    }

    int getRandomNumber(int num){
        Random random = new Random()
        return random.nextInt(num)
    }
}
