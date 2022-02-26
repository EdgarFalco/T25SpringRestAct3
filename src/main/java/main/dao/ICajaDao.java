package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Caja;

public interface ICajaDao extends JpaRepository<Caja, Character> {

}
