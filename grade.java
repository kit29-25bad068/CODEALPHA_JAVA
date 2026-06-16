import java.util.*;
public class grade {
    String name;
    ArrayList<Integer> grades;

    public grade(String name){
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade){
        grades.add(grade);
    }

    public double getAverage(){
        if(grades.isEmpty()){
            System.out.println("No grades available for " + name);
            return 0;
        }else{
            int sum = 0;
            for(int grade: grades){
                sum += grade;
            }
            double avrg = (double)sum/grades.size();
            return avrg;
        }
    }

    public int getHighest(){
        if(grades.isEmpty()){
            System.out.println("No grades available for " + name);
            return 0;
        }else{
            int highest = grades.get(0);
            for(int grade: grades){
                if(grade > highest){
                    highest = grade;
                }
            }
            return highest;
        }
    }

    public int getLowest(){
        if(grades.isEmpty()){
            System.out.println("No grades available for " + name);
            return 0;
        }else{
            int lowest = grades.get(0);
            for(int grade: grades){
                if(grade < lowest){
                    lowest = grade;
                }
            }
            return lowest;
        }
    }

    public String getName(){
        return name;
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        ArrayList<grade> students = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("\n---Menu---");
            System.out.println("1. Add Student");
            System.out.println("2. View Specific Student Report");
            System.out.println("3. View All Students Report");
            System.out.println("4. Highest Grade in Class");
            System.out.println("5. Lowest Grade in Class");
            System.out.println("6. Average of Entire Class");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter student name: ");
                    String name = s.next();
                    grade newStudent = new grade(name);
                    System.out.print("Enter number of grades: ");
                    int numGrades = s.nextInt();
                    for(int i = 0; i < numGrades; i++){
                        System.out.print("Enter grade " + (i+1) + ": ");
                        int g = s.nextInt();
                        newStudent.addGrade(g);
                    }
                    students.add(newStudent);
                    System.out.println("Student " + name + " added successfully!");
                    break;

                case 2:
                    if(students.isEmpty()){
                        System.out.println("No students added yet.");
                        break;
                    }
                    System.out.print("Enter student name: ");
                    String nameToView = s.next();
                    grade studentToView = null;
                    for(grade g: students){
                        if(g.getName().equals(nameToView)){
                            studentToView = g;
                            break;
                        }
                    }
                    if(studentToView != null){
                        System.out.println("\n--- Student Report ---");
                        System.out.println("Student : " + studentToView.getName());
                        System.out.println("Average : " + studentToView.getAverage());
                        System.out.println("Highest : " + studentToView.getHighest());
                        System.out.println("Lowest  : " + studentToView.getLowest());
                    }else{
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    if(students.isEmpty()){
                        System.out.println("No students added yet.");
                        break;
                    }
                    System.out.println("\n--- All Students Report ---");
                    for(grade g: students){
                        System.out.println("Student : " + g.getName());
                        System.out.println("Average : " + g.getAverage());
                        System.out.println("Highest : " + g.getHighest());
                        System.out.println("Lowest  : " + g.getLowest());
                        System.out.println();
                    }
                    break;

                case 4:
                    if(students.isEmpty()){
                        System.out.println("No students added yet.");
                        break;
                    }
                    int classHighest = students.get(0).getHighest();
                    String highestStudent = students.get(0).getName();
                    for(grade g: students){
                        if(g.getHighest() > classHighest){
                            classHighest = g.getHighest();
                            highestStudent = g.getName();
                        }
                    }
                    System.out.println("\nHighest grade in class: " + classHighest + " (by " + highestStudent + ")");
                    break;

                case 5:
                    if(students.isEmpty()){
                        System.out.println("No students added yet.");
                        break;
                    }
                    int classLowest = students.get(0).getLowest();
                    String lowestStudent = students.get(0).getName();
                    for(grade g: students){
                        if(g.getLowest() < classLowest){
                            classLowest = g.getLowest();
                            lowestStudent = g.getName();
                        }
                    }
                    System.out.println("\nLowest grade in class: " + classLowest + " (by " + lowestStudent + ")");
                    break;

                case 6:
                    if(students.isEmpty()){
                        System.out.println("No students added yet.");
                        break;
                    }
                    double totalAvg = 0;
                    for(grade g: students){
                        totalAvg += g.getAverage();
                    }
                    double classAvg = totalAvg / students.size();
                    System.out.println("\nClass Average: " + classAvg);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    s.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
