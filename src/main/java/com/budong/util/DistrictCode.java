package com.budong.util;

import java.util.Objects;

public class DistrictCode {
    private String districtName;
    private String districtCode;

    public DistrictCode() {
    }

    public DistrictCode(String districtName, String districtCode) {
        this.districtName = districtName;
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DistrictCode that = (DistrictCode) o;

        if (districtName != null ? !districtName.equals(that.districtName) : that.districtName != null) return false;
        return districtCode != null ? districtCode.equals(that.districtCode) : that.districtCode == null;
    }

    @Override
    public int hashCode() {
        int result = districtName != null ? districtName.hashCode() : 0;
        result = 31 * result + (districtCode != null ? districtCode.hashCode() : 0);
        return result;
    }
}
