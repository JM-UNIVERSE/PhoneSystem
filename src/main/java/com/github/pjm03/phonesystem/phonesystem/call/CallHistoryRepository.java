package com.github.pjm03.phonesystem.phonesystem.call;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallHistoryRepository extends JpaRepository<CallHistory, Integer> {
    CallHistory save(CallHistory callHistory);
    Page<CallHistory> findByFrom(String from, Pageable pageable);
    Page<CallHistory> findByTo(String to, Pageable pageable);
    Page<CallHistory> findByFromOrTo(String from, String to, Pageable pageable);
}
