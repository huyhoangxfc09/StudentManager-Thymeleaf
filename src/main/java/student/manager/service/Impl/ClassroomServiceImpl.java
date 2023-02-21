package student.manager.service.Impl;

import student.manager.model.Classroom;
import student.manager.service.interface_service.ICrudService;

import java.util.ArrayList;
import java.util.List;

public class ClassroomServiceImpl implements ICrudService<Classroom> {
    static List<Classroom> classroomList;
    public ClassroomServiceImpl(){
        classroomList =new ArrayList<>();
        classroomList.add(new Classroom(1,"C0822G1"));
        classroomList.add(new Classroom(2,"C0922H1"));
        classroomList.add(new Classroom(3,"C01022I1"));
        classroomList.add(new Classroom(4,"C1122K1"));
    }

    @Override
    public List<Classroom> findAll() {
        return classroomList;
    }

    @Override
    public void save(Classroom classroom) {
        classroomList.add(classroom);
    }

    @Override
    public void update(int id,Classroom classroom) {
        classroomList.set(id,classroom);
    }

    @Override
    public void delete(int id) {
        Classroom classroom = findById(id);
        if (classroom!=null){
            classroomList.remove(classroom);
        }
    }

    @Override
    public Classroom findById(int id) {
        Classroom classroom = null;
        for (Classroom e : classroomList) {
            if(e.getId()==id){
                classroom = e;
                break;
            }
        }
        return classroom;
    }
}
