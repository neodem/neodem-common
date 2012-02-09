package com.neodem.common.service;

import java.util.Locale;


/**
 * @author Vincent Fumo
 * @version 1.0
 */
public interface CurrencyFormatter {
    public String format(float amount, Locale locale);
    public String format(float amount);
    public String format(Float amount, Locale locale);
    public String format(Float amount);
}
