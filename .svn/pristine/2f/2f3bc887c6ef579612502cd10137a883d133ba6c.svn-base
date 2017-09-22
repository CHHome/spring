package demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demo.model.User;
import demo.service.UserServiceImpl;

@Controller
@RequestMapping("test")
public class TestController {
	@Resource
	private UserServiceImpl service;
	
	@RequestMapping("t.do")
	public String test(@RequestParam(name="name",required=false,defaultValue="qqq")String username, String password){
		System.out.println("看到这一段文字,就表示访问成功了!!!-----" + username + "===" + password);
		return "login"; //返回视图的名称
	}
	
	@RequestMapping("save.do")
	public String save(User user, Model model){
		String msg = null;
		try{
			service.save(user);
			msg = "保存成功!";
		} catch(Exception e){
			msg = "保存失败!";
		}
		model.addAttribute("message", msg);
		return "index";
	}
	
	@RequestMapping("page.do")
	public String page(@RequestParam(required=false,defaultValue="1")int pageNumber, 
			@RequestParam(required=false,defaultValue="10")int pageSize){
		System.out.println(pageNumber + "===" + pageSize);
		return "index";
	}

}
