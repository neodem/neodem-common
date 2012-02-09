
package com.neodem.common.service.impl;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import com.neodem.common.service.DateFormatter;


/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class MediumWebDateFormatter implements DateFormatter {

    private static final int DF_STYLE = DateFormat.MEDIUM;
    
    public MediumWebDateFormatter() {
        super();
    }

    public String format(Date date, Locale locale) {
        if(locale == null) return format(date);
        if(date == null) return null;
        
        DateFormat df = DateFormat.getDateInstance(DF_STYLE, locale);
        
        return df.format(date);
    }

    public String format(Date date) {
        if(date == null) return null;
        
        DateFormat df = DateFormat.getDateInstance(DF_STYLE);
        
        return df.format(date);
    }

}
