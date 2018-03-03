package com.example.demo.repositories;

import com.example.demo.model.Guerrier;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GuerrierRepository  {

    @Insert("Insert into Guerrier (name,level) VALUES (#{name}, #{level})")
    void save(Guerrier guerriers);

    @Select("select * from Guerrier")
    List<Guerrier> findAll();
}
