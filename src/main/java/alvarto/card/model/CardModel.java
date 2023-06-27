/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alvarto.card.model;

import lombok.Data;

/**
 *
 * @author USUARIO
 */
//geters and setter with lombok !!!figure out
@Data
public class CardModel {
    int id_card;
    String name;
    String number;
    String type;
    int cvv;
    int status;
            
}
