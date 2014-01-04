package pl.wroc.pwr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Index {

    @Autowired
    private Knowledge knowledge;

    @RequestMapping
	public String index() {
		return "index";
	}

    @RequestMapping("knowledge")
    public String knowledge(Model model){
        model.addAttribute("cars", knowledge.getCars());
        return "knowledge";
    }
}