package specs

import geb.spock.GebSpec
import org.junit.Before
import pages.vehicleGroupBlock.CreateNewVehicleGroupPage
import pages.LoginPage
import pages.MainPage
import pages.vehicleGroupBlock.EditVehicleGroupPage
import pages.vehicleGroupBlock.VehicleGroupListPage
import testVariables.TestVariables
import testVariables.TestVariablesVehicleGroup

class VehicleGroupSpec extends GebSpec {

    @Before
    def "ASS RAC Admin login"() {
        to LoginPage
        logInAsAdministrator()
    }

    def "p_Create_New_Vehicle_Group"() {
        given: "I'm on Main page"
        at MainPage

        when: "I go to Vehicle Group List page"
        vehicleGroupsLinkClick()
        at VehicleGroupListPage

        then: "I go to Create New Vehicle Group page"
        clickNewVehicleGroupButton()
        at CreateNewVehicleGroupPage

        and: "I create new vehicle group"
        fillAllFields()
        saveVehicleGroup()

        and: "I'm on Edit Vehicle Group page"
        at EditVehicleGroupPage
    }

    def "p_Edit_Vehicle_Group"() {
        given: "I'm on Main page"
        at MainPage

        when: "I go to Vehicle Group List page"
        vehicleGroupsLinkClick()
        at VehicleGroupListPage

        then: "I go to Edit Vehicle Group page"
        goToEditVehiclePage()
        at EditVehicleGroupPage

        and: "I change vehicle group data"
        changeVehicleGroupData()
        saveVehicleGroup()
        checkData()

        and: "I go back to Vehicle Group List page"
        clickBackButton()
        at VehicleGroupListPage
        println("test")
    }

    private void clickNewVehicleGroupButton() {
        newVehicleGroupButtonClick()
    }

    private void fillAllFields() {
        vehicleGroupNameFieldInput(TestVariablesVehicleGroup.VEHICLE_GROUP_NAME)
        pricePerDayFieldInput(TestVariablesVehicleGroup.PRICE_PER_DAY)
        freeKmPerDayFieldInput(TestVariablesVehicleGroup.FREE_KM_PER_DAY)
        costProKmFieldInput(TestVariablesVehicleGroup.COST_PRO_KM)
        collisionDamageWaiverFieldInput(TestVariablesVehicleGroup.COLLISION_DAMAGE_WAIVER)
        passengerAccidentInsuranceFieldInput(TestVariablesVehicleGroup.PASSENGER_ACCIDENT_INSURANCE)
        minimumAgeFieldInput(TestVariablesVehicleGroup.MINIMUM_AGE)
        selfParticipationFieldInput(TestVariablesVehicleGroup.SELF_PARTICIPATION)
        reducedSelfParticipationFieldInput(TestVariablesVehicleGroup.REDUCED_SELF_PARTICIPATION)
    }

    private void saveVehicleGroup() {
        saveButtonClick()
        checkSuccessMessage(TestVariables.SUCCESS_MESSAGE)
    }

    private void goToEditVehiclePage() {
        nameFilterFieldInput(TestVariablesVehicleGroup.VEHICLE_GROUP_NAME)
        editButtonClick(TestVariablesVehicleGroup.VEHICLE_GROUP_NAME)
    }

    private void changeVehicleGroupData() {
        vehicleGroupNameFieldInput(TestVariablesVehicleGroup.VEHICLE_GROUP_NAME_EDIT)
        pricePerDayFieldInput(TestVariablesVehicleGroup.PRICE_PER_DAY_EDIT)
        freeKmPerDayFieldInput(TestVariablesVehicleGroup.FREE_KM_PER_DAY_EDIT)
        costProKmFieldInput(TestVariablesVehicleGroup.COST_PRO_KM_EDIT)
        collisionDamageWaiverFieldInput(TestVariablesVehicleGroup.COLLISION_DAMAGE_WAIVER_EDIT)
        passengerAccidentInsuranceFieldInput(TestVariablesVehicleGroup.PASSENGER_ACCIDENT_INSURANCE_EDIT)
        minimumAgeFieldInput(TestVariablesVehicleGroup.MINIMUM_AGE_EDIT)
        selfParticipationFieldInput(TestVariablesVehicleGroup.SELF_PARTICIPATION_EDIT)
        reducedSelfParticipationFieldInput(TestVariablesVehicleGroup.REDUCED_SELF_PARTICIPATION_EDIT)
    }

    private void checkData() {
        vehicleGroupNameFieldCheck(TestVariablesVehicleGroup.VEHICLE_GROUP_NAME_EDIT)
        pricePerDayFieldCheck(TestVariablesVehicleGroup.PRICE_PER_DAY_EDIT)
        freeKmPerDayFieldCheck(TestVariablesVehicleGroup.FREE_KM_PER_DAY_EDIT)
        costProKmFieldCheck(TestVariablesVehicleGroup.COST_PRO_KM_EDIT)
        collisionDamageWaiverFieldCheck(TestVariablesVehicleGroup.COLLISION_DAMAGE_WAIVER_EDIT)
        passengerAccidentInsuranceFieldCheck(TestVariablesVehicleGroup.PASSENGER_ACCIDENT_INSURANCE_EDIT)
        minimumAgeFieldCheck(TestVariablesVehicleGroup.MINIMUM_AGE_EDIT)
        selfParticipationFieldCheck(TestVariablesVehicleGroup.SELF_PARTICIPATION_EDIT)
        reducedSelfParticipationFieldCheck(TestVariablesVehicleGroup.REDUCED_SELF_PARTICIPATION_EDIT)
    }

    private void clickBackButton() {
        backButtonClick()
    }
}