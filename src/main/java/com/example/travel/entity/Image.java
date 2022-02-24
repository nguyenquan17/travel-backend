package com.example.travel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="`Image`")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "`image`", length = 225,nullable = false )
	private String imageUrl;

	@ManyToOne
	@JoinColumn(name="id_tourDetail", nullable = false)
	private TourDetail idTourDetail;

	public Image(int id, String imageUrl) {
		this.id = id;
		this.imageUrl = imageUrl;
	}
}
