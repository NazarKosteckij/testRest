package com.test.rest.services.users;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.test.rest.dto.UserDto;
import com.test.rest.services.EmailService;
import com.test.rest.utils.mappers.UserMapper;
import com.test.rest.utils.mappers.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.rest.contstants.users.UserGender;
import com.test.rest.contstants.users.UserRoles;
import com.test.rest.contstants.users.UserStatuses;
import com.test.rest.dao.UserDao;
import com.test.rest.models.UserModel;
import com.test.rest.utils.MD5;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements UserService , UserDetailsService {

	private final String CONFIRMATION_URL = "http://localhost:8080/rest/confirmation/" ;

	@Autowired
	protected UserDao userDao;

	@Autowired
	protected EmailService emailService;

	protected UserMapper userMapper = new UserMapperImpl();

	protected UserValidator userValidator = new UserValidator();

	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public List<UserModel> getAll() {

		return userDao.getAll();
	}

	/**
	 * {@inheritDoc}
	 */
	public void addUser(UserDto userDto) {
		UserModel user = userMapper.createUserFromDto(userDto);
		validateUser(user);
		user.setConfirmationHash(MD5.getMD5(user.getEmail()));
		userDao.create(user);
		emailService.sendConfirmation(user.getEmail(), CONFIRMATION_URL + user.getConfirmationHash());
	}

	/**
	 * {@inheritDoc}
	 */
	public UserDto getById(Integer id) {
		if(id>0)
			return userMapper.userToDto(userDao.read(id));
		else {
			throwException();
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void updateUser(UserDto userDto) {
		UserModel user = userMapper.createUserFromDto(userDto);
		validateUser(user);

		if(user.getId()>0)
			userDao.update(user);
		else
			throwException();
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteUser(UserDto userDto) {
		UserModel user = userMapper.createUserFromDto(userDto);
		validateUser(user);
		userDao.delete(user);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean checkEmailExisting(String email) {
		if(userValidator.validateEmail(email)){
			return userDao.isEmailExists(email);
		} else return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void confirmRegistration(String token) {
		UserModel user = userDao.getByToken(token);
		if(userIsNotConfirmedAndTokenValid(user, token)){
			emailService.sendNotification(user.getEmail(), "Your registration is completed.");
			user.setStatus(UserStatuses.STATUS_CONFIRMED);
			userDao.update(user);
		}
		else {
			throw new IllegalArgumentException("Invalid token for this user or user already confirmed");
		}

	}

	public UserDto getByEmail(String email) {
		UserModel user =  userDao.getByEmail(email);
		return userMapper.userToDto(user);
	}

	public EmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	private void validateUser(UserModel user){
		userValidator.validateUser(user);
	}

	public void throwException(){
		throw new NullPointerException();
	}

	/**
	 * @param user {@link UserModel}
	 * @param token
	 * @return true when user status isn't "confirmed" and token belongs this user else returns false
	 */
	private boolean userIsNotConfirmedAndTokenValid(final UserModel user, final String token) {
		return !user.getStatus().equals(UserStatuses.STATUS_CONFIRMED) && token.equals(MD5.getMD5(user.getEmail()));
	}


	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			UserModel domainUser = userDao.getByEmail(username);

			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;

			return new User(
					domainUser.getEmail(),
					domainUser.getPassword(),
					enabled,
					accountNonExpired,
					credentialsNonExpired,
					accountNonLocked,
					getAuthorities(domainUser.getRole()));

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Collection<? extends GrantedAuthority> getAuthorities(String role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}

	public List<String> getRoles(String role) {
		List<String> roles = new ArrayList<String>();

		if (role.equals(UserRoles.ROLE_ADMIN)) {
			roles.add("ROLE_ADMIN");
			roles.add("ROLE_USER");

		} else if (role.equals(UserRoles.ROLE_USER)) {
			roles.add("ROLE_USER");

		} else if (role.equals(UserRoles.ROLE_MODERATOR)) {
			roles.add("ROLE_MODERATOR");
		}

		return roles;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}



	protected class UserValidator{
	private static final String EMAIL_PATTERN =
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private Matcher matcher;

	public UserValidator() {

	}

	public void validateUser(UserModel user){
		if(user != null){
			if(user.getRole()==null)
				user.setRole(UserRoles.ROLE_USER);
			if(user.getStatus()==null)
				user.setStatus(UserStatuses.STATUS_UNCONFIRMED);

			if(user.getBirthdate() != null)
				user.setBirthdate((Date) Calendar.getInstance().getTime());

			if(validateEmail(user.getEmail()) && validateGender(user.getGender())){
				if(validatePassword(user.getPassword())){
					
				} else {
					user.setPassword(MD5.getMD5(user.getPassword()));
				}
			} else throwException();
		}
	}
	
	protected boolean validateGender(final String gender) {
		return gender.equals(UserGender.GENDER_FEMALE) 
				|| gender.equals(UserGender.GENDER_MALE);
	}
	
	protected boolean validateEmail(final String email) {
		if (email != null) {
			Pattern pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(email);
			return matcher.matches();			
		} else return false; 
		
	}
	protected boolean validatePassword(final String password) {
		if(password.length() == 32)
			return true;
		else {
			return false;
		}
	}
 }
}
