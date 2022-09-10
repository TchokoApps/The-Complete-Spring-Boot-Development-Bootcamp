package com.tchokoapps.springboot.easyschool.service;

import com.tchokoapps.springboot.easyschool.model.Contact;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Getter
@Setter
@Slf4j
@Service
//@RequestScope
//@SessionScope
@ApplicationScope
public class ContactService {
    private int counter = 0;

    public ContactService() {
        System.out.println("Contact Service Bean initialized");
    }

    public boolean save(Contact cotnacct) {
        boolean isSaved = true;
        log.info("Contact: {}", cotnacct);
        return isSaved;
    }
}
