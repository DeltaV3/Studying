package com.example.student_management.controllers;


import com.example.student_management.domain.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class StudentController {

    private List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1,"Laura Garcia", "laura.g@gmail.com",21,"Ciencias de la computacion"),
            new Student(2, "Carlos Fernandez","carlos.f@gmail.com",23,"Ingenieria mecanica"),
            new Student(3,  "Ana Martinez", "ana.m@gmail.com",22,"Administracion de empresas" ),
            new Student(4, "Miguel Lopez", "miguel.l@gmail.com",24,"Ingenieria Electrica")
    ));

    //Mostrar todos los alumnos
    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    //Consultar alumnos por ID
    @GetMapping("/{email}")
    public Student getStudent(@PathVariable String email) {
        for (Student s : students) {
            if (s.getEmail().equalsIgnoreCase(email)) {
                return s;
            }
        }
        return null; // Mala practica error 404
    }

    //Crear un nuevo alumno
    @PostMapping
    public Student postStudent(@RequestBody Student student) {
        students.add(student);

        return student;
    }

    //Modificacion total de un alumno
    @PutMapping
    public Student putStudent(@RequestBody Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                s.setName(student.getName());
                s.setEmail(student.getEmail());
                s.setAge(student.getAge());
                s.setCourse(student.getCourse());

                return s;
            }
        }
        return null;
    }

    //Modificacion parcial del estudiante
    @PatchMapping
    public Student patchStudent(@RequestBody Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                if(student.getName() != null){
                    s.setName(student.getName());
                }

                if(student.getEmail() != null){
                    s.setEmail(student.getEmail());
                }

                if (student.getAge() != 0){
                    s.setAge(student.getAge());
                }

                if(student.getCourse() != null){
                    s.setCourse(student.getCourse());
                }

                return s;
            }
        }
        return null;
    }


    //Eliminar alumno
    @DeleteMapping("/{id}")
    public Student deleteStudent(@PathVariable int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);

                return s;
            }
        }
        return null;
    }
}
