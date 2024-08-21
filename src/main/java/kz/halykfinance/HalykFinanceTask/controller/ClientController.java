package kz.halykfinance.HalykFinanceTask.controller;

import kz.halykfinance.HalykFinanceTask.dto.ClientDto;
import kz.halykfinance.HalykFinanceTask.json.ClientJson;
import kz.halykfinance.HalykFinanceTask.mapping.ClientMapper;
import kz.halykfinance.HalykFinanceTask.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    @Autowired
    private IClientService clientService;
    @Autowired
    private ClientMapper clientMapper;

    @PostMapping("/create")
    public ResponseEntity<ClientJson> createClient(@RequestBody ClientJson clientJson){

        ClientDto clientDto = clientService.createClient(clientMapper.toDto(clientJson));
        return new ResponseEntity<>(clientMapper.toJson(clientDto), HttpStatus.CREATED);
    }
}
