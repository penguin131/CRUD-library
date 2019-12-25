package myApp.utils;

import myApp.model.Role;
import myApp.model.User;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.util.Map;

public class LibraryLoginModule implements LoginModule {
	private Subject subject;
	private CallbackHandler callbackHandler;
	private String password;
	private String name;

	public boolean abort() throws LoginException {
		return true;
	}

	public boolean commit() throws LoginException {
		return true;
	}

	private void populateRoles() {
		// add user's roles to subject being authenticated
		subject.getPrincipals().add(new Role("admin"));
	}

	private void authenticate() throws LoginException {
		if (!name.equals("sa") || !password.equals("sa")) {
			throw new LoginException();
		}
		subject.getPrincipals().add(new User(name));
	}

	public void initialize(Subject subject, CallbackHandler callbackHandler,
						   Map<String, ?> sharedState, Map<String, ?> options) {
		this.subject = subject;
		this.callbackHandler = callbackHandler;
	}

	public boolean login() throws LoginException {
		NameCallback name = new NameCallback("User name");
		PasswordCallback password = new PasswordCallback("Password", true);
		try {
			this.callbackHandler.handle(new Callback[] { name, password });
			this.name = name.getName();
			this.password = new String(password.getPassword());
		} catch (Exception e) {
			throw new LoginException(e.getMessage());
		}
		if (this.name.isEmpty()) {
			throw new CredentialNotFoundException("User name is required");
		}
		if (this.password.isEmpty()) {
			throw new CredentialNotFoundException("Password is required");
		}
		authenticate();
		populateRoles();
		return true;
	}

	public boolean logout() throws LoginException {
		return true;
	}
}
