package com.draczek.SystemOgloszeniowy.common.entity;

import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Shared Audit entity, used as a super class for other entities.
 */
@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class AuditableEntity implements Serializable {

  @CreatedDate
  @Column(name = "created_date")
  protected LocalDateTime createdDate;

  @CreatedBy
  @Column(name = "user_id_created")
  protected Long userIdCreated;

  @LastModifiedDate
  @Column(name = "last_modified_date")
  protected LocalDateTime lastModifiedDate;

  @LastModifiedBy
  @Column(name = "user_id_last_modified")
  protected Long userIdLastModified;

  @NotNull
  protected StatusEnum status;

  @Version
  @NotNull
  @Min(0)
  protected Integer version;
}