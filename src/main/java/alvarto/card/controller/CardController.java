/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alvarto.card.controller;

import alvarto.card.model.CardModel;
import alvarto.card.model.ServiceResponse;
import alvarto.card.service.ICardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("api/v1/card")
@CrossOrigin("*")
public class CardController {
    
    @Autowired
    private ICardService iCardService;
    
    @GetMapping("/list")
    public ResponseEntity<List<CardModel>> list(){
        var result = iCardService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody CardModel card){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCardService.save(card);
        if(result==1){
            serviceResponse.setMessage("item agregado");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
    
    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody CardModel card){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCardService.update(card);
        if(result==1){
            serviceResponse.setMessage("item cambiado");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> update(@PathVariable int id){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCardService.deleteById(id);
        if(result==1){
            serviceResponse.setMessage("item eliminado");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }    
}
