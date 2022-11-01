package sg.com.ctcglobal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sg.com.ctcglobal.TimeSheet.Employee;
import sg.com.ctcglobal.TimeSheet.TimeSheet;
import sg.com.ctcglobal.repository.EmployeeRepository;
import sg.com.ctcglobal.repository.TimeSheetRepository;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Controller
public class J2EEExam {
	
    @RequestMapping(value = "/loginProcess")
    public String loginProcess(String Username, String Password, Model model){
       // session.setAttribute("", "");
    	System.out.println("Start user session");
    	System.out.println(Username);
    	System.out.println(Password);
       Employee employee  = EmployeeRepository.getEmployee(Username);
       
       model.addAttribute("employee", employee);
       
       if(Username.equalsIgnoreCase("teamlead")) {
    	   TimeSheet ts = TimeSheetRepository.getTimeSheet();
    	   model.addAttribute("timeSheet", ts.toHTMLString());
    	    return "timeSheet";
       }else if(Username.equalsIgnoreCase("staff1") || Username.equalsIgnoreCase("staff2")) {
    	    return "action";
       }else {
    	   model.addAttribute("errMsg", "Username not found");
    	   return "login";
       }
    }
    
    @RequestMapping(value = "/timeSheetProcess")
    public String timeSheetProcess(String username, String timeSheet, Model model){
       // session.setAttribute("", "");
    	System.out.println("Start timeSheetProcess");
    	System.out.println(username);
    	System.out.println(timeSheet);
       Employee employee  = EmployeeRepository.getEmployee(username);
    
       model.addAttribute("employee", employee);
       TimeSheet ts = TimeSheetRepository.getTimeSheet();
       System.out.println(ts);
       	try {
       		if(timeSheet.equalsIgnoreCase("checkIn")) {
       			ts.checkInEmployee(employee);
       		}else if (timeSheet.equalsIgnoreCase("checkOut")){
       			ts.checkOutEmployee(employee);
       		}
       	} catch (Exception e) {
       		model.addAttribute("errMsg", e.getMessage());
       	}
        
       	if(username.equalsIgnoreCase("teamlead")) {
     	   model.addAttribute("timeSheet", ts.toHTMLString());
     	   return "timeSheet";
        }else 
     	   return "action";
        
        
    }
    
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        System.out.println("Ending user session");
        session.invalidate();
        return "login";

    }
	
	@RequestMapping(value = "/setup")
    public String setup(Model model) {
		model.addAttribute("msg", "UrlBasedViewResolver setup Demo");
        return "setup";
	}
	
	@RequestMapping(value = "/timeSheet")
    public String timeSheet(Model model) {
		model.addAttribute("msg", "UrlBasedViewResolver timeSheet Demo");
        return "timeSheet";
	}
	
	@RequestMapping(value = "/action")
	public String action(Model model)  {
		model.addAttribute("msg", "UrlBasedViewResolver action Demo");
        return "action";
	}

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
