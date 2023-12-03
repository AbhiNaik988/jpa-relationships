package com.abhinaik.datajpa.repository;

import com.abhinaik.datajpa.models.Tablet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabletRepository extends JpaRepository<Tablet,Long> {

    Tablet findByBrand(String brand);
}
