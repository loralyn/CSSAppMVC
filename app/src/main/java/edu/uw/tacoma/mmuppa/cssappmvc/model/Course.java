package edu.uw.tacoma.mmuppa.cssappmvc.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mmuppa on 4/13/15.
 */
public class Course implements Serializable {

    private String mCourseId;
    private String mShortDescription;
    private String mLongDescription;
    private String mPrereqs;


    public Course(String courseId, String shortDescription, String longDescription, String prereqs) {
        mCourseId = courseId;
        mShortDescription = shortDescription;
        mLongDescription = longDescription;
        mPrereqs = prereqs;
    }

    public String getCourseId() {
        return mCourseId;
    }

    public void setCourseId(String courseId) {
        mCourseId = courseId;
    }

    public String getShortDescription() {
        return mShortDescription;
    }

    public void setShortDescription(String shortDescription) {
        mShortDescription = shortDescription;
    }

    public String getLongDescription() {
        return mLongDescription;
    }

    public void setLongDescription(String longDescription) {
        mLongDescription = longDescription;
    }

    public String getPrereqs() {
        return mPrereqs;
    }

    public void setPrereqs(String prereqs) {
        mPrereqs = prereqs;
    }

    @Override
    public String toString() {
        return "Course{" +
                "mCourseId='" + mCourseId + '\'' +
                ", mShortDescription='" + mShortDescription + '\'' +
                ", mLongDescription='" + mLongDescription + '\'' +
                ", mPrereqs=" + mPrereqs +
                '}';
    }
}
