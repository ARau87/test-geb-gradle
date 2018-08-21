package specs

import geb.spock.GebSpec
import org.junit.Before
import pages.LoginPage
import pages.MainPage
import pages.vehicleBlock.CreateNewVehiclePage
import pages.vehicleBlock.EditVehiclePage
import pages.vehicleBlock.VehicleImportPage
import pages.vehicleBlock.VehicleListPage
import testVariables.TestVariables
import testVariables.TestVariablesVehicle

class VehicleSpec extends GebSpec{

    @Before
    def "ASS RAC Admin login"() {
        to LoginPage
        logInAsAdministrator()
    }

    def "p_Create_New_Vehicle"() {
        given: "I'm on Main page"
        at MainPage

        when: "I go to Vehicle List page"
        vehiclesLinkClick()
        at VehicleListPage

        then: "I go to Create New Vehicle Page"
        clickNewVehicleButton()
        at CreateNewVehiclePage

        and: "I create new vehicle"
        fillVehicleData()
        checkCheckboxes()
        saveVehicle()

        and: "I'm on Edit Vehicle page"
        at EditVehiclePage
    }

    def "p_Edit_Vehicle"() {
        given: "I'm on Main page"
        at MainPage

        when: "I go to Vehicle List page"
        vehiclesLinkClick()
        at VehicleListPage

        then: "I go to Edit Vehicle page"
        goToEditVehiclePage()
        at EditVehiclePage

        and: "I edit vehicle data"
        editVehicleData()
        editCheckboxes()
        saveVehicle()

        and: "I go to Vehicle List page"
        clickBackButton()
        at VehicleListPage
    }

    def "p_Vehicle_Import"() {
        given: "I'm on Main page"
        at MainPage

        when: "I go to Vehicle List page"
        vehiclesLinkClick()
        at VehicleListPage

        then: "I go to Vehicle Import page"
        clickVehicleImportButton()
        at VehicleImportPage

        and: "I check elements on page"
        checkElemets()
    }

    def "n_Create_New_Vehicle"() {
        given: "I'm on Main page"
        at MainPage

        when: "I go to Vehicle List page"
        vehiclesLinkClick()
        at VehicleListPage

        then: "I go to Create New Vehicle Page"
        clickNewVehicleButton()
        at CreateNewVehiclePage

        and: "I try to create new vehicle"
        clickSaveButton()
    }

    // positive test create and edit vehicle
    private void clickNewVehicleButton() {
        newVehicleButtonClick()
    }

    private void fillVehicleData() {
        licensePlateNumberFieldInput(TestVariablesVehicle.LICENSE_PLATE_NR)
        vehicleCategoryFieldInput(TestVariablesVehicle.VEHICLE_CATEGORY)
        vinFieldInput(TestVariablesVehicle.VIN)
        colorFieldInput(TestVariablesVehicle.COLOR)
        fuelTypeFieldInput(TestVariablesVehicle.FUEL_TYPE)
        selectVehicleGroup(TestVariablesVehicle.VEHICLE_GROUP)
        mileageKmFieldInput(TestVariablesVehicle.MILEAGE_KM)
        defectsFieldInput(TestVariablesVehicle.DEFECT)
        minimumAgeFieldInput(TestVariablesVehicle.MINIMUM_AGE)
    }

    private void checkCheckboxes() {
        checkboxAutomatic()
        checkboxGps()
        checkboxBlocked()
        checkboxActive()
    }

    private void saveVehicle() {
        saveButtonClick()
        successMessageCheck(TestVariables.SUCCESS_MESSAGE)
    }

    private void goToEditVehiclePage() {
        licenseNrFilterFieldInput(TestVariablesVehicle.LICENSE_PLATE_NR)
        editButtonClick(TestVariablesVehicle.LICENSE_PLATE_NR)
    }

    private void editVehicleData() {
        licensePlateNumberFieldInput(TestVariablesVehicle.LICENSE_PLATE_NR_EDIT)
        vehicleCategoryFieldInput(TestVariablesVehicle.VEHICLE_CATEGORY_EDIT)
        vinFieldInput(TestVariablesVehicle.VIN_EDIT)
        colorFieldInput(TestVariablesVehicle.COLOR_EDIT)
        fuelTypeFieldInput(TestVariablesVehicle.FUEL_TYPE_EDIT)
        selectVehicleGroup(TestVariablesVehicle.VEHICLE_GROUP_EDIT)
        mileageKmFieldInput(TestVariablesVehicle.MILEAGE_KM_EDIT)
        defectsFieldInput(TestVariablesVehicle.DEFECT_EDIT)
        minimumAgeFieldInput(TestVariablesVehicle.MINIMUM_AGE_EDIT)
    }

    private void editCheckboxes() {
        activatedCheckboxAutomatic()
        activatedCheckboxGps()
        deactivatedCheckboxBlocked()
        activatedCheckboxActive()
    }

    private void clickBackButton() {
        backButtonClick()
    }

    private void clickVehicleImportButton() {
        vehicleImportButtonClick()
    }

    private void checkElemets() {
        importFileFieldCheck()
        fileUploadButtonCheck()
        vehicleListImportButtonCheck()
    }

    // negative test create vehicle
    private void clickSaveButton() {
        saveButtonClick()
    }

    private void checkLicensePlateNumberFieldErrorMessage(boolean errorExpected, String errorMessage) {
        licensePlateNumberFieldErrorMessage(errorExpected, errorMessage)
    }

    private void checkVehicleCategoryFieldErrorMessage(boolean errorExpected, String errorMessage) {
        vehicleCategoryFieldErrorMessage(errorExpected, errorMessage)
    }
}
