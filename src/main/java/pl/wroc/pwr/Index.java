package pl.wroc.pwr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.wroc.pwr.response.JsonResponse;
import pl.wroc.pwr.response.SuccessResponse;

import java.util.List;

@Controller
@RequestMapping("/")
public class Index {

    @Autowired
    private Expert expert;

    @Autowired
    private Knowledge knowledge;

    @RequestMapping
    public String index() {
        return "index";
    }

    @RequestMapping("knowledge")
    public String knowledge(Model model) {
        model.addAttribute("cars", knowledge.getCars());
        return "knowledge";
    }

    @RequestMapping(value = "questions")
    @ResponseBody
    public JsonResponse question() {
        return SuccessResponse.create(knowledge.getQuestions().values());
    }

    @RequestMapping(value = "answers", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse answer(List<Answer> answers) {
        return SuccessResponse.create(expert.resolve(answers));
    }

    @RequestMapping(value = "answers-test", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse answers() {
        return SuccessResponse.create(knowledge.getCars());
    }
}