package com.tchokoapps.springboot.easyschool.controller;

import com.tchokoapps.springboot.easyschool.model.Contact;
import com.tchokoapps.springboot.easyschool.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String displayContactPage() {
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
    public ModelAndView saveMessage(Contact contact) {
        contactService.save(contact);
        return new ModelAndView("redirect:/contact");
    }
}
