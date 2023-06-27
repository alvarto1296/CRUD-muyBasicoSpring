/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package alvarto.card.service;

import alvarto.card.model.CardModel;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface ICardService {
     //listar todo
    public List<CardModel> findAll();
    
    public int save (CardModel card);
    public int update (CardModel card);
    public int deleteById (int id);
}
