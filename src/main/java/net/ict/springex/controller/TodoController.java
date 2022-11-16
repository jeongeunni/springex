package net.ict.springex.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.springex.dto.PageRequestDTO;
import net.ict.springex.dto.TodoDTO;
import net.ict.springex.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Log4j2
@Controller
@RequestMapping("/todo")
@RequiredArgsConstructor
    public class TodoController {

        private final TodoService todoService;

    //최종경로는 /todo/list
//        @RequestMapping("/list")
//        public void list(Model model){
//            log.info("todo list..............");
//            model.addAttribute("dtoList",todoService.getAll());
//            //model에는 dtoList이름을 가진 목록 데이터가 담겨 있다
//        }

            @RequestMapping("/list")
            public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model){
            log.info("todo list..............");
            if(bindingResult.hasErrors()){
                pageRequestDTO=PageRequestDTO.builder().build();
            }
            model.addAttribute("responseDTO",todoService.getList(pageRequestDTO));
            //model에는 dtoList이름을 가진 목록 데이터가 담겨 있다
        }

        //최종경로는 /todo/register
        @RequestMapping(value = "/register", method = RequestMethod.GET)
        public void register(){
            log.info("todo register.....");
        }

    //  '/todo/register' 매핑을 이용해서  post방식으로 처리하는 메소드 TodoDTO 파라미터로 적용

        @PostMapping("/register")
        public String registerPost(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){  //@Valid -> TodoDTO는 검증 대상이다
            log.info("Post todo register.....");

            if(bindingResult.hasErrors()){  //bindingResult(@future, @not empty)에 문제가 있다면
                log.error("has errors....");
                redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
                return "redirect:/todo/register"; //쓰기 기능으로 다시 보냄
            }
            log.info(todoDTO);
            todoService.register(todoDTO); //입력값 db에 넣어줌
            return "redirect:/todo/list";
        }

        @PostMapping("/remove")
        public String removePost(Long tno, RedirectAttributes redirectAttributes){
            log.info("remove...");
            log.info("tno"+tno);
            todoService.remove(tno);
            return "redirect:/todo/list";
        }
        @RequestMapping({"/read","/modify"})
        public void read(PageRequestDTO pageRequestDTO,Long tno, Model model){
            log.info("read...");
            TodoDTO todoDTO = todoService.getOne(tno);
            log.info(todoDTO);
            model.addAttribute("dto",todoDTO);
            //model.addAttribute("dto",todoService.getOne(tno));
        }
        @PostMapping("/modify")
        public String modify(@Valid TodoDTO todoDTO,BindingResult bindingResult, RedirectAttributes redirectAttributes){
            if(bindingResult.hasErrors()){
                log.info("--- has errors---");
                redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
                redirectAttributes.addAttribute("tno",todoDTO.getTno());
                //tno를 받아오는 이유는 오류가 발생할 경우 tno값을 가지고 이전 화면으로 돌아가야 하기때문
                return "redirect:/todo/modify";
            }
            log.info(todoDTO);
            todoService.modify(todoDTO);
            return "redirect:/todo/list";

        }


    }

