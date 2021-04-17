package com.enigma.reimbursment.online.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class  AbstractEntity<ID> {

    public abstract ID getId();

    public abstract void setId(ID id);

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modiefied_date")
    private LocalDateTime modifiedDate;

    @PrePersist
    public void prePersist(){
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        modifiedDate = LocalDateTime.now();

    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

}
