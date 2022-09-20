package com.techmind.project_enterprise.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaction;

    @Column(name = "concept_transaction", nullable = false, length = 150)
    private String concept_transaction;

    @Column(name = "amount_transaction", nullable = false, length = 50)
    private Float amount_transaction;

    @ManyToOne
    @JoinColumn(name = "idEnterprise", nullable = false, foreignKey = @ForeignKey(name="fk_enterprise"))
    private Enterprise enterprise;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


}
