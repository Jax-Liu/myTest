package com.adtech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adtech.service.XmlMongodbService;

@RestController
@RequestMapping("/")
public class XmlEntityController {
	
	@Autowired
	XmlMongodbService mServices;
	
	
	
}
