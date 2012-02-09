
package com.neodem.common.service.impl;

import java.text.NumberFormat;
import java.util.Locale;

import com.neodem.common.service.CurrencyFormatter;



/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class StandardWebCurrencyFormatter implements CurrencyFormatter {
    
    public StandardWebCurrencyFormatter() {
        super();
    }

    public String format(float amount, Locale locale) {
        if(locale == null) return format(amount);
        
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        
        return nf.format(amount);
    }

    public String format(float amount) {
        
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        
        return nf.format(amount);
    }

    public String format(Float amount, Locale locale) {
        if(amount == null) return null;
        return format(amount.floatValue(), locale);
    }

    public String format(Float amount) {
        if(amount == null) return null;
        return format(amount.floatValue());
    }

}
