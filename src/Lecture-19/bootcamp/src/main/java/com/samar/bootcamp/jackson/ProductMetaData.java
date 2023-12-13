package com.samar.bootcamp.jackson;

import lombok.ToString;

@ToString
public class ProductMetaData {
    private String majorVersion;
    private String minorVersion;

    public String getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(String majorVersion) {
        this.majorVersion = majorVersion;
    }

    public String getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(String minorVersion) {
        this.minorVersion = minorVersion;
    }
}
