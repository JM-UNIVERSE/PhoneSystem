package com.github.pjm03.phonesystem.phonesystem.phone;

import com.github.pjm03.phonesystem.phonesystem.exception.PhoneNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneService {
    private final PhoneRepository phoneRepository;

    public Phone create(String humanSerial, String phoneNumber) {
        Phone phone = new Phone(-1, humanSerial, phoneNumber);
        return phoneRepository.save(phone);
    }

    public Phone getPhone(String phoneNumber) {
        return phoneRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new PhoneNotFoundException("'%s'에 해당하는 Phone 정보를 찾을 수 없습니다.".formatted(phoneNumber)));
    }

    public List<Phone> getPhones(String humanSerial) {
        return phoneRepository.findByOwner(humanSerial);
    }
}
