package nl.qnh.qforce.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Data
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column
    private int statusCode;

    @Column
    private String message;

    @Column
    private LocalDateTime dateTime;

}
