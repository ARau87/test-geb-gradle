package pages.vehicleGroupBlock

import geb.Page
import testVariables.TestVariables

class EditVehicleGroupPage extends Page{

    static url = TestVariables.URL + "vehiclegroups/vehiclegroup/id"

    static at = {
        pageBanner.isDisplayed()
        pageBanner.text() == "Fahrzeuggruppe bearbeiten"
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

        saveButton                          { $('button', type: 'submit', 0)}
        backButton                          { $('button', class: 'backButton')}
        successMessage                      { $('span', class: 'confirmMessageContainer')}
    }

    void vehicleGroupNameFieldInput(String name) {
        vehicleGroupNameField = name
    }

    void vehicleGroupNameFieldCheck(String name) {
        assert vehicleGroupNameField.value() == name
        println(vehicleGroupNameField.value())
    }

    void pricePerDayFieldInput(String price) {
        pricePerDayField = price
    }

    void pricePerDayFieldCheck(String price) {
        assert pricePerDayField.value() == price
        println(pricePerDayField.value())
    }

    void freeKmPerDayFieldInput(String freeKm) {
        freeKmPerDayField = freeKm
    }

    void freeKmPerDayFieldCheck(String freeKm) {
        assert freeKmPerDayField.value() == freeKm
        println(freeKmPerDayField.value())
    }

    void costProKmFieldInput(String cost) {
        costProKmField = cost
    }

    void costProKmFieldCheck(String cost) {
        assert costProKmField.value() == cost
        println(costProKmField.value())
    }

    void collisionDamageWaiverFieldInput(String value1) {
        collisionDamageWaiverField = value1
    }

    void collisionDamageWaiverFieldCheck(String value1) {
        assert collisionDamageWaiverField.value() == value1
        println(collisionDamageWaiverField.value())
    }

    void passengerAccidentInsuranceFieldInput(String value2) {
        passengerAccidentInsuranceField = value2
    }

    void passengerAccidentInsuranceFieldCheck(String value2) {
        assert passengerAccidentInsuranceField.value() == value2
        println(passengerAccidentInsuranceField.value())
    }

    void minimumAgeFieldInput(String age) {
        minimumAgeField = age
    }

    void minimumAgeFieldCheck(String age) {
        assert minimumAgeField.value() == age
        println(minimumAgeField.value())
    }

    void selfParticipationFieldInput(String value3) {
        selfParticipationField = value3
    }

    void selfParticipationFieldCheck(String value3) {
        assert selfParticipationField.value() == value3
        println(selfParticipationField.value())
    }

    void reducedSelfParticipationFieldInput(String value4){
        reducedSelfParticipationField = value4
    }

    void reducedSelfParticipationFieldCheck(String value4) {
        assert reducedSelfParticipationField.value() == value4
        println(reducedSelfParticipationField.value())
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
