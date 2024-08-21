package kz.halykfinance.HalykFinanceTask;

import kz.halykfinance.HalykFinanceTask.dto.ClientDto;
import kz.halykfinance.HalykFinanceTask.dto.MessageDto;
import kz.halykfinance.HalykFinanceTask.scheduler.MessageProcessScheduler;
import kz.halykfinance.HalykFinanceTask.service.IClientService;
import kz.halykfinance.HalykFinanceTask.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class HalykFinanceTaskApplicationTests {

	@Autowired
	private IClientService clientService;
	@Autowired
	private IMessageService messageService;
	@Autowired
	private MessageProcessScheduler messageProcessScheduler;

	@Test
	public void createClient(){
		ClientDto clientDto = new ClientDto();
		clientDto.setLogin("westcoast.kz@mail.ru");
		clientDto.setFirstName("Marlen");
		clientDto.setLastName("Myrzakhanov");
		clientDto.setMiddleName("Berikovich");
		clientDto.setBirthDate(LocalDate.parse("1993-06-06"));

		clientDto = clientService.createClient(clientDto);

		assertNotNull(clientDto.getId());
		assertNotNull(clientDto.getCreatedDate());
	}

	@Test
	public void testSendMessage() {
		ClientDto clientDto = new ClientDto();
		clientDto.setLogin("marlenmyrzakhanov@gmail.com");
		clientDto.setFirstName("Marlen");
		clientDto.setLastName("Myrzakhanov");
		clientDto.setMiddleName("Berikovich");
		clientDto.setBirthDate(LocalDate.parse("1993-06-06"));

		clientService.createClient(clientDto);
		MessageDto messageDto = new MessageDto();
		messageDto.setClientLogin("marlenmyrzakhanov@gmail.com");
		messageDto.setBody("It is test message");
		messageService.sendMessage(messageDto);
		messageProcessScheduler.processMessages();
	}
}
