package net.ict.springex.controller;

import lombok.extern.log4j.Log4j2;
import net.ict.springex.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {
    @GetMapping("/hello") //get방식으로 들어오는 요청 처리하기 위한 매핑 태그
    public void hello(){
        log.info("hello............");  //hello 경로 요청이 들어오면 출력
    }

    @GetMapping("/ex1")
    public void ex1(String name, int age){
        log.info("ex1............");
        log.info("name: "+name);
        log.info("age: "+age);

    }
    //파라메터가 넘어오지 않는 경우 문제 생길 수 있으므로 기본값을 지정해둔다.
    //특히 null이 들어올 경우 nullpointException생길 수 있다.
    @GetMapping("/ex2")
    public void ex2(@RequestParam(name = "name", defaultValue = "AAA") String name,
                    @RequestParam(name = "age", defaultValue = "20")int age){
        log.info("ex2..........");
        log.info("name: "+name);
        log.info("age: "+age);

    }
    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate){
        log.info("ex3.........");
        log.info("dueDate: "+ dueDate);
    }

    @GetMapping("/ex4")
    public void ex4(Model model){
        log.info("model info.........");
        model.addAttribute("message", "Hello SpringMVC!");
    }

    @GetMapping("/ex5")
    public void ex5(TodoDTO todoDTO,Model model){    //dto에 모델 담아서 처리
        log.info("model TodoDTO info.........");
        log.info(todoDTO);
    }

    @GetMapping("/ex6")
    public String ex6(RedirectAttributes redirectAttributes){    //dto에 모델 담아서 처리
        redirectAttributes.addAttribute("name" , "ABC");
        redirectAttributes.addFlashAttribute("result","success");
        return "redirect:/ex7";

        //ex6에서 name, result추가해서 ex7으로 전달
    }
    @GetMapping("/ex7")
    public void ex7(){
        //name과  result결과를 보여줄 뷰 페이지 제공

    }

    @GetMapping("/ex8")
    public void ex8(String p1, int p2){
        log.info("p1  ----- " +p1);
        log.info("p2  ----- " +p2);
    }
}
