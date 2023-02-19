package student.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import student.manager.model.Classroom;
import student.manager.model.Student;
import student.manager.service.Impl.ClassroomServiceImpl;
import student.manager.service.Impl.StudentServiceImpl;
import student.manager.service.interface_service.ICrudService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final ICrudService<Classroom> classroomICrudService;
    private final ICrudService<Student> studentICrudService;
    public StudentController(){
        classroomICrudService = new ClassroomServiceImpl();
        studentICrudService = new StudentServiceImpl(classroomICrudService);
    }
    @GetMapping("")
    public String listStudent(Model model){
        List<Student> students = studentICrudService.findAll();
        model.addAttribute("students",students);
        return "student/list";
    }
    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("classrooms",classroomICrudService.findAll());
        return "student/create";
    }
    @PostMapping("/create")
    public ModelAndView createStudent(@ModelAttribute Student student){
        studentICrudService.save(student);
        ModelAndView modelAndView = new ModelAndView("student/create");
        modelAndView.addObject("message","Tạo mới thành công");
        return modelAndView;
    }
    @GetMapping("/{id}/update")
    public String updateForm(@PathVariable int id, Model model){
        Student student = studentICrudService.findById(id);
        model.addAttribute("students",student);
        model.addAttribute("classrooms",classroomICrudService.findAll());
        return "student/update";
    }
    @PostMapping("/{id}/update")
    public ModelAndView updateClassroom(@ModelAttribute Student student,@PathVariable int id){
        Student studentUpdate = studentICrudService.findById(id);
        int index = studentICrudService.findAll().indexOf(studentUpdate);
        studentICrudService.update(index,student);
        ModelAndView modelAndView = new ModelAndView("student/update");
        modelAndView.addObject("students",student);
        modelAndView.addObject("classrooms",classroomICrudService.findAll());
        modelAndView.addObject("message","Update mới thành công");
        return modelAndView;
    }
    @GetMapping("{id}/delete")
    public String deleteForm(@PathVariable int id, Model model){
        Student student = studentICrudService.findById(id);
        model.addAttribute("students",student);
        return "student/delete";
    }
    @PostMapping("/{id}/delete")
    public ModelAndView deleteClassroom(@PathVariable int id){
        studentICrudService.delete(id);
        ModelAndView modelAndView = new ModelAndView("student/delete");
        modelAndView.addObject("message","Xóa thành công");
        return modelAndView;
    }
}
