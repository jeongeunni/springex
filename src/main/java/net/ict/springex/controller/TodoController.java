package net.ict.springex.controller;

import lombok.extern.log4j.Log4j2;
import net.ict.springex.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequestMapping("/todo")
    public class TodoController {
        //최종경로는 /todo/list
        @RequestMapping("/list")
        public void list(Model model){
            log.info("todo list..............");
        }
        //최종경로는 /todo/register
        @RequestMapping(value = "/register", method = RequestMethod.GET)
        public void register(){
            log.info("todo register.....");
        }

    //  '/todo/register' 매핑을 이용해서  post방식으로 처리하는 메소드 TodoDTO 파라미터로 적용
        @PostMapping("/reigster")
        public String registerPost(TodoDTO todoDTO, RedirectAttributes redirectAttributes){
            log.info("Post todo register.....");
            log.info(todoDTO);
            return "redirect:/todo/list";
        }








    }
