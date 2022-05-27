package com.quoctin.common;

import java.util.regex.Pattern;

public class Validate {
    Pattern pattern = Pattern.compile("^[a-zA-Z]+([.-]?\\w+)*@[a-z]+\\.(\\w+){2,}(\\.\\w{2,3})?");
    public static final String POSITIVE_INTEGERS_REGEX = "^\\+*\\d+$";
    public static final String POSITION_DOUBLE_REGEX = "^\\+*\\d+(\\.\\d+)*$";
    public static final  String CUSTOMER_CODE_REGEX = "^KH-\\d{4}$";
    public static final  String SERVICE_CODE_REGEX = "^DV-\\d{4}$";
    public static final String TELEPHONE_NUMBER_REGEX = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$";
    public static final String ID_CARD_REGEX = "^\\d{9}|\\d{12}$";
    public static final String EMAIL_ADDRESS_REGEX = "^[a-zA-Z]+([.-]?\\w+)*@[a-z]+\\.(\\w+){2,}(\\.\\w{2,3})?";
    public static final String DATE_TIME_REGEX = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";
    public static final String FULL_NAME_REGEX = "^\\p{Lu}\\p{Ll}+( \\p{Lu}\\p{Ll}+)*$";
}
