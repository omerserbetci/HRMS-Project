package HRMS.hrms.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
@PrimaryKeyJoinColumn(name = "verification_code_id", referencedColumnName = "id")
@Table(name="employer_verification_codes")
public class EmployerVerificationCode extends VerificationCode {

	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
}
