package pages.reservationBlock

import geb.Page
import models.Reservation
import testVariables.TestVariables

class CreateReservationPage extends Page{

    protected static final HIDDEN_VEHICLE_INPUT_ID = 'selectedVehicleId'
    protected static final DATE_PICKUP_INPUT_ID = 'abDatumSoll'
    protected static final DATE_RETURN_INPUT_ID = 'anDatumSoll'


    static url = TestVariables.URL + "reservations/new"

    static at = {
        headline.isDisplayed()
    }

    static content = {

        reservationForm                { $('form', id:'reservationForm') }
        headline                       { reservationForm.$('h2')[0] }

        resNumberInput                 { $('input', id:'reservation.miete6ReservationNumber')}
        customerTypeSelect             { $('select', id:'customerTypeId')}
        salutationSelect               { $('select', id:'reservation.customerTitle')}
        firstnameInput                 { $('input', id:'reservation.customerFirstName')}
        lastnameInput                  { $('input', id:'reservation.customerLastName')}
        companyInput                  { $('input', id:'reservation.companyName')}

        streetInput                    { $('input', id:'reservation.customerStreet')}
        houseNrInput                   { $('input', id:'reservation.customerHouseNumber')}
        postalCodeInput                { $('input', id:'reservation.customerPostalCode')}
        cityInput                      { $('input', id:'reservation.customerCity')}
        phoneNumberInput               { $('input', id:'reservation.customerMobilePhone')}
        phoneNumberBookingCodeCheckbox { $('input', id:'cb_bookingCodeByPhone')}
        emailInput                     { $('input', id:'reservation.customerEmail')}
        emailBookingCodeCheckbox       { $('input', id:'cb_bookingCodeByEmail')}

        pricePerDayInput               { $('input', id:'reservation.accountingRatePerDay')}
        numDaysInput                   { $('input', id:'reservation.accountingNumberOfDays')}
        totalCostInput                 { $('input', id:'reservation.accountingTotalCosts')}
        depositInput                   { $('input', id:'i_deposit')}
        freeKMInput                    { $('input', id:'reservation.accountingFreeKilometers')}
        pricePerKMInput                { $('input', id:'cb_inputpriceperkm')}

        datePickupInput                {$('input', id:DATE_PICKUP_INPUT_ID)}
        dateReturnInput                {$('input', id:DATE_RETURN_INPUT_ID)}

        timeHrsPickupInput             {$('input', id:'reservation.startDateTimeHour')}
        timeMinPickupInput             {$('input', id:'reservation.startDateTimeMinute')}
        timeHrsReturnInput             {$('input', id:'reservation.endDateTimeHour')}
        timeMinReturnInput             {$('input', id:'reservation.endDateTimeMinute')}

        vehicleInput                   {$('input', id:'cb_inputVehicle')}
        vehicleHiddenInput             {$('input', id:HIDDEN_VEHICLE_INPUT_ID)}

        saveBtn                        {reservationForm.$('button', type:'submit').not('.backButton')}

    }

    void createReservation(Reservation reservation){


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




        // Booking code checkboxed
        if(reservation.emailForBookingcode) {
            emailBookingCodeCheckbox.click()
        }
        else {
            phoneNumberBookingCodeCheckbox.click()
        }

        // Pickup and return dates
        js.exec('document.getElementById("'+ DATE_PICKUP_INPUT_ID +'").removeAttribute("readonly")')
        datePickupInput.value(reservation.pickUpDate)
        js.exec('document.getElementById("'+ DATE_RETURN_INPUT_ID +'").removeAttribute("readonly")')
        dateReturnInput.value(reservation.returnDate)

        //
        vehicleInput = reservation.vehicle
        js.exec('document.getElementById("'+ HIDDEN_VEHICLE_INPUT_ID+'").setAttribute("value", '+ reservation.vehicleId+')')

        saveBtn.click()

    }




}
