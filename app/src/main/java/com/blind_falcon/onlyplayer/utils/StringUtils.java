package com.blind_falcon.onlyplayer.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StringUtils {
    public static String convertTimeStampToPlaytimeString(long timeStamp) {
        Date date = new Date(timeStamp);
        String pattern = timeStamp / 360000 > 1 ? "HH:mm:ss" : "mm:ss";
        DateFormat formatter = new SimpleDateFormat(pattern, Locale.ENGLISH);
        return formatter.format(date);
    }

    public static String convertByteFileSizeToString(String fileSizeInBytes) {
        Double byteSize = Double.parseDouble(fileSizeInBytes);
        return String.format(Locale.ENGLISH, "%.2f", byteSize);
    }
}
