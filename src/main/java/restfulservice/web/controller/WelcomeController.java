package restfulservice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Eason Lin
 *
 */
@Controller
public class WelcomeController {

  @RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
  public ModelAndView welcomePage() {

    ModelAndView model = new ModelAndView();
    model.addObject("title", "Hello World");
    model.addObject("message", "This is welcome page!");
    model.setViewName("index");
    return model;

  }
}
