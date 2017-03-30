package fitness.backend.client.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fitness.backend.utils.LocalDateSerializer;
import fitness.backend.utils.LocalDateDeserializer;
import lombok.*;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@Table(uniqueConstraints =
@UniqueConstraint(columnNames = {"email"}))
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @NonNull
    private LocalDate dateOfBirth;

    @NonNull
    @Email
    private String email;


}
