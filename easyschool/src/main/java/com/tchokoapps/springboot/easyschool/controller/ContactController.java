package com.tchokoapps.springboot.easyschool.controller;

import com.tchokoapps.springboot.easyschool.model.Contact;
import com.tchokoapps.springboot.easyschool.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Slf4j
@Controller
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

//    @PostMapping("/saveMsg")
//    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum, @RequestParam String email,
//                                    @RequestParam String subject, @RequestParam String message) {
//        log.info("Name: {}", name);
//        log.info("MObile Number: {}", mobileNum);
//        log.info("Email Address: {}", email);
//        log.info("Subject: {}", subject);
//        log.info("Message: {}", message);
//        return new ModelAndView("redirect:/contact");
//    }

    @PostMapping("/saveMsg")
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {
        if (errors.hasErrors()) {
            log.error("Contact form validation failed due to: {}", errors.toString());
            return "contact";
        }
        contactService.save(contact);
        contactService.setCounter(contactService.getCounter() + 1);
        log.info("Number of times the Contact form is submitted: {}", contactService.getCounter());
        return "redirect:/contact";
    }
}
