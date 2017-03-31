package fitness.backend.client.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fitness.backend.utils.LocalDateSerializer;
import fitness.backend.utils.LocalDateDeserializer;
import lombok.*;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.time.LocalDate;
import fitness.backend.utils.validation.idnumber.SaIdNumber;
import fitness.backend.utils.validation.general.CheckAtLeastOneNotNull;

@Entity
@Data
@NoArgsConstructor
@Table(uniqueConstraints =
@UniqueConstraint(columnNames = {"email", "saIdNumber", "passportNumber"}))
@CheckAtLeastOneNotNull(fieldNames = {"saIdNumber", "passportNumber"})
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
    @Email(message = "The specified email address is already in use")
    private String email;

    @SaIdNumber
    private String saIdNumber;

    private String passportNumber;

    private String phoneNumber;
}
