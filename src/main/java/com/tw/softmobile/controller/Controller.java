package com.tw.softmobile.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tw.softmobile.model.Message;
import com.tw.softmobile.service.MessageService;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(value="/DataServlet", method=RequestMethod.POST)
	public void findMessage(HttpServletRequest request, HttpServletResponse response) 
	throws IOException {
		//抓取傳過來的req JSON
		int messageBookNo = -1;

		String line = null;
		try {
			BufferedReader reader = request.getReader();
			line = reader.readLine();
			System.out.println("line: " + line.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// 取單一用法
			// 取request的留言板id json
			JSONObject jsonObj = new JSONObject(line);
			messageBookNo = jsonObj.getInt("messageBookId");
			System.out.println("json request mes id" + messageBookNo); // 取得留言板id
		} catch (Exception e) {
			e.printStackTrace();
		}

		//查詢資料庫
		Message message = messageService.getMessage(messageBookNo);
//		while() 
		
//		System.out.println(message.getMessageBody());
		
		//回傳res回去android
	}
}
