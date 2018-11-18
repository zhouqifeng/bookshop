package com.qf.web;

import com.qf.pojo.Item;
import com.qf.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	
	@RequestMapping("/item/{itemId}")
	public String showItemInfo(@PathVariable Long itemId, Model model) {
		//调用服务取商品基本信息
		Item item = itemService.getItemById(itemId);
		//取商品描述信息
		//TbItemDesc itemDesc = itemService.getItemDescById(itemId);
		//把信息传递给页面
		System.out.println(item.toString());

		model.addAttribute("item", item);
		//model.addAttribute("itemDesc", itemDesc);
		//返回逻辑视图
		return "item";
	}
}
