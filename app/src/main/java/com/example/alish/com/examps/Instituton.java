package com.example.alish.com.examps;

/**
 * Created by Alish on 2015/10/23.
 */
public class Instituton {
    private String universioty;
    private String school;
    private String major;

    public String getUniversioty() {
        return universioty;
    }

    public String getSchool() {
        return school;
    }

    public String getMajor() {
        return major;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setUniversioty(String universioty) {
        this.universioty = universioty;
    }

    public Instituton(String universioty, String school, String major) {
        this.universioty = universioty;
        this.school = school;
        this.major = major;
    }
}
