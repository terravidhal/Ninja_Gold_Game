package com.dojo.ninjagold;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

//add
import org.springframework.stereotype.Controller;

//add
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

//add
@Controller
public class NinjaController {
	// home
	@RequestMapping("/")
	public String home(HttpSession session) {

		if (session.getAttribute("ninja_gold") == null) {
			session.setAttribute("ninja_gold", 0);
			session.setAttribute("activities_texts", new ArrayList<ArrayList<Object>>());
		}

		return "index.jsp";
	}

	// ninjas bonus
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("ninja_gold", 0);
		session.setAttribute("activities_texts", new ArrayList<ArrayList<Object>>());

		return "redirect:/";
	}

	@RequestMapping(value = "/process_money", method = RequestMethod.POST)
	public String process_money(@RequestParam(value = "building") String building,
			HttpSession session) {
		Integer ninja_gold = (Integer) session.getAttribute("ninja_gold");
		ArrayList<Object> activities_texts = (ArrayList<Object>) session.getAttribute("activities_texts");
		Integer amount = 0;

		if (building.equals("farm")) {
			amount = new Random().nextInt(11) + 10; // nbre entre 10 et 20 on a : new Random().nextInt(11) => nbre entre
													// 0 et 10 , maintenant +10 => entre 0 et 20
			ninja_gold += amount;
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("MMMM d'st' yyyy h:mma");
			String formattedDate = formatter.format(date);
			HashMap<Boolean, String> playInfos = new HashMap<Boolean, String>();
			playInfos.put(true, "You entered a " + building + " an earned " + amount + " gold " + ". " + "( "
					+ formattedDate + " )");
			activities_texts.add(playInfos);

		} else if (building.equals("cave")) {
			amount = new Random().nextInt(6) + 5; // entre 5 et 10
			ninja_gold += amount;
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("MMMM d'st' yyyy h:mma");
			String formattedDate = formatter.format(date);
			HashMap<Boolean, String> playInfos = new HashMap<Boolean, String>();
			playInfos.put(true, "You entered a " + building + " an earned " + amount + " gold " + ". " + "( "
					+ formattedDate + " )");
			activities_texts.add(playInfos);

		} else if (building.equals("house")) {
			amount = new Random().nextInt(4) + 2; // entre 2 et 5
			ninja_gold += amount;
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("MMMM d'st' yyyy h:mma");
			String formattedDate = formatter.format(date);
			HashMap<Boolean, String> playInfos = new HashMap<Boolean, String>();
			playInfos.put(true, "You entered a " + building + " an earned " + amount + " gold " + ". " + "( "
					+ formattedDate + " )");
			activities_texts.add(playInfos);

		} else if (building.equals("quest")) {
			amount = new Random().nextInt(51); // entre 0 et 5
			Integer luck = new Random().nextInt(2); // entr 0 et 1
			if (luck == 1) {
				ninja_gold += amount;
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("MMMM d'st' yyyy h:mma");
				String formattedDate = formatter.format(date);
				HashMap<Boolean, String> playInfos = new HashMap<Boolean, String>();
				playInfos.put(true, "You entered a " + building + " an earned " + amount + " gold " + ". " + "( "
						+ formattedDate + " )");
				activities_texts.add(playInfos);

			} else {
				ninja_gold -= amount;
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("MMMM d'st' yyyy h:mma");
				String formattedDate = formatter.format(date);
				HashMap<Boolean, String> playInfos = new HashMap<Boolean, String>();
				playInfos.put(false, "You failed a " + building + " an lost " + amount + " gold. Ouch " + ". " + "( "
						+ formattedDate + " )");
				activities_texts.add(playInfos);
			}
		}

		session.setAttribute("ninja_gold", ninja_gold);
		session.setAttribute("activities_texts", activities_texts);

		return "redirect:/";
	}

}
