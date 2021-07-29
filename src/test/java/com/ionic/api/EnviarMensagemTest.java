package com.ionic.api;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ionic.api.entity.Contact;
import com.ionic.api.services.ContactService;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest
@ActiveProfiles(profiles = "test")
public class EnviarMensagemTest {
	
	@Autowired
    private ContactService contactService;
	
	@Test
	void testCadastrarMensagem() {
		
		Contact c = new Contact(null, "teste", "adrianoshout@gmail.com", "sdklf", LocalDateTime.now());
		Contact b = contactService.save(c);
		System.out.println(b.getEmail());
		
	}
}
