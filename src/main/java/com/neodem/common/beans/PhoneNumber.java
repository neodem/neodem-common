package com.neodem.common.beans;

public class PhoneNumber extends AbstractBean {
private String area;
private String prefix;
private String suffix;
private String extension;
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public String getExtension() {
	return extension;
}
public void setExtension(String extension) {
	this.extension = extension;
}
public String getPrefix() {
	return prefix;
}
public void setPrefix(String prefix) {
	this.prefix = prefix;
}
public String getSuffix() {
	return suffix;
}
public void setSuffix(String suffix) {
	this.suffix = suffix;
}

}
