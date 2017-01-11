package utils;

import java.text.DecimalFormat;

/**
 * Created by thiagoyf on 1/10/17.
 */

public class DateTimeFormat {
    // Date Format
    // big-endian for database
    // little-endian dd-mm-yyyy
    // middle-endian mm-dd-yyyy
    public static final int BIG_ENDIAN = 0;
    public static final int LITTLE_ENDIAN = 1;
    public static final int MIDDLE_ENDIAN = 2;

    /**
     * Format the string to a 2 digits string
     *
     * @param string
     * @return formated 2 digits string
     */
    public static String twoDigits(String string) {
        DecimalFormat decimalFormat = new DecimalFormat("00");
        return decimalFormat.format(string);
    }

    /**
     * Format a integer to a string with 2 digits
     *
     * @param i
     * @return formated 2 digits string
     */
    public static String twoDigits(int i) {
        DecimalFormat decimalFormat = new DecimalFormat("00");
        return decimalFormat.format(i);
    }

    /**
     * Format the string to a 4 digits string
     *
     * @param string
     * @return formated 4 digits string
     */
    public static String fourDigits(String string) {
        DecimalFormat decimalFormat = new DecimalFormat("0000");
        return decimalFormat.format(string);
    }

    /**
     * Format a integer to a string with 4 digits
     *
     * @param i
     * @return formated 4 digits string
     */
    public static String fourDigits(int i) {
        DecimalFormat decimalFormat = new DecimalFormat("0000");
        return decimalFormat.format(i);
    }

    /**
     * It receives the year, month, day, format and separation to format the date. Example:
     * year = 2017, month = 01, day = 10, format = BIG_ENDIAN, separtion = "-", results in
     * 2017-01-10
     *
     * @param year       number representing year
     * @param month      being 1 = January, 2 = February, ... 12 = December
     * @param day        being 1 the first day of the month
     * @param format     being BIG_ENDIAN = yyyy-mm-dd, LITTLE_ENDIAN = dd-mm-yyyy and
     *                   MIDDLE_ENDIAN = mm-dd-yyyy
     * @param separation being "-" -> yyyy-mm-dd, "/" -> yyyy/mm/dd and "." yyyy.mm.dd
     * @return date formated
     */
    public static String dateFormat(String year, String month, String day, int format, String
            separation) throws Exception {
        if (!separation.equals("-") && !separation.equals("/") && !separation.equals(".")) {
            throw new Exception("There is no such separation, please inform a valid separation: " +
                    "\"-\", \"/\" or \".\"");
        }

        if (format != BIG_ENDIAN && format != LITTLE_ENDIAN && format != MIDDLE_ENDIAN) {
            throw new Exception("There is no such format, please inform a valid format: " +
                    "DateTimeFormat.BIG_ENDIAN, DateTimeFormat.LITTLE_ENDIAN or DateTimeFormat" +
                    ".MIDDLE_ENDIAN");
        }

        String date = null;

        switch (format) {
            case BIG_ENDIAN:
                date = fourDigits(year) + separation + twoDigits(month) + separation + twoDigits
                        (day);
                break;
            case LITTLE_ENDIAN:
                date = twoDigits(day) + separation + twoDigits(month) + separation + fourDigits
                        (year);
                break;
            case MIDDLE_ENDIAN:
                date = twoDigits(month) + separation + twoDigits(day) + separation + fourDigits
                        (year);
                break;
            default:
                break;
        }

        return date;
    }

    /**
     * It receives the year, month, day, format and separation to format the date. Example:
     * year = 2017, month = 01, day = 10, format = BIG_ENDIAN, separtion = "-", results in
     * 2017-01-10
     *
     * @param year       number representing year
     * @param month      being 1 = January, 2 = February, ... 12 = December
     * @param day        being 1 the first day of the month
     * @param format     being BIG_ENDIAN = yyyy-mm-dd, LITTLE_ENDIAN = dd-mm-yyyy and
     *                   MIDDLE_ENDIAN = mm-dd-yyyy
     * @param separation being "-" -> yyyy-mm-dd, "/" -> yyyy/mm/dd and "." yyyy.mm.dd
     * @return date formated
     */
    public static String dateFormat(int year, int month, int day, int format, String
            separation) throws Exception {
        if (!separation.equals("-") && !separation.equals("/") && !separation.equals(".")) {
            throw new Exception("There is no such separation, please inform a valid separation: " +
                    "\"-\", \"/\" or \".\"");
        }

        if (format != BIG_ENDIAN && format != LITTLE_ENDIAN && format != MIDDLE_ENDIAN) {
            throw new Exception("There is no such format, please inform a valid format: " +
                    "DateTimeFormat.BIG_ENDIAN, DateTimeFormat.LITTLE_ENDIAN or DateTimeFormat" +
                    ".MIDDLE_ENDIAN");
        }

        String date = null;

        switch (format) {
            case BIG_ENDIAN:
                date = fourDigits(year) + separation + twoDigits(month) + separation + twoDigits
                        (day);
                break;
            case LITTLE_ENDIAN:
                date = twoDigits(day) + separation + twoDigits(month) + separation + fourDigits
                        (year);
                break;
            case MIDDLE_ENDIAN:
                date = twoDigits(month) + separation + twoDigits(day) + separation + fourDigits
                        (year);
                break;
            default:
                break;
        }

        return date;
    }

    /**
     * Receive the string hour and string minute then format it to hour:minute
     * @param hour string representing hour
     * @param minute string representing minute
     * @return formated string hour:minute
     */
    public static String timeFormat(String hour, String minute){
        return twoDigits(hour) + ":" + twoDigits(minute);
    }

    /**
     * Receive integer hour and integer minute then format it to hour:minute
     * @param hour integer representing hour
     * @param minute integer representing minute
     * @return formated string hour:minute
     */
    public static String timeFormat(int hour, int minute){
        return twoDigits(hour) + ":" + twoDigits(minute);
    }
}
