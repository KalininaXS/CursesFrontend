package back.Controller;

import back.Model.KZ_A;
import back.Model.KZ_B;
import back.Model.KZ_C;
import back.Service.Back_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    @Autowired
    private Back_Service backService;
    @PostMapping("data")
    public void uploadFile(@RequestParam("file") MultipartFile file){ backService.parser(file); }



    @GetMapping("kzA")
    public List<KZ_A> FindKZA(){ return backService.findAllA(); }
    @GetMapping("kzB")
    public List<KZ_B> FindKZB(){
        return backService.findAllB();
    }
    @GetMapping("kzC")
    public List<KZ_C> FindKZC(){
        return backService.findAllC();
    }


    @GetMapping("kzia")
    public List<Double> findKZA(){return backService.findKZA(); }
    @GetMapping("timekzia")
    public List<Double> findTimeKZA(){return backService.findTimeKZA(); }

    @GetMapping("kzib")
    public List<Double> findKZB(){return backService.findKZB(); }
    @GetMapping("timekzib")
    public List<Double> findTimeKZB(){return backService.findTimeKZB(); }

    @GetMapping("kzic")
    public List<Double> findKZC(){return backService.findKZC(); }
    @GetMapping("timekzic")
    public List<Double> findTimeKZC(){return backService.findTimeKZC(); }

}
