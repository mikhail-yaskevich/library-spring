package by.it.training.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reader")
public class ReaderDispatcher {

    @GetMapping("/")
    public String welcome(Model model) {

        return "main";
    }

}
