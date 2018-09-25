package com.adtech.web;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.adtech.service.XmlEntityService;


@Controller
public class ClientController {
	
	@Autowired
	private XmlEntityService xmlService;
	
    @GetMapping(value = "index")
    public String index()
    {
        return "index";
    }
    
    @PostMapping("/uploadFile")
    public @ResponseBody ModelAndView uploadPreaseXML(@RequestParam("filename") MultipartFile[] files) {
    	ModelAndView mav = new ModelAndView();
		try {
			for (MultipartFile mfs : files) {
				if(mfs.getName().endsWith(".xml")){
					mav.addObject("error", "文件格式后缀名必须是.xml");
					mav.setViewName("/index");
				}else{
					InputStream inp = mfs.getInputStream();
					
					xmlService.parseXml(inp);
					
					mav.addObject("error", "");
					mav.setViewName("/index");
				}
			}
		} catch (Exception e) {
			mav.addObject("error", "文件错误，检查文件！");
			mav.setViewName("/index");
		}
    	return mav;
	}
    
}
