package com.neodem.common.beans;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/** an empy bean that implements {@link Serializable} for general use.
 * Basic toString(), equals() and hashCode() methods are provided
 * @author Vincent Fumo
 * @version 1.0
 */
public abstract class AbstractSerializedBean implements Serializable {

    public AbstractSerializedBean() {
        super();
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

}