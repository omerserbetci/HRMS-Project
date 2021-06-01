package HRMS.hrms.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="phone_number_id", referencedColumnName = "id")
@Table(name="employer_phone_numbers")
public class EmployerPhoneNumber extends PhoneNumber{

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
}
