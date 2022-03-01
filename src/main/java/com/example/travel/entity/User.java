package com.example.travel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="`User`")
@Getter
@Setter
@NoArgsConstructor

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@Column(name = "`fullname`" ,length = 255,nullable = false)
    private String fullName;
	
    @Column(name = "`email`", length = 255,nullable = false)
    private String email;
    
    @Column(name = "`phone`", length = 255,nullable = false)
    private String phone;
    
    @Column(name = "`address`", length = 255,nullable = false)
    private String address;
    
    @Column(name = "`username`", length = 255,nullable = false)
    private String userName;
    
    @Column(name = "`password`", length = 255,nullable = false)
    private String password;
    
    @Column(name = "`active`",nullable = false)
    private Boolean active = true;

    //1 manager -> create n tour
	@OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    private List<TourDetail> tourDetailList;

    //1 customer -> have n orders
    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private List<TourOrder> tourOrderList;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_role", referencedColumnName = "id")
    private Role role;

	public User(int id, String fullName, String email, String phone, String address, String username, String password) {
	
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.userName = username;
		this.password = password;

	}

    public User(int id) {
        this.id = id;
    }
}

