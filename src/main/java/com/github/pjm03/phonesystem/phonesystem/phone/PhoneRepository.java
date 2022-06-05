package com.github.pjm03.phonesystem.phonesystem.phone;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {
    Phone save(Phone phone);
    List<Phone> findByOwner(String owner);
}
