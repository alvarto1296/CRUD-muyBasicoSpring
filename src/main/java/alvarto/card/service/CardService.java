/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alvarto.card.service;

import alvarto.card.model.CardModel;
import alvarto.card.repository.ICardRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class CardService implements ICardService{
    
    @Autowired
    private ICardRepository icardRepository;
    
    @Override
    public List<CardModel> findAll() {
        List<CardModel> list;
        try{
            list = icardRepository.findAll();
        }catch(Exception e){
            throw e;
        }
        return list;
    }

    @Override
    public int save(CardModel card) {
        int row;
        try{
            row = icardRepository.save(card);
        }catch(Exception e){
            throw e;
        }
        return row;
    }

    @Override
    public int update(CardModel card) {
        int row;
        try{
            row = icardRepository.update(card);
        }catch(Exception e){
            throw e;
        }
        return row;
    }

    @Override
    public int deleteById(int id) {
        int row;
        try{
            row = icardRepository.deleteById(id);
        }catch(Exception e){
            throw e;
        }
        return row;
    }
    
}
