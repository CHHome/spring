package demo.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import demo.model.User;
import demo.service.UserServiceImpl;

@Controller
@RequestMapping("user")
@SessionAttributes("user")
public class UserController {
	@Autowired
	private UserServiceImpl service;
	
	@RequestMapping("login.do")
	public String login(String username, String password, Model model){
		String msg = null;
		if (null != username && null != password){
			User user = service.login(username, password);
			if (user == null){
				msg = "用户名或密码错误!";
			} else {
				model.addAttribute("user", user);
				msg = "登陆成功!";
			}
		}
		model.addAttribute("msg", msg);
		return "index";
	}
		
	@RequestMapping("reg.do")
	public String register(User user, @RequestParam("imgs")CommonsMultipartFile imgs, HttpServletRequest req){
		String path = req.getServletContext().getRealPath("upload");
		File dir = new File(path);
		if (!dir.exists()){ //如果文件夹不存在,则创建它
			dir.mkdirs();
		}
		//使用时间作为文件名称
		//String fileName = String.valueOf(System.currentTimeMillis());
		//获取源文件的名称,按原文件名称保存
		String fileName = imgs.getOriginalFilename();
		try {//保存文件
			imgs.transferTo(new File(path, fileName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		user.setIcon(fileName);
		service.save(user);
		return "index";
	}
	
	@RequestMapping("all.do")
	@ResponseBody
	public List<User> findAll(){
		return service.find();
	}
	
	@RequestMapping("page.do")
	@ResponseBody
	public Map<String, Object> page(@RequestParam(defaultValue="1")int pageNumber, 
			@RequestParam(defaultValue="10")int pageSize){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("rows",service.page(pageNumber, pageSize));
		map.put("total", service.count());
		return map;
	}
	
	@RequestMapping("del.do")
	@ResponseBody
	public Map<String,Object> delete(@RequestParam("id")int id){
		Map<String,Object> map = new HashMap<String,Object>();
		String msg = null;
		try{
			service.delete(id);
			msg ="删除成功";
		} catch(Exception e){
			e.printStackTrace();
			msg = "删除失败";
		}
		map.put("msg", msg);
		return map;
	}
	
	@RequestMapping("edit.do")
	@ResponseBody
	public Map<String,Object> edit(User user){
		Map<String,Object> map = new HashMap<String,Object>();
		String msg = null;
		try{
			service.update(user);
			msg ="修改成功";
		} catch(Exception e){
			e.printStackTrace();
			msg = "修改失败";
		}
		map.put("msg", msg);
		return map;
	}
}
