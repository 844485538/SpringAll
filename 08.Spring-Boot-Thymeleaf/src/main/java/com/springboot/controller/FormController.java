package com.springboot.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.bean.Product;

@Controller
public class FormController {
	
	@RequestMapping(value = { "/addProduct" }, method = RequestMethod.GET)
    public String showaddProduct(Model model)throws ParseException {
        //List<Product> saleTypes = new ArrayList<Product>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Product product = new Product("花生油", 119.0, sdf.parse("2018-02-11"));
        model.addAttribute("product", product);
        return "addProduct";
    }

    @RequestMapping(value = { "/saveProduct" }, method = RequestMethod.POST)
    public void saveprodcut(@ModelAttribute Product pro) throws ParseException {
    	System.out.println(pro);
    }

}
