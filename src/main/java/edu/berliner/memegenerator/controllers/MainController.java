package edu.berliner.memegenerator.controllers;

import com.cloudinary.utils.ObjectUtils;
import edu.berliner.memegenerator.configs.CloudinaryConfig;
import edu.berliner.memegenerator.models.Image;
import edu.berliner.memegenerator.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
public class MainController
{
	@Autowired
	ImageRepository imageRepo;

	@Autowired
	CloudinaryConfig cloudc;


	@RequestMapping({"/", "/index"})
	public String welcome(Model model)
	{   //currently just list of images
		model.addAttribute("images", imageRepo.findAll());
		return "viewimages";
	}

	@RequestMapping("/create")
	public String create()
	{
		return "creatememe";
	}

	@GetMapping("/addimage")
	public String addimage(Model model)
	{
		model.addAttribute("image", new Image());
		System.out.println("here");

		return "addimage";
	}

	@PostMapping("/addimage")
	public String processImage(@ModelAttribute Image img, @RequestParam("file")MultipartFile file)
	{

		if(file.isEmpty())
		{

			return "redirect:/addimage";
		}
		try
		{
			Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype","auto"));
			img.setImgUrl(uploadResult.get("url").toString());
			imageRepo.save(img);
		} catch (IOException e)
		{
			e.printStackTrace();
			return "redirect:/addimage";
		}
		return "redirect:/";
	}

	@RequestMapping("/view")
	public String viewMemes()
	{
		return "viewmemes";
	}
}
