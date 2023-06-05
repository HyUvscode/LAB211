package s12doctormanagementprogram;

import java.util.HashMap;

public class DoctorHash {
    private HashMap<String, Doctor> doctorMap;

    public DoctorHash() {
        doctorMap = new HashMap<>();
    }

    public boolean addDoctor(Doctor doctor) throws Exception {
        if (doctorMap == null) {
            throw new Exception("Database does not exist");
        }

        if (doctor == null) {
            throw new Exception("Data does not exist");
        }

        String code = doctor.getCode();
        if (codeExists(code)) {
            throw new Exception("Doctor code [" + code + "] is duplicate");
        }

        doctorMap.put(code, doctor);
        return true;
    }

    public boolean updateDoctor(Doctor doctor) throws Exception {
        if (doctorMap == null) {
            throw new Exception("Database does not exist");
        }

        if (doctor == null) {
            throw new Exception("Data does not exist");
        }

        String code = doctor.getCode();
        if (!codeExists(code)) {
            throw new Exception("Doctor code [" + code + "] does not exist");
        }

        doctorMap.put(code, doctor);
        return true;
    }

    public boolean deleteDoctor(Doctor doctor) throws Exception {
        if (doctorMap == null) {
            throw new Exception("Database does not exist");
        }

        if (doctor == null) {
            throw new Exception("Data does not exist");
        }

        String code = doctor.getCode();
        if (!codeExists(code)) {
            throw new Exception("Doctor code [" + code + "] does not exist");
        }

        doctorMap.remove(code);
        return true;
    }
    
    public Doctor getDoctor(String code) {
        if (doctorMap == null || !codeExists(code)) {
            return null;
        }
        
        return doctorMap.get(code);
    }

    public HashMap<String, Doctor> searchDoctor(String input) throws Exception {
        if (doctorMap == null) {
            throw new Exception("Database does not exist");
        }

        if (input == null || input.isEmpty()) {
            throw new Exception("Data does not exist");
        }

        HashMap<String, Doctor> resultList = new HashMap<>();
        for (Doctor doctor : doctorMap.values()) {
            if (doctorContains(doctor, input)) {
                resultList.put(doctor.getCode(), doctor);
            }
        }

        return resultList;
    }

    public boolean codeExists(String code) {
        return doctorMap.containsKey(code);
    }

    private boolean doctorContains(Doctor doctor, String input) {
        return doctor.getCode().contains(input)
                || doctor.getName().contains(input)
                || doctor.getSpecialization().contains(input);
    }
}
