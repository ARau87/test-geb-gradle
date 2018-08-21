package pages.vehicleBlock

import geb.Page
import geb.module.Checkbox
import geb.module.Select
import testVariables.TestVariables

class CreateNewVehiclePage extends Page{

    static url = TestVariables.URL + "vehicles/new"

    static at = {
        pageBanner.isDisplayed()
        pageBanner.text() == "Fahrzeug anlegen"
    }

    static content = {
        pageBanner                  { $('form').find('h2').first()}

        licensePlateNumberField     { $('input', name: 'licensePlateNumber')}
        vehicleCategoryField        { $('input', name: 'category')}
        vinField                    { $('input', name: 'vehicleIdNumber')}
        colorField                  { $('input', name: 'color')}
        fuelTypeField               { $('input', name: 'fuelType')}
        automaticCheckbox           { $('input#automatic1').module(Checkbox)}
        vehicleGroupSelect          { $('select', name: 'vehicleGroup.vehicleGroupId').module(Select)}
        gpsCheckbox                 { $('input#gps1').module(Checkbox)}
        mileageKmField              { $('input', name: 'mileageKm')}
        blockedCheckbox             { $('input#blocked1').module(Checkbox)}
        activeCheckbox              { $('input#active1').module(Checkbox)}
        defectsField                { $('input', name: 'defects')}
        minimumAgeField             { $('input', name: 'minimumAge')}

        backButton                  { $('button', class: 'backButton')}
        saveButton                  { $('button', 0, type: 'submit')}
        successMessage              { $('span', class: 'confirmMessageContainer')}
    }

    void licensePlateNumberFieldInput(String nr) {
        licensePlateNumberField = nr
    }

    void vehicleCategoryFieldInput(String category) {
        vehicleCategoryField = category
    }

    void vinFieldInput(String vin) {
        vinField = vin
    }

    void colorFieldInput(String color) {
        colorField = color
    }

    void fuelTypeFieldInput(String fueltype) {
        fuelTypeField = fueltype
    }

    void checkboxAutomatic() {
        if (automaticCheckbox.checked){
            automaticCheckbox.uncheck()
        }
    }

    void selectVehicleGroup(String group) {
        vehicleGroupSelect.selected = group
    }

    void checkboxGps() {
        if (gpsCheckbox.checked){
            gpsCheckbox.uncheck()
        }
    }

    void mileageKmFieldInput(String mileage) {
        mileageKmField = mileage
    }

    void checkboxBlocked() {
        if (blockedCheckbox.unchecked)
            blockedCheckbox.check()
    }

    void checkboxActive() {
        if (activeCheckbox.checked) {
            activeCheckbox.uncheck()
        }
    }

    void defectsFieldInput(String defect) {
        defectsField = defect
    }

    void minimumAgeFieldInput(String age) {
        minimumAgeField = age
    }

    void backButtonClick() {
        backButton.click()
    }

    void saveButtonClick() {
        saveButton.click()
    }

    void successMessageCheck(String message) {
        successMessage.isDisplayed()
        assert successMessage.text().contains(message)
    }

    void licensePlateNumberFieldErrorMessage(boolean errorExpected, String errorMessage) {
        if (errorExpected) {
            waitFor {licensePlateNumberField.isDisplayed()}
            assert licensePlateNumberField.next().text() == errorMessage
        } else {
            assert licensePlateNumberField.next().text() != errorMessage
        }
    }

    void vehicleCategoryFieldErrorMessage(boolean errorExpected, String errorMessage) {
        if (errorExpected) {
            waitFor {vehicleCategoryField.isDisplayed()}
            assert vehicleCategoryField.next().text() == errorMessage
        } else {
            assert vehicleCategoryField.next().text() != errorMessage
        }
    }

    void vinFieldErrorMessage(boolean  errorExpected, String errorMessage) {
        if (errorExpected) {
            waitFor {vinField.isDisplayed()}
            assert vinField.next().text() == errorMessage
        } else {
            assert vinField.next().text() != errorMessage
        }
    }

    void colorFieldErrorMessage(boolean errorExpected, String errorMessage) {
        if (errorExpected) {
            waitFor {colorField.isDisplayed()}
            assert colorField.next().text() == errorMessage
        } else {
            assert colorField.next().text() != errorMessage
        }
    }

    void fuelTypeFieldErrorMessage(boolean errorExpected, String errorMessage) {
        if (errorExpected) {
            waitFor {fuelTypeField.isDisplayed()}
            assert fuelTypeField.next().text() == errorMessage
        } else {
            assert fuelTypeField.next().text() != errorMessage
        }
    }

    void vehicleGroupSelectErrorMessage(boolean errorExpected, String errorMessage) {
        if (errorExpected) {
            waitFor {vehicleGroupSelect.isDisplayed()}
            assert vehicleGroupSelect.next().text() == errorMessage
        } else {
            assert vehicleGroupSelect.next().text() != errorMessage
        }
    }

    void mileageKmFieldErrorMessage(boolean errorExpected, String errorMessage) {
        if (errorExpected) {
            waitFor {mileageKmField.isDisplayed()}
            assert mileageKmField.next().text() == errorMessage
        } else {
            assert mileageKmField.next().text() != errorMessage
        }
    }
}
