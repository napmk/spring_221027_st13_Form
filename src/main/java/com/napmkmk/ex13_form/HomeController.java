package com.napmkmk.ex13_form;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/board/confirmId")  //http://localhost:8888/ex13_form/board/confirmId?id=tiger&pw=12345 컨트롤러로 감
	public String confirmId(HttpServletRequest request, Model model) { // 메개 변수로 리퀘스트 객체 받기 (?id=tiger&pw=12345)
			String id = request.getParameter("id");
			String pw =request.getParameter("pw");
			
//			System.out.println(id);
//			System.out.println(pw);
			
			model.addAttribute("id", id);
			model.addAttribute("pw", pw);
			
			return "board/confirmId";
	}
	//파일실행시키려면 컨트럴러에 꼭 등록이 필요함
	@RequestMapping(value = "/login") // 마음대로 정해도됨  
	public String login() { 
	
		
		return "board/login"; //실제 존재하는 위치
		
		
	}
	
}
