/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alvarto.card.repository;

import alvarto.card.model.CardModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class CardRepository implements ICardRepository{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<CardModel> findAll() {
        String SQL = "SELECT * FROM cards where status=1";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(CardModel.class));
    }

    @Override
    public int save(CardModel card) {
        String SQL = "INSERT into cards values (?,?,?,?,?)";
        return jdbcTemplate.update(SQL, new Object []{card.getName(),card.getNumber(),card.getType(),card.getCvv(),card.getStatus()});
    }

    @Override
    public int update(CardModel card) {
        String SQL = "UPDATE cards SET name=?,number=?,type=?,cvv=? WHERE id_card =?";
        return jdbcTemplate.update(SQL, new Object []{card.getName(),card.getNumber(),card.getType(),card.getCvv(),card.getId_card()});
    }

    @Override
    public int deleteById(int id) {
        String SQL = "UPDATE cards SET status=0 where id_card=?";
        return jdbcTemplate.update(SQL, new Object []{id});
    }
    
}
