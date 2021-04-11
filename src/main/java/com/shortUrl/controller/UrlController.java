package com.shortUrl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shortUrl.domain.Url;
import com.shortUrl.service.UrlService;

@Controller
public class UrlController {

	@Autowired
	UrlService urlService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String main(Model model) {

		model.addAttribute("jsonInString", "");
		model.addAttribute("jsonInString", "");
		model.addAttribute("jsonInString2", "");
		return "result";
	}

	@RequestMapping(value = "/encoding", method = RequestMethod.POST)
	public String encoding(Model model, HttpServletRequest httpServletRequest) {

		String writeUrl = httpServletRequest.getParameter("writeUrl");
		String shortUrl = urlService.generateShortUrl(writeUrl);
		String longUrl = urlService.getLongUrlByShortUrl(shortUrl);

		List<Url> urlList = urlService.getUrls();

		model.addAttribute("writeUrl", writeUrl);
		model.addAttribute("shortUrl", shortUrl);
		model.addAttribute("longUrl", longUrl);
		model.addAttribute("urlList", urlList);

		return "result";
	}

}
