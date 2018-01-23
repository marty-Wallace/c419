package labs.lab1;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * An administrative body that has functions involving classes, students, profs etc...
 */
public class Administration {

    /**
     * returns an array of students whose last name begins with the given character
     * @param class1 class whose students we are inspecting
     * @param start character we are concerned with
     */
    public Student[] listStudents(UniClass class1, char start){
        Student[] ret = Stream.of(class1.getStudents())
                                .filter(student ->
                                        student.getName() != null &&
                                        student.getName().indexOf(" ") + 1 < student.getName().length() &&
                                        student.getName().split(" ")[1].startsWith(Character.toString(start)))
                                .toArray(Student[]::new);
        return ret.length > 0 ? ret : null;
    }

    /**
     * compares two lists of students and returns the common students (or set intersection)
     * @param class1 list of students
     * @param class2 second list of students
     */
    public ArrayList<Student> intersection(Student[] class1,Student[] class2){
        ArrayList<Student> list = new ArrayList<>();
        //alter this method to conform to the expected test result in AdministrationTest in the case of an empty list
        
        for (Student stud1: class1){
            for (Student stud2: class2){

                if(stud1.equals(stud2) && !list.contains(stud1)){
                    list.add(stud1);
                }

            }
        }

        return list.size() > 0 ? list : null;
    }
}
