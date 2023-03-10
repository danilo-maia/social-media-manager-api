package com.danilomaia.workshopspringbootmongodb.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class URL {
    public static String decodeParam(String text){
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }

    public static LocalDate convertDate(String textDate, LocalDate defaultValue){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.of("UTC"));
        try {
            return LocalDate.parse(textDate, formatter);
        } catch (DateTimeParseException e) {
            return defaultValue;
        }
    }
}
