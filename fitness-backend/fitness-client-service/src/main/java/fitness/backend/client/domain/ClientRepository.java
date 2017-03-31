package fitness.backend.client.domain;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import java.time.LocalDate;


public interface ClientRepository extends CrudRepository<Client, Integer>, JpaSpecificationExecutor<Client> {
   class Specifications{
       public static Specification<Client> firstNameIs(String firstName) {
           return (root, query, cb) -> cb.like(root.get("firstName"), firstName);
       }

       public static Specification<Client> lastNameIs(String lastName) {
           return (root, query, cb) -> cb.like(root.get("lastName"), lastName);
       }

       public static Specification<Client> birthDateIsBetween(LocalDate from, LocalDate to) {
           return (root, query, cb) -> cb.between(root.get("birthDate"), from, to);
       }

       public static Specification<Client> birthDateIsBefore(LocalDate limit) {
           return (root, query, cb) -> cb.lessThan(root.get("birthDate"), limit);
       }

       public static Specification<Client> emailIs(String email) {
           return (root, query, cb) -> cb.equal(root.get("email"), email);
       }

       public static Specification<Client> clientIdIs(Long clientId) {
           return (root, query, cb) -> cb.equal(root.get("id"), clientId);
       }


       public static Sort orderByLastNameDesc() {
           return new Sort(Sort.Direction.DESC, "lastName");
       }
   }
}
