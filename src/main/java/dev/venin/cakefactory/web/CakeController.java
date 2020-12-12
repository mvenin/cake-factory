package dev.venin.cakefactory.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Controller
public class CakeController {
    private List<Cake> cakes;

    public CakeController() {
        this.cakes = Stream.iterate(1, n -> n + 1)
                .limit(18)
                .map(i -> new Cake("Cake " + i))
                .collect(Collectors.toList());
    }

    @GetMapping("/")
    public String showDesign(Model model) {
        model.addAttribute("cakes", cakes);
        return "cakes";
    }

}
