package com.neodem.common.service;

import java.util.Date;
import java.util.Locale;


/**
 * @author Vincent Fumo
 * @version 1.0
 */
public interface DateFormatter {
    public String format(Date date, Locale locale);
    public String format(Date date);
}
