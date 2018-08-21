package pages.vehicleGroupBlock

import geb.Page
import testVariables.TestVariables

class CreateNewVehicleGroupPage extends Page{

    static url = TestVariables.URL + "vehiclegroups/new"

    static at = {
        pageBanner.isDisplayed()
        pageBanner.text() == "Fahrzeuggruppe anlegen"
    }

    static content = {
        pageBanner                          { $('form').find('h2').first()}

        vehicleGroupNameField               { $('input', name: 'vehicleGroupName')}
        pricePerDayField                    { $('input', name: 'pricePerDay')}
        freeKmPerDayField                   { $('input', name: 'freeKmPerDay')}
        costProKmField                      { $('input', name: 'additionalKmPrice')}
        collisionDamageWaiverField          { $('input', name: 'collisionDamageWaiver')}
        passengerAccidentInsuranceField     { $('input', name: 'passengerAccidentInsurance')}
        minimumAgeField                     { $('input', name: 'minimumAge')}
        selfParticipationField              { $('input', name: 'selfParticipation')}
        reducedSelfParticipationField       { $('input', name: 'reducedSelfParticipation')}

        saveButton                          { $('button', type: 'submit').first()}
        backButton                          { $('button', class: 'backButton')}
        successMessage                      { $('span', class: 'confirmMessageContainer')}
    }

    void vehicleGroupNameFieldInput(String name) {
        vehicleGroupNameField = name
    }

    void pricePerDayFieldInput(String price) {
        pricePerDayField = price
    }

    void freeKmPerDayFieldInput(String freeKm) {
        freeKmPerDayField = freeKm
    }

    void costProKmFieldInput(String cost) {
        costProKmField = cost
    }

    void collisionDamageWaiverFieldInput(String value1) {
        collisionDamageWaiverField = value1
    }

    void passengerAccidentInsuranceFieldInput(String value2) {
        passengerAccidentInsuranceField = value2
    }

    void minimumAgeFieldInput(String age) {
        minimumAgeField = age
    }

    void selfParticipationFieldInput(String value3) {
        selfParticipationField = value3
    }

    void reducedSelfParticipationFieldInput(String value4){
        reducedSelfParticipationField = value4
    }

    void saveButtonClick() {
        saveButton.click()
    }

    void backButtonClick() {
        backButton.click()
    }

    void checkSuccessMessage(String message) {
        successMessage.isDisplayed()
        assert successMessage.text().contains(message)
    }
}
