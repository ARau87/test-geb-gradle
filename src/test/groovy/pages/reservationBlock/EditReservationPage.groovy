package pages.reservationBlock

import models.Reservation
import testVariables.TestVariables

class EditReservationPage extends CreateReservationPage {

    static url = TestVariables.URL + "reservations/reservation"

    static at = {
        headline.isDisplayed()
    }


    boolean changeReservationTo(Reservation reservation){

        this.changeReservationValuesTo(reservation)


        saveBtn.click()

        return true

    }

    void changeReservationValuesTo(Reservation reservation){

        // Customer Type

        if(reservation.customerType == 'private'){
            customerTypeSelect.value('2')

            // Salutation

            if(reservation.salutation == 'Mr'){
                salutationSelect.value('title.mr')
            }
            else {
                salutationSelect.value('title.mrs')
            }
        }
        else {
            customerTypeSelect.value('1')
            salutationSelect.value('title.company')
            companyInput.value(reservation.company)
        }

        resNumberInput = reservation.reservationNr
        firstnameInput = reservation.firstname
        lastnameInput = reservation.lastname
        streetInput = reservation.street
        houseNrInput = reservation.houseNr
        postalCodeInput = reservation.postcode
        cityInput = reservation.city
        phoneNumberInput = reservation.phoneNumber
        emailInput = reservation.email

        pricePerDayInput = reservation.pricePerDay
        numDaysInput = reservation.numberOfDays
        totalCostInput = reservation.totalCost
        depositInput = reservation.deposit
        freeKMInput = reservation.freeKMPerDay
        pricePerKMInput = reservation.pricePerKM

        timeHrsPickupInput = reservation.pickUpTimeHrs
        timeMinPickupInput = reservation.pickUpTimeMins
        timeHrsReturnInput = reservation.returnTimeHrs
        timeMinReturnInput = reservation.returnTimeMins


        // Booking code checkboxed -> Leads to error
        //if(reservation.emailForBookingcode) {
        //    emailBookingCodeCheckbox.click()
        //}
        //else {
        //    phoneNumberBookingCodeCheckbox.click()
        //}

        // Pickup and return dates
        js.exec('document.getElementById("'+ DATE_PICKUP_INPUT_ID +'").removeAttribute("readonly")')
        datePickupInput.value(reservation.pickUpDate)
        js.exec('document.getElementById("'+ DATE_RETURN_INPUT_ID +'").removeAttribute("readonly")')
        dateReturnInput.value(reservation.returnDate)

        //
        vehicleInput = reservation.vehicle
        js.exec('document.getElementById("'+ HIDDEN_VEHICLE_INPUT_ID+'").setAttribute("value", '+ reservation.vehicleId+')')

    }


}
