package br.com.digitalwallet.util;

import java.time.Instant;
import java.util.Date;

public class DateUtil {

    public static Date getDateTimeNow(){
        Date input = new Date();
        Instant instant = input.toInstant();
        return Date.from(instant);
    }
}
