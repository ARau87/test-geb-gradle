package pages.vehicleBlock

import geb.Page
import geb.module.Checkbox
import geb.module.Select
import testVariables.TestVariables

class EditVehiclePage extends Page{

    static url = TestVariables.URL + "vehicles/vehicle/id"

    static at = {
        pageBanner.isDisplayed()
        pageBanner.text() == "Fahrzeug bearbeiten"
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

    void activatedCheckboxAutomatic() {
        if (automaticCheckbox.unchecked){
            automaticCheckbox.check()
        }
    }

    void selectVehicleGroup(String group) {
        vehicleGroupSelect.selected = group
    }

    void activatedCheckboxGps() {
        if (gpsCheckbox.unchecked){
            gpsCheckbox.check()
        }
    }

    void mileageKmFieldInput(String mileage) {
        mileageKmField = mileage
    }

    void deactivatedCheckboxBlocked() {
        if (blockedCheckbox.checked)
            blockedCheckbox.uncheck()
    }

    void activatedCheckboxActive() {
        if (activeCheckbox.unchecked) {
            activeCheckbox.check()
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
}
