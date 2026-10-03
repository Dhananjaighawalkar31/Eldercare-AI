package com.dhanu.eldercareai.repository;

import com.dhanu.eldercareai.Entity.Elder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElderRepository extends JpaRepository<Elder,Long> {
}
