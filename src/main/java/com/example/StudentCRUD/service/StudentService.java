package com.example.StudentCRUD.service;

import com.example.StudentCRUD.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1,"A","AI"),
                    new Student(2,"B","Blockchain")
            )
    );

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudentByRollNo(int rollNo) {
        int index = 0;
        for(int i=0 ; i<students.size() ; i++){
            if(students.get(i).getRollNo()==rollNo)
            {
                index = i;
            }
        }
        return students.get(index);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String updateStudent(Student student) {
        int index=0;
        boolean found = false;
        for(int i=0; i<students.size() ; i++){
            if(students.get(i).getRollNo()==student.getRollNo()){
                index=i;
                found = true;
                break;
            }
        }
        if(!found ){ return "No such student exists";}
        else {
            students.set(index,student);
            return "Updation Success";
        }
    }

    public String deleteStudent(int rollNo) {
        int index=0;
        boolean found = false;
        for(int i=0; i<students.size(); i++){
            if(students.get(i).getRollNo() == rollNo){
                index = i;
                found = true;
            }
        }
        if(found){
            students.remove(index);
            return "Deleted successfully";
        }
        else{
            return "No such students exists";
        }
    }
}
