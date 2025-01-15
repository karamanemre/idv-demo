package com.idv.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity(name = "logs")
public class LogEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(name = "payload")
    private String payload;

    @Column(name = "user_name")
    private String username;

    @Column(name = "request_method")
    private String requestMethod;

    @Column(name = "request_uri")
    private String requestUri;

    @Column(name = "class_name")
    private String className;

    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "error_message")
    private String errorMessage;

    @Enumerated(EnumType.STRING)
    @Column(name = "log_level")
    private LogLevel logLevel;

    public enum LogLevel {
        ERROR, WARN, SUCCESS
    }
}
