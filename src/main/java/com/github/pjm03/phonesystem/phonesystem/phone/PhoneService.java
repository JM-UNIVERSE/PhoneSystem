package com.github.pjm03.phonesystem.phonesystem.phone;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneService {
    private final PhoneRepository phoneRepository;

    public Phone create(String humanSerial, String phoneNumber) {
        Phone phone = new Phone(-1, humanSerial, phoneNumber);
        return phoneRepository.save(phone);
    }

    public List<Phone> getPhones(String humanSerial) {
        return phoneRepository.findByOwner(humanSerial);
    }
}
