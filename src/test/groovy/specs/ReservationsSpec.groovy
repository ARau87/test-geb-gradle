package specs

import geb.spock.GebSpec
import models.Reservation
import pages.LoginPage
import pages.MainPage
import pages.reservationBlock.CreateReservationPage
import pages.reservationBlock.EditReservationPage
import pages.reservationBlock.ReservationListPage

class ReservationsSpec extends GebSpec{

    def "p_find_reservation"() {

        given: "I log in as administrator"
            to LoginPage
            at LoginPage
                logInAsAdministrator()

        when: "I am on the reservation page"
            at MainPage
                reservationsLinkClick()
            at ReservationListPage

        then: "I want to find the reservation with reservation number 1"
            at ReservationListPage
                findReservationByReservationNr( new Reservation('1'))

    }

    def "p_create_reservation"() {

        Reservation randomReservation = new Reservation()

        given: "I log in as administrator"
        to LoginPage
        at LoginPage
        logInAsAdministrator()

        when: "I go to the create reservation page and create a new reservation"
        at MainPage
        reservationsLinkClick()
        at ReservationListPage
        pressNewReservationBtn()
        at CreateReservationPage
        createReservation(randomReservation)

        then: "I can find the reservation in the reservations list"
        to ReservationListPage
        at ReservationListPage
        findReservationByReservationNr(randomReservation)
    }


    def "p_create_reservation_with_company"() {

            Reservation randomReservationWithCompany = new Reservation()
            randomReservationWithCompany.customerType = 'company'

            given: "I log in as administrator"
            to LoginPage
            at LoginPage
            logInAsAdministrator()

            when: "I go to the create reservation page and create a new reservation with cutomertype company"
            at MainPage
            reservationsLinkClick()
            at ReservationListPage
            pressNewReservationBtn()
            at CreateReservationPage
            createReservation(randomReservationWithCompany)

            then: "I can find the reservation in the reservations list"
            to ReservationListPage
            at ReservationListPage
            findReservationByReservationNr(randomReservationWithCompany)

    }

    def "p_cancel_reservation"() {

        Reservation randomReservation = new Reservation()

        given: "I log in as administrator"
        to LoginPage
        at LoginPage
        logInAsAdministrator()

        when: "I go to the create reservation page and create a new reservation with cutomertype company"
        at MainPage
        reservationsLinkClick()
        at ReservationListPage
        pressNewReservationBtn()
        at CreateReservationPage
        createReservation(randomReservation)

        then: "I can find the reservation in the reservations list"
        to ReservationListPage
        at ReservationListPage
        cancelReservation(randomReservation)


    }

    def "p_edit_reservation"() {

        Reservation randomReservation = new Reservation()
        Reservation editedReservation = new Reservation()

        given: "I log in as administrator"
        to LoginPage
        at LoginPage
        logInAsAdministrator()

        when: "I go to the create reservation page and create a new reservation with cutomertype company"
        at MainPage
        reservationsLinkClick()
        at ReservationListPage
        pressNewReservationBtn()
        at CreateReservationPage
        createReservation(randomReservation)

        then: "I can find the reservation in the reservations list"
        to ReservationListPage
        at ReservationListPage
        editReservation(randomReservation)
        at EditReservationPage
        changeReservationTo(editedReservation)
        to ReservationListPage
        at ReservationListPage
        findReservationByReservationNr(editedReservation)

    }

}
