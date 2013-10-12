package com.pb.project.entity.impl;

import java.util.Date;
import com.pb.project.entity.Entity;

public class Client implements Entity {
	
	private Integer id;
	private String inn;
    private String firstName;
    private String lastName;
    private String patronymic;
    private Date birthDay;
    private String passportNumber;
    private byte[] image;
    
	public Client() {
	}
    
	public Client(String passportNumber) {
		super();
		this.passportNumber = passportNumber;
	}

	public Client(Integer id, String inn, String firstName, String lastName,
			String patronymic, Date birthDay, String passportNumber, byte[] image) {
		super();
		this.id = id;
		this.inn = inn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.patronymic = patronymic;
		this.birthDay = birthDay;
		this.passportNumber = passportNumber;
                this.image = image;
	}
        public Client(Integer id, String inn, String firstName, String lastName,
			String patronymic, Date birthDay, String passportNumber) {
		super();
		this.id = id;
		this.inn = inn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.patronymic = patronymic;
		this.birthDay = birthDay;
		this.passportNumber = passportNumber;
	}
        
        

        @Override
	public Integer getId() {
		return id;
	}
	
        @Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getInn() {
		return inn;
	}
	
	public void setInn(String inn) {
		this.inn = inn;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPatronymic() {
		return patronymic;
	}
	
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	
	public Date getBirthDay() {
		return birthDay;
	}
	
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	public String getPassportNumber() {
		return passportNumber;
	}
	
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", inn=" + inn + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", patronymic=" + patronymic
				+ ", birthDay=" + birthDay + ", passportNumber="
				+ passportNumber + "]";
	}   

    /**
     * @return the image
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(byte[] image) {
        this.image = image;
    }
}
