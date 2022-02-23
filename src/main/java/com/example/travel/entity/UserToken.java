package com.example.travel.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="`User_Token`")
@Setter
@Getter
@NoArgsConstructor
public class UserToken implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "user_token" ,length = 255,nullable = false)
	private String userToken;

 	@OneToOne(cascade = CascadeType.ALL)
	private User idUser;

	public UserToken(String userToken, User idUser) {
		super();
		this.userToken = userToken;
		this.idUser = idUser;
	}
	

}
