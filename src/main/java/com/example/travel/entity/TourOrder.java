package com.example.travel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.example.travel.entity.PrimaryKey.TourOrderPK;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="`TourOrder`")
@Setter
@Getter
@NoArgsConstructor
public class TourOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TourOrderPK composeId;

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	 @Column(name = "name_order" ,length = 255,nullable = false)
	private String nameOrder;
	
	@Column(name = "date_order",nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date dateOrder;
	
	@Column(name = "cost_order" ,length = 255,nullable = false)
	private String costOrder;
	
	@Column(name = "number_of_people" ,nullable = false)
	private int numberOfPeople;
	
	@Column(name = "number_of_rooms" ,nullable = false)
	private int numberOfRooms;

	//foreign key
	@OneToOne(cascade = CascadeType.ALL)
	private Payment paymentMethod;

	@OneToOne(cascade = CascadeType.ALL)
	private TourDetail tourDetail;

	@ManyToOne
	@JoinColumn(name="id_user", nullable = false, insertable = false, updatable = false)
	private User customer;

}