package com.perched.peacock.parkspot.mgmt.commons;

import com.perched.peacock.parkspot.mgmt.dto.BookingInformationDto;

import java.util.Date;

public class Utils {

    public static Double getTotalCost(Double price,Date exitDate,Date entryDate) {
        if (exitDate== null) {
            return 0.0;
        }
       return price * hoursDifference(exitDate, entryDate);

    }

    private static int hoursDifference(Date date1, Date date2) {

        final int MILLI_TO_HOUR = 1000 * 60 ;
        //final int MILLI_TO_HOUR = 1000 * 60 * 60;
        return (int) (date1.getTime() - date2.getTime()) / MILLI_TO_HOUR;
    }

}
