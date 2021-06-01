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
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="personnel_verification_id", referencedColumnName = "id")
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employer_personnel_verifications")
public class EmployerPersonnelVerification extends PersonnelVerification{

	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
}
