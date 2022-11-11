import java.util.*;
import java.io.*;

/********* MENU OF SRS **********/

class MainMenu {
    public void menu() {
        System.out.println("\t\t***************");
        System.out.println("\t\t\t  STUDENT RECORD SYSTEM");
        System.out.println("\t\t***************");
        System.out.println("\t\t\t    --------------------");
        System.out.println("\t\t\t     ~$ Keshav Agarwal");
        System.out.println("\t\t\t     ~$ Ashmit  Shukla");
        System.out.println("\t\t\t     ~$ Ridham Goel");
        System.out.println("\t\t\t     ~$ Pranjal Gangwar");
        System.out.println("\t\t\t    --------------------");
        System.out.println("\n\nPress 1 : To Add Student's Details");
        System.out.println("Press 2 : To view Student's Details ");
        System.out.println("Press 3 : To Remove Student's Record");
        System.out.println("Press 4 : To Update Student's Details");
        System.out.println("Press 5 : To Exit the SRS Portal");

    }
}

/******** To add details of Student *******/
class Student_Add {
    public void createFile() {
        Scanner sc = new Scanner(System.in);

        StudentDetail stu = new StudentDetail();
        stu.getInfo();
        try {
            File f1 = new File("file" + stu.student_id + ".txt");
            if (f1.createNewFile()) {
                FileWriter myWriter = new FileWriter("file" + stu.student_id + ".txt");
                myWriter.write("Student ID:" + stu.student_id + "\n" + "Student Name     :" + stu.name + "\n" +
                        "Father's Name     :" + stu.father_name + "\n" + "Student Contact  :" + stu.student_contact
                        + "\n" +
                        "Email Information :" + stu.email + "\n" + "Student branch :" + stu.branch + "\n" +
                        "Student GPA   :" + stu.student_gpa);
                myWriter.close();
                System.out.println("\nStudent has been Added :)\n");

                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            } else {
                System.out.println("\nStudent already exists :(");
                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/******** Taking Student Details ********/

class StudentDetail {
    String name;
    String father_name;
    String email;
    String branch;
    String student_id;
    String student_gpa;
    String student_contact;

    public void getInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student's name --------: ");
        name = sc.nextLine();
        System.out.print("Enter Student's Father name -: ");
        father_name = sc.nextLine();
        System.out.print("Enter Student's ID ----------: ");
        student_id = sc.nextLine();
        System.out.print("Enter Student's Email ID ----: ");
        email = sc.nextLine();
        System.out.print("Enter Student's branch ----: ");
        branch = sc.nextLine();
        System.out.print("Enter Student contact Info --: ");
        student_contact = sc.nextLine();
        System.out.print("Enter Student's GPA ------: ");
        student_gpa = sc.nextLine();
    }
}

/******** To Show details of Student *******/

class Student_Show {
    public void viewFile(String s) throws Exception {
        File file = new File("file" + s + ".txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}

/********** To Remove Student **********/

class Student_Remove {
    public void removeFile(String ID) {
        try {

            File file = new File("file" + ID + ".txt");
            if (file.exists()) {
                if (file.delete()) {
                    System.out.println("\nStudent's Record has been removed Successfully");
                }
            } else {
                System.out.println("\nStudent's Record does not exists :( ");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

/******** To Update details of Student *******/

class Student_Update {
    public void updateFile(String s, String o, String n) throws IOException {
        File file = new File("file" + s + ".txt");
        Scanner sc = new Scanner(file);
        String fileContext = "";
        while (sc.hasNextLine()) {
            fileContext = fileContext + "\n" + sc.nextLine();
        }
        FileWriter myWriter = new FileWriter("file" + s + ".txt");
        fileContext = fileContext.replaceAll(o, n);
        myWriter.write(fileContext);
        myWriter.close();

    }
}

/******** To Exit from the SRS Portal *******/

class CodeExit {
    public void out() {
        System.out.println("\n***************");
        System.out.println("$  Thank You For Using our Software :) ");
        System.out.println("***************");
        System.out.println("\t\t/~  by Keshav Agarwal\n");
        System.out.println("\t\t/~  by Ashmit Shukla\n");
        System.out.println("\t\t/~  by Ridham Goel\n");
        System.out.println("\t\t/~  by Pranjal Gangwar\n");
        System.exit(0);
    }
}

/********** Main Class ************/
class StudentRecordSystem {
    public static void main(String arv[]) {
        /* To clear the output Screen */
        System.out.print("\033[H\033[2J");

        Scanner sc = new Scanner(System.in);
        Student_Show epv = new Student_Show();

        int i = 0;

        /* Calling Mainmenu Class function */
        MainMenu obj1 = new MainMenu();
        obj1.menu();

        /* Initialising loop for Menu Choices */
        while (i < 6) {

            System.out.print("\nPlease Enter choice :");
            i = Integer.parseInt(sc.nextLine());
            /* Switch Case Statements */
            switch (i) {
                case 1: {
                    /* Creating class's object and calling Function using that object */
                    Student_Add ep = new Student_Add();
                    ep.createFile();

                    System.out.print("\033[H\033[2J");
                    obj1.menu();
                    break;
                }
                case 2: {
                    System.out.print("\nPlease Enter Student's ID :");
                    String s = sc.nextLine();
                    try {
                        epv.viewFile(s);
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    System.out.print("\nPress Enter to Continue...");
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    obj1.menu();
                    break;
                }
                case 3: {
                    System.out.print("\nPlease Enter Student's ID :");
                    String s = sc.nextLine();
                    Student_Remove epr = new Student_Remove();
                    epr.removeFile(s);

                    System.out.print("\nPress Enter to Continue...");
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    obj1.menu();
                    break;
                }
                case 4: {
                    System.out.print("\nPlease Enter Student's ID :");
                    String I = sc.nextLine();
                    try {
                        epv.viewFile(I);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    Student_Update epu = new Student_Update();
                    System.out.print("Please Enter the detail you want to Update :");
                    System.out.print("\nFor Example :\n");
                    System.out.println(
                            "If you want to Change the Name, then Enter Current Name and Press Enter. Then write the new Name then Press Enter. It will Update the Name.\n");
                    String s = sc.nextLine();
                    System.out.print("Please Enter the Updated Info :");
                    String n = sc.nextLine();
                    try {
                        epu.updateFile(I, s, n);

                        System.out.print("\nPress Enter to Continue...");
                        sc.nextLine();
                        System.out.print("\033[H\033[2J");
                        obj1.menu();
                        break;
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
                case 5: {
                    CodeExit obj = new CodeExit();
                    obj.out();
                }
            }
        }
    }
}