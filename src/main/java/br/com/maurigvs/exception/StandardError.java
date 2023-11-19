package br.com.maurigvs.exception;

import jakarta.json.bind.annotation.JsonbDateFormat;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Schema(name = "ErrorMessage")
public class StandardError implements Serializable {

    @JsonbDateFormat
    private final ZonedDateTime timestamp = ZonedDateTime.now();

    private final String error;

    private final String message;

    public StandardError(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}