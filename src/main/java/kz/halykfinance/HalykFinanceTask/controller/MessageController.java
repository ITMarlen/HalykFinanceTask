package kz.halykfinance.HalykFinanceTask.controller;

import kz.halykfinance.HalykFinanceTask.json.MessageJson;
import kz.halykfinance.HalykFinanceTask.mapping.MessageMapper;
import kz.halykfinance.HalykFinanceTask.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/message")
public class MessageController {
    @Autowired
    public IMessageService messageService;
    @Autowired
    public MessageMapper messageMapper;

    @PostMapping("/send")
    public ResponseEntity<Void> sendMessage(@RequestBody MessageJson messageJson) {
        messageService.sendMessage(messageMapper.toDto(messageJson));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
