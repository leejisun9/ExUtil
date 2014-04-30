package com.my.util;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value = "/converter.do", method = RequestMethod.GET)
	public String converter(Model model) {
		
		/*Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );*/
		
		return "converter";
	}
	
	@RequestMapping(value = "/excutConverter.do", method = RequestMethod.POST)
	public String excutConverter(@RequestParam("inData") int s ,@RequestParam("setType1") String type1,@RequestParam("setType2") String type2, Model model) {
		
		/*Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );*/
		logger.debug(String.valueOf(s));
		logger.debug(type1);
		logger.debug(type2);
		
		
		model.addAttribute("inData", String.valueOf(s));
		model.addAttribute("setType1", type1);
		model.addAttribute("setType2", type2);
		
		String outData = ConverterUtil.converterDataUnit(s,Integer.parseInt(type1),Integer.parseInt(type2));
		
		model.addAttribute("outData", outData);
		
		return "converter";
	}
	
}
