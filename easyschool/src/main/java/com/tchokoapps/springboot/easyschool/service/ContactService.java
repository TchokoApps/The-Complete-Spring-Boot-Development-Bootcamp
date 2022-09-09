package com.tchokoapps.springboot.easyschool.service;

import com.tchokoapps.springboot.easyschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContactService {
    public boolean save(Contact cotnacct) {
        boolean isSaved = true;
        log.info("Contact: {}", cotnacct);
        return isSaved;
    }
}
