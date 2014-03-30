/* file 	: 	FixedLengthDataRecord.java
 * created 	:	May 10, 2006
 * modified :	
 */

package com.neodem.common.recordProcessing.records;

import com.neodem.common.recordProcessing.fields.DataField;
import com.neodem.common.recordProcessing.fields.FixedLengthDataField;
import org.apache.commons.lang.StringUtils;

import java.util.Iterator;
import java.util.List;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 */
public class FixedLengthDataRecord extends DataRecord {

    /**
     *
     */
    public FixedLengthDataRecord(int size) {
        super(size);
    }

    /**
     * will parse the record according to the saved structure from one single string
     *
     * @param line
     */
    public void parseLine(String line) {
        List fieldList = getOrderedFieldList();
        for (Iterator iter = fieldList.iterator(); iter.hasNext(); ) {
            FixedLengthDataField field = (FixedLengthDataField) iter.next();
            field.setData(StringUtils.substring(line, field.getStart(), (field.getEnd() + 1)));
            field.getEnd();
        }
    }

    /**
     * will create a data string using the saved structure
     *
     * @return
     */
    public String getLine() {
        int size = fields.size();
        StringBuilder b = new StringBuilder(size * 10);
        List fieldList = getOrderedFieldList();
        for (Iterator iter = fieldList.iterator(); iter.hasNext(); ) {
            DataField field = (DataField) iter.next();
            b.append(field.getData());
        }

        return b.toString();
    }
}
