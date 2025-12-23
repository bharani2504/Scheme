package com.example.Scheme.Repository;

import com.example.Scheme.Entity.Accountdetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Accountdetails,Integer> {

  Optional<Accountdetails>findByAccountno(String accountno);
  List<Accountdetails> findAllByOrderByCreatedAtAsc();

}
