package com.example.travel.entity;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String username;
    
    @Column(name = "`password`", length = 255,nullable = false)
    private String password;
    
    @Column(name = "`active`",nullable = false)
    private Boolean active;

    //1 manager -> create n tour
	@OneToMany(mappedBy = "manager")
    private List<TourDetail> tourDetailList;

    //1 customer -> have n orders
    @OneToMany(mappedBy = "customer")
    private List<TourOrder> tourOrderList;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_role")
    private Role role;
}
