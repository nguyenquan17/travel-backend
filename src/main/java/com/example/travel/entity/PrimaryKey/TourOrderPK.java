package com.example.travel.entity.PrimaryKey;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TourOrderPK implements Serializable {
    @Column(name = "id_user", nullable = false)
    private int idUser;

    @Column(name = "id_tourDetail", nullable = false)
    private int idTourDetail;

    public TourOrderPK() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdTourDetail() {
        return idTourDetail;
    }

    public void setIdTourDetail(int idTourDetail) {
        this.idTourDetail = idTourDetail;
    }
}
