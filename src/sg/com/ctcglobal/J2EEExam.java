package sg.com.ctcglobal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class J2EEExam {

	@RequestMapping("/about")
	public ModelAndView about() {

		String message = "<br><div style='text-align:center;'>" + "";
		return new ModelAndView("about", "message", message);
	}

	@RequestMapping("/index")
	public ModelAndView index() {
		System.out.println("index");
		return new ModelAndView("index", "message", null);
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		System.out.println("login");
		return new ModelAndView("login", "message", null);
	}

}
