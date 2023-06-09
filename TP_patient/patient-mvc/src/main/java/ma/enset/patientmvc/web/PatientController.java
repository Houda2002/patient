package ma.enset.patientmvc.web;


import lombok.AllArgsConstructor;
import ma.enset.patientmvc.entities.Patient;
import ma.enset.patientmvc.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;


    @GetMapping(path = "/index")
    public  String patients(Model model,
                            @RequestParam(name="page",defaultValue = "0") int page ,
                            @RequestParam(name="size",defaultValue = "5")int size,
                            @RequestParam(name="keyword",defaultValue = "")String keyword ){
        //1) h2base :
        //List<Patient> patientList = patientRepository.findAll();
        // model.addAttribute("listPatients",patientList);
        //mysql
       //2) Page<Patient> patientList = patientRepository.findAll(PageRequest.of(page, size));
        //model.addAttribute("listPatients",patientList.getContent());
        //model.addAttribute("pages",new int[patientList.getTotalPages()]);
       // model.addAttribute("currentPage",page);

        //3)
        Page<Patient> patientList = patientRepository.findByNomContains(PageRequest.of(page, size),keyword);
        model.addAttribute("listPatients",patientList.getContent());
        model.addAttribute("pages",new int[patientList.getTotalPages()]);
        model.addAttribute("keyword",keyword);
        return "patients";
    }
    @GetMapping("/delete")
    public String delete(Long id,String keyword, int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page= "+page+"&keyword= "+keyword;
    }
    @GetMapping("/")
    public String home(Long id){
        return "redirect:/index";
    }

}
