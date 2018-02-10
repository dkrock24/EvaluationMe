package com.focus.levelup.landing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("landing")
public class landingController {

	@RequestMapping("index")
	public String landing() {
		return "landing/index";
	}
}
