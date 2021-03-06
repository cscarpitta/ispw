package control.registration;

import java.io.IOException;

import entity.Scout;
import entity.persistence.Save;
import exception.AlreadyRegisteredException;
import exception.EmptyFieldException;
import exception.FileException;
import exception.PasswordMismatchException;

public class RegistrationScout {
	public static void registerScout(String password, String confirmPassword, String email) throws EmptyFieldException, PasswordMismatchException, IOException, AlreadyRegisteredException, ClassNotFoundException, FileException {

		if (password.equals("") || confirmPassword.equals("") || 
				email.equals("") ) {
			//At least an empty field
			throw new EmptyFieldException();
		} else {
			//All fields have been filled
			if (!password.equals(confirmPassword)) {
				//Password and ConfirmPassword don't match
				throw new PasswordMismatchException();
			} else {
				Scout scout = new Scout(email,password);
				Save.getInstance().insertScout(scout);
			}
		}
	}
}
