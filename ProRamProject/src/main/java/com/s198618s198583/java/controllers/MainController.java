/*
    Jon Gillingsrud, s198618
    Christoffer Fredriksen, s198583
*/

package com.s198618s198583.java.controllers;

import com.s198618s198583.java.models.Admin;
import com.s198618s198583.java.models.Contact;
import com.s198618s198583.java.service.AdminService;
import com.s198618s198583.java.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    AdminService service;
    @Autowired
    ContactService contactService;
    Admin a;

    @RequestMapping(value = "/")
    public ModelAndView index() { // Opens the index page

        ModelAndView mav = new ModelAndView("index/index");

        if (a != null) {

            mav.addObject("adminlogin", "Logg ut");
            mav.addObject("value", "logout.htm");
            mav.addObject("adminpage", "Admin side");
            mav.addObject("adminvalue", "adminpage.htm");

        } else {

            mav.addObject("adminlogin", "Administrator");
            mav.addObject("value", "login.htm");
        }


        return mav;
    }

    @RequestMapping(value = "/index")
    public ModelAndView back() { // Goes back to the index page

        ModelAndView mav = new ModelAndView("index/index");

        if (a != null) {

            mav.addObject("admin", "Log out");
            mav.addObject("value", "logout.htm");
            mav.addObject("adminpage", "Admin side");
            mav.addObject("adminvalue", "adminpage.htm");

        } else {

            mav.addObject("adminlogin", "Administrator");
                    mav.addObject("value", "login.htm");
        }

        return mav;
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model) { // Opens the contact request form

        model.addAttribute("contact", new Contact());

        model.addAttribute("admin", new Admin());

        if (a != null) {

            model.addAttribute("adminlogin", "Logg ut");
            model.addAttribute("value", "logout.htm");
        } else {

            model.addAttribute("adminlogin", "Administrator");
            model.addAttribute("value", "login.htm");
        }

        return "index/contact";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public ModelAndView contactsent(@ModelAttribute("contact") Contact contact) { // Receives and saves the contact request

        ModelAndView mav = new ModelAndView("index/index");

        if (contact != null) {

            Contact c = new Contact(contact.getName(), contact.getEmail(), contact.getMessage());

            try {
                contactService.addContact(c);
            } catch (Exception e) {

                mav = new ModelAndView("index/contact");

                mav.addObject("error", "Melding ikke sendt. \n Vennligst prøv igjen senere.");

                return mav;
            }

            if (a != null) {

                mav.addObject("adminlogin", "Logg ut");
                mav.addObject("value", "logout.htm");
                mav.addObject("adminpage", "Admin side");
                mav.addObject("adminvalue", "adminpage.htm");

            } else {

                mav.addObject("adminlogin", "Administrator");
                mav.addObject("value", "login.htm");
            }

            mav.addObject("message", "Melding sendt. \n Vi besvarer forespørsler fortløpende.");

            return mav;
        } else {

            mav = new ModelAndView("index/contact");

            mav.addObject("error", "Melding ikke sendt. \n Vennligst prøv igjen senere.");

            if (a != null) {

                mav.addObject("adminlogin", "Logg ut");
                mav.addObject("value", "logout.htm");
                mav.addObject("adminpage", "Admin side");
                mav.addObject("adminvalue", "adminpage.htm");

            } else {

                mav.addObject("adminlogin", "Administrator");
                mav.addObject("value", "login.htm");
            }

            return mav;
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) { // Opens the login page for administrators

        model.addAttribute("admin", new Admin());

        if (a != null) {

            model.addAttribute("id", a.getID());
            model.addAttribute("user", a.getUsername());
            model.addAttribute("adminlogin", "Logg ut");
            model.addAttribute("value", "logout.htm");

            return "index/adminpage";
        } else {

            model.addAttribute("adminlogin", "Administrator");
            model.addAttribute("value", "login.htm");

            return "index/login";
        }
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout() { // Logs out the currently logged in admin

        ModelAndView mav = new ModelAndView("index/index");

        a = null;

        mav.addObject("adminlogin", "Administrator");
        mav.addObject("value", "login.htm");

        return mav;
    }

    @RequestMapping(value = "/adminpage", method = RequestMethod.POST)
    public String adminpage(Model model, @ModelAttribute("admin") Admin admin) { // Logs in an admin and opens the admin page

        admin.hashPass(); // Hashes the password for check

        if (service.findByUsernameAndPass(admin.getUsername(), admin.getPassword()) != null) {

            a = service.findByUsernameAndPass(admin.getUsername(), admin.getPassword());

            model.addAttribute("id", a.getID());
            model.addAttribute("user", a.getUsername());
            model.addAttribute("adminlogin", "Logg ut");
            model.addAttribute("value", "logout.htm");

            return "index/adminpage";

        } else {

            model.addAttribute("error", "Ugyldig brukernavn eller passord!");
            model.addAttribute("adminlogin", "Administrator");

            return "index/login";
        }
    }

    @RequestMapping(value = "/adminpage")
    public ModelAndView admin() { // Opens the admin page if logged in, login page if not

        ModelAndView mav = new ModelAndView("index/adminpage");

        if (a != null) {

            mav.addObject("id", a.getID());
            mav.addObject("user", a.getUsername());
            mav.addObject("adminlogin", "Logg ut");
            mav.addObject("value", "logout.htm");

        } else {

            mav = new ModelAndView("index/login");
            mav.addObject("adminlogin", "Administrator");
            mav.addObject("value", "login.htm");
        }


        return mav;
    }
}