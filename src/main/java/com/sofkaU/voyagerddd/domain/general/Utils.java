package com.sofkaU.voyagerddd.domain.general;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static Boolean validateDateStrings(String start,String end){
        DateTimeFormatter f = DateTimeFormatter.ofPattern( "uuuu/MM/dd" );

        LocalDateTime startDate = LocalDateTime.parse( start , f ) ;
        LocalDateTime endDate = LocalDateTime.parse( end , f ) ;
        return startDate.isBefore( endDate ) ;
    }
}
