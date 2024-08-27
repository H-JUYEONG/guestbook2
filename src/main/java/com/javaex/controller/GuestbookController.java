package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestVo;

@Controller
public class GuestbookController {

	// 필드
	@Autowired
	private GuestbookService guestbookService;

	// 생성자
	// 메소드 gs
	// 메소드 일반

	/* 등록 폼 */
	@RequestMapping(value = "/addlist", method = { RequestMethod.GET, RequestMethod.POST })
	public String addList(Model model) {

		System.out.println("GuestbookController.addList()");

		List<GuestVo> guestList = guestbookService.exeGetGuestList();
		model.addAttribute("guestList", guestList);

		return "addList";
	}

	/* 등록 */
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute GuestVo guestVo) {

		System.out.println("GuestbookController.write()");

		guestbookService.insertGuest(guestVo);

		return "redirect:addlist";
	}

	/* 삭제폼 */
	@RequestMapping(value = "/deleteform", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm() {

		System.out.println("GuestbookController.deleteForm()");

		return "deleteForm";
	}
	
	/* 삭제 ver1 */
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@ModelAttribute GuestVo guestVo) {

		System.out.println("GuestbookController.delete()");

		boolean delete = guestbookService.deleteGuest(guestVo.getNo(), guestVo.getPassword());

		if (delete) {
			return "redirect:addlist";
		} else {
			return "error";

		}

	}

	/* 삭제 ver2 
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam(value = "no") int no, @RequestParam(value = "password") String password) {

		System.out.println("GuestbookController.delete()");

		boolean delete = guestbookDao.deleteGuest(no, password);

		if (delete) {
			return "redirect:addlist";
		} else {
			System.out.println("입력하신 비밀번호가 일치하지 않습니다.");
			return "error";

		}

	} */

}
