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
public class S12DoctorManagementProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DoctorManagementSystem doctorManagementSystem = new DoctorManagementSystem();
        Validation validation = new Validation();
//        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("DOCTOR MANAGEMENT");
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Search Doctor");
            System.out.println("5. Exit");
            
            int option = validation.getInt("Please choose: ");

            switch (option) {
                case 1:
                    doctorManagementSystem.addDoctor();
                    break;
                case 2:
                    doctorManagementSystem.updateDoctor();
                    break;
                case 3:
                    doctorManagementSystem.deleteDoctor();
                    break;
                case 4:
                    doctorManagementSystem.searchDoctor();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option. Please enter (1-5).");
                    break;
            }

            System.out.println();
        }
    }
}
