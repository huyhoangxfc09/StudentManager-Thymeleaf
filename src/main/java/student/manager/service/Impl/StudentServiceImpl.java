package student.manager.service.Impl;

import student.manager.model.Classroom;
import student.manager.model.Student;
import student.manager.service.interface_service.ICrudService;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements ICrudService<Student> {
    private final List<Student> studentList;
    private  final ICrudService<Classroom> classroomICrudService;
    public StudentServiceImpl(ICrudService<Classroom> classroomICrudService){
        studentList = new ArrayList<>();
        studentList.add(new Student(1,"hoang",28,"thai binh",classroomICrudService.findAll().get(0)));
        studentList.add(new Student(2,"lien",34,"nam dinh",classroomICrudService.findAll().get(1)));
        studentList.add(new Student(3,"son",26,"hai phong",classroomICrudService.findAll().get(2)));
        studentList.add(new Student(4,"vu",22,"hai duong",classroomICrudService.findAll().get(3)));
        this.classroomICrudService = classroomICrudService;
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void save(Student student) {
        studentList.add(student);
    }

    @Override
    public void update(int id, Student student) {
        studentList.set(id,student);
    }

    @Override
    public void delete(int id) {
        Student student = findById(id);
        if (student!=null){
            studentList.remove(student);
        }
    }

    @Override
    public Student findById(int id) {
        Student student = null;
        for (Student e : studentList) {
            if(e.getId()==id){
                student = e;
                break;
            }
        }
        return student;
    }
}
