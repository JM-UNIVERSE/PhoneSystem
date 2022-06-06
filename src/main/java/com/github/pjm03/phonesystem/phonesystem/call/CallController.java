package com.github.pjm03.phonesystem.phonesystem.call;

import com.github.pjm03.phonesystem.phonesystem.api.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestControllerAdvice
@RequestMapping("call")
@RequiredArgsConstructor
public class CallController {
    private final CallService callService;

    @GetMapping("/{from}")
    public ResponseEntity<?> start(
            @PathVariable String from,
            @RequestParam String to,
            @RequestParam String type
    ) {
        callService.startCall(from, to, type);
        return Response.success(null);
    }

    @GetMapping("/{from}/end")
    public ResponseEntity<?> end(
            @PathVariable String from
    ) {
        CallHistory callHistory = callService.endCall(from);

        return Response.success(new LinkedHashMap<>() {{
            put("from", callHistory.getFrom());
            put("to", callHistory.getTo());
            put("start", callHistory.getStart());
            put("end", callHistory.getEnd());
            put("callTime", (callHistory.getEnd() - callHistory.getStart()));
            put("type", callHistory.getType());
        }});
    }

    @GetMapping("/{phoneNumber}/history")
    public ResponseEntity<?> history(
            @PathVariable String phoneNumber,
            @RequestParam(required = false, defaultValue = "ALL") HistoryType type,
            Pageable pageable
    ) {
        List<CallHistory> histories = callService.getHistories(phoneNumber, type, pageable);
        return Response.success(histories);
    }

}
