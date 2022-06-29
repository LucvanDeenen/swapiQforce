package nl.qnh.qforce.service;

import nl.qnh.qforce.domain.Log;
import nl.qnh.qforce.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogService {

    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    private <S extends Log> S save(S entity) {
        return logRepository.save(entity);
    }

    public void logRequest(boolean succes, int statusCode, String request) {
        handleLog(
                String.format("%s executed %s request", (succes ? "Successfully" : "Unsuccessfully"), request),
                statusCode
        );
    }

    private void handleLog(String message, int statusCode) {
        Log log = new Log();
        log.setMessage(message);
        log.setDateTime(LocalDateTime.now());
        log.setStatusCode(statusCode);
        save(log);
    }

}
