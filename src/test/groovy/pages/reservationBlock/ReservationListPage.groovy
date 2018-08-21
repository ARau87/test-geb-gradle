package pages.reservationBlock

import geb.Page
import models.Reservation
import testVariables.TestVariables

class ReservationListPage extends Page {

    static url = TestVariables.URL + "reservations/list"

    static at = {
        pageTitle.isDisplayed()
    }

    static content = {
        pageTitle               { $('h2', class: 'listTitle') }

        reservationNrFilter     { $('input', id: 'yadcf-filter--reservationListTableId-1')}
        companyFilter           { $('input', id: 'yadcf-filter--reservationListTableId-2')}
        lastnameFilter          { $('input', id: 'yadcf-filter--reservationListTableId-3')}
        firstnameFilter         { $('input', id: 'yadcf-filter--reservationListTableId-4')}
        pickupTimeFilter        { $('input', id: 'yadcf-filter--reservationListTableId-5')}
        returnTimeFilter        { $('input', id: 'yadcf-filter--reservationListTableId-6')}
        vehicleTypeFilter       { $('input', id: 'yadcf-filter--reservationListTableId-7')}
        licensePlateFilter      { $('input', id: 'yadcf-filter--reservationListTableId-8')}
        statusFilter            { $('select', id: 'yadcf-filter--reservationListTableId-9')}
        terminalFilter          { $('select', id: 'yadcf-filter--reservationListTableId-10')}
        groupFilter             { $('select', id: 'yadcf-filter--reservationListTableId-11')}

        previousBtn             { $('a', id: 'reservationListTableId_previous')}
        nextBtn                 { $('a', id: 'reservationListTableId_next')}

        newReservationBtn       { $('button', type: 'submit')}

        table                   { $('#reservationListTableId')}
        tableBody               { table.$('tbody')}

        cancelReservationBtn    { table.$('img[src="/rac/images/icon_stornieren.png"]')}
        editReservationBtn    { table.$('img[src="/rac/images/icon_bearbeiten.png"]')}


    }

    boolean findReservationByReservationNr(Reservation reservation){

        reservationNrFilter = reservation.reservationNr

        def cell = getTableCell(0,1)

        return(cell.text() == reservation.reservationNr)
    }


    boolean findReservationByCompany(Reservation reservation){

        companyFilter = reservation.company

        def cell = getTableCell(0,2)

        return(cell.text() == reservation.company)
    }

    boolean findReservationByLastname(Reservation reservation){

        lastnameFilter = reservation.lastname

        def cell = getTableCell(0,3)

        return(cell.text() == reservation.lastname)
    }

    boolean findReservationByFirstname(Reservation reservation){

        firstnameFilter = reservation.firstname

        def cell = getTableCell(0,4)

        return(cell.text() == reservation.firstname)
    }

    def getTableCell(int rowNr, int cellNr){
        sleep(1000)
        waitFor {tableBody.children()}
        return tableBody.children()[rowNr].children()[cellNr]

    }

    void pressNewReservationBtn(){
        newReservationBtn.click()
    }

    boolean cancelReservation(Reservation reservation){

        if(this.findReservationByReservationNr(reservation)){

            def parent = cancelReservationBtn.parent()
            parent.jquery.attr('onclick', 'return true')
            cancelReservationBtn.click()

            return true

        }

        else {

            return false

        }
    }

    boolean editReservation(Reservation reservation){

        if(this.findReservationByReservationNr(reservation)){

            editReservationBtn.click()

        }
        else {
            return false
        }
    }


}
