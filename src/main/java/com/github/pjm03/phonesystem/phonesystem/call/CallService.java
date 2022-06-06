package com.github.pjm03.phonesystem.phonesystem.call;

import com.github.pjm03.phonesystem.phonesystem.phone.Phone;
import com.github.pjm03.phonesystem.phonesystem.phone.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CallService {
    private final HashMap<String, Call> callMap = new HashMap<>();
    private final PhoneService phoneService;
    private final CallHistoryRepository callHistoryRepository;

    public void startCall(String from, String to, String type) {
        callMap.put(from, new Call(from, to, System.currentTimeMillis(), Type.valueOf(type)));
    }

    public CallHistory endCall(String from) {
        Call call = callMap.remove(from);
        long end = System.currentTimeMillis();
        CallHistory history = new CallHistory(-1, call.getFrom(), call.getTo(), call.getStart(), end, call.getType());
        return callHistoryRepository.save(history);
    }

    public List<CallHistory> getHistories(String phoneNumber, HistoryType type, Pageable pageable) {
        Page<CallHistory> histories = switch (type) {
            case ALL -> callHistoryRepository.findByFromOrTo(phoneNumber, phoneNumber, pageable);
            case INCOMING -> callHistoryRepository.findByTo(phoneNumber, pageable);
            case OUTGOING -> callHistoryRepository.findByFrom(phoneNumber, pageable);
        };
        return histories.getContent();
    }
}
