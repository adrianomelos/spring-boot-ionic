package com.ionic.api;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ionic.api.entity.Contact;
import com.ionic.api.services.ContactService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
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
