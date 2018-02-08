package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Home {
    @RequestMapping("/")
    String powitanie() {
        return "hello";
    }

    @RequestMapping("/edit")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
//        inne model.addAtributy
        return "base";
    }

    @RequestMapping(value = "/something", method = RequestMethod.POST)
    public String something(@ModelAttribute(value = "product") Product product) {
        return "result";
    }
}