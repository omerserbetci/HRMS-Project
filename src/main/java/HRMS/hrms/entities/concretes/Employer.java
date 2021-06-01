package HRMS.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employerPhoneNumbers", "employerVerificationCodes", "employerPersonelVerifications"})
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@Table(name="employers")
public class Employer extends User{

	@Column(name="company_name")
	private String companyName;
	
	@Column(name="website")
	private String website;
	
	@OneToMany(mappedBy = "employer")
	private List<EmployerPhoneNumber> employerPhoneNumbers;
	
	@OneToMany(mappedBy = "employer")
	private List<EmployerVerificationCode> employerVerificationCodes;
	
	@OneToMany(mappedBy = "employer")
	private List<EmployerPersonnelVerification> employerPersonelVerifications;
	
}
