package com.crud.repo;

import com.crud.entity.Root;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RootRepository extends JpaRepository<Root, Long> {

//    @Query("UPDATE Invoice SET number=:number WHERE id=:id")
//    Integer updateInvoiceNumberById(String number, Long id);

//@Query("SELECT ROOT where number=:number")

}
