package com.example.demo.repository;

import com.example.demo.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
	
// JpaRepository<class��, �⺻Ű Ÿ��>
@Repository
public interface TestRepository extends JpaRepository<Test, Long>{

}
