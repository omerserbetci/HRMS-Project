package HRMS.hrms.core.utilities.helper.concretes;

import java.util.Random;

public class VerificationCodeHelper {

	public static String generateCode() {
		Random rnd = new Random();
		String code = "";
		for(int j=0; j<4; j++) {
			code += (char)(rnd.nextInt(26) + 65);			 
		}
		code += rnd.nextInt(90) + 10;
		return code;
	}
	
}
