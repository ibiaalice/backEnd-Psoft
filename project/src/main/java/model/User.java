package model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@Entity
@Getter @Setter @ToString(exclude="codeUser")
@EqualsAndHashCode(exclude={"firstName", "lastName"})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private String email;
	@Getter @Setter private String firstName;
	@Getter @Setter private String lastName;
	@Setter private String passwd;
	
	public User(String firstName, String lastName, String email, String passwd) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passwd = passwd;
	}
	
	
}
