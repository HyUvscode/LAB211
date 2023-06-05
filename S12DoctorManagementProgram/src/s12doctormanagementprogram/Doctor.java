/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s12doctormanagementprogram;

/**
 *
 * @author khuakhanhhuy
 */
public class Doctor {

    private String code;
    private String name;
    private String specialization;
    private int availability;

    public Doctor(String code, String name, String specialization, int availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getAvailability() {
        return availability;
    }
}
