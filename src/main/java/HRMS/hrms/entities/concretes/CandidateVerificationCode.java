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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name="verification_code_id", referencedColumnName = "id")
@Table(name="candidate_verification_codes")
public class CandidateVerificationCode extends VerificationCode{

	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
}
