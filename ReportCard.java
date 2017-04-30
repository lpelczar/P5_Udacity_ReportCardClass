package com.example.lukasz.p5_udacity_reportcardclass;

import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.text.DecimalFormat;

public class ReportCard {

    //Declaring the variables
    private static final String UNIVERSITY_NAME = "Cracow University of Technology";
    private String fieldOfStudy;
    private String studentFirstName;
    private String studentLastName;
    private String dateOfDecision;
    private String semesterNumber;
    private HashMap<String, Double> hmap = new HashMap<String, Double>();

    /*
    * Custom constructor
    * @param field - field of Study
    * @param firstName - student first name
    * @param lastName - student last name
    * @param date - date of decision
    * @param semester - semester number
    */
    public ReportCard(String field, String firstName, String lastName, String date, String semester){
        fieldOfStudy = field;
        studentFirstName = firstName;
        studentLastName = lastName;
        dateOfDecision = date;
        semesterNumber = semester;
    }

    /*
    * Returns the contents of the class in a human-readable string.
    * At LEAST one grade must be added to HashMap before we can access this method.
    */
    @Override
    public String toString(){

        //These 2 lines of code makes grade point average in format with 2 decimal places.
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        return  "University Name: " + UNIVERSITY_NAME + "\n" +
                "Field of Study: " + fieldOfStudy +"\n" +
                "First Name: " + studentFirstName + "\n" +
                "Last Name: " + studentLastName + "\n" +
                "Decision Date: " + dateOfDecision + "\n" +
                "Semester: " + semesterNumber + "\n" +
                getGrades() +
                "Grade Point Average: " + df.format(getGradePointAverage());
    }

    /*
    * This method returns all the grades in a String using Iterator.
    */
    public String getGrades(){

        String gradesList = "";
        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            gradesList += "Subject: " + mentry.getKey() + " Grade: " + mentry.getValue() + "\n";
        }
        return gradesList;
    }

    /*
    * This method returns a Grade Point Average from our grades using Iterator.
    */
    public double getGradePointAverage(){

        double gradesSum = 0;
        double numberOfSubjects = 0;
        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            gradesSum += Double.parseDouble(mentry.getValue().toString());
        }
        numberOfSubjects += hmap.size();
        return gradesSum/numberOfSubjects;

    }

    /*
    * Adds a grade to our object.
    * @param subjectName - name of the subject
    * @param subjectGrade - grade with decimal places (2 - 5)
    */
    public void addGrade(String subjectName, double subjectGrade){
        hmap.put(subjectName,subjectGrade);
    }

    /*
    * Removes chosen grade.
    * @param subjectName - name of the subject
    */
    public void removeGrade(String subjectName){
        hmap.remove(subjectName);
    }

    /*
    * Returns chosen grade.
    * @param subjectName - name of the subject
    */
    public double getGrade(String subjectName){
        return hmap.get(subjectName);
    }

    /*
    * Sets field of study.
    * @param field - field of study
    */
    public void setFieldOfStudy(String field){
        fieldOfStudy = field;
    }

    /*
    * Sets student first name.
    * @param firstName - student first name
    */
    public void setStudentFirstName(String firstName){
        studentFirstName = firstName;
    }

    /*
    * Sets student last name.
    * @param lastName - student first name
    */
    public void setStudentLastName(String lastName){
        studentLastName = lastName;
    }

    /*
    * Sets date of decision.
    * @param date - date of decision
    */
    public void setDateOfDecision(String date){
        dateOfDecision = date;
    }

    /*
    * Sets semester number.
    * @param semester - semester number.
    */
    public void setSemesterNumber(String semester){
        semesterNumber = semester;
    }

    /*
    * Gets field of study.
    */
    public String getFieldOfStudy(){
        return fieldOfStudy;
    }

    /*
    * Gets student first name.
    */
    public String getStudentFirstName(){
        return studentFirstName;
    }

    /*
    * Gets student last name.
    */
    public String getStudentLastName(){
        return studentLastName;
    }

    /*
    * Gets date of decision.
    */
    public String getDateOfDecision(){
        return dateOfDecision;
    }

    /*
    * Gets semester number.
    */
    public String getSemesterNumber(){
        return semesterNumber;
    }

}