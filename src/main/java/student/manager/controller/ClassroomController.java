package student.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import student.manager.model.Classroom;
import student.manager.service.Impl.ClassroomServiceImpl;
import student.manager.service.interface_service.ICrudService;

import java.util.List;

@Controller
@RequestMapping("/classrooms")
public class ClassroomController {
    private final ICrudService<Classroom> iCrudService = new ClassroomServiceImpl();
    @GetMapping("")
    public String listClassroom(Model model){
        List<Classroom> classrooms = iCrudService.findAll();
        model.addAttribute("classrooms",classrooms);
        return "classroom/list";
    }
    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("classroom", new Classroom());
        return "classroom/create";
    }
    @PostMapping("/create")
    public ModelAndView createClassroom(@ModelAttribute Classroom classroom){
        iCrudService.save(classroom);
        ModelAndView modelAndView = new ModelAndView("classroom/create");
        modelAndView.addObject("message","Tạo mới thành công");
        return modelAndView;
    }
    @GetMapping("/{id}/update")
    public String updateForm(@PathVariable int id,Model model){
        Classroom classroom = iCrudService.findById(id);
        model.addAttribute("classrooms",classroom);
        return "classroom/update";
    }
    @PostMapping("/{id}/update")
    public ModelAndView updateClassroom(@ModelAttribute Classroom classroom,@PathVariable int id){
        Classroom classroomUpdate = iCrudService.findById(id);
        int index = iCrudService.findAll().indexOf(classroomUpdate);
        iCrudService.update(index,classroom);
        ModelAndView modelAndView = new ModelAndView("classroom/update");
        modelAndView.addObject("classrooms",classroom);
        modelAndView.addObject("message","Update mới thành công");
        return modelAndView;
    }
    @GetMapping("{id}/delete")
    public String deleteForm(@PathVariable int id, Model model){
        Classroom classroom = iCrudService.findById(id);
        model.addAttribute("classrooms",classroom);
        return "classroom/delete";
    }

    @PostMapping("/{id}/delete")
    public ModelAndView deleteClassroom(@PathVariable int id){
        iCrudService.delete(id);
        ModelAndView modelAndView = new ModelAndView("classroom/delete");
        modelAndView.addObject("message","Xóa thành công");
        return modelAndView;
    }
}
