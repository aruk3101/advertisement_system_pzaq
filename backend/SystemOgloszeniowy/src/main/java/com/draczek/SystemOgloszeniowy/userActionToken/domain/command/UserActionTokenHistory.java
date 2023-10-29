package com.draczek.SystemOgloszeniowy.userActionToken.domain.command;

import com.draczek.SystemOgloszeniowy.user.domain.command.User;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.enumerated.UserActionTokenEnum;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

/**
 * UserActionTokenHistory entity.
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "key", callSuper = false)
@Table(name = "users_actions_tokens_history")
class UserActionTokenHistory implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, updatable = false)
  private Long id;

  @NotNull
  @OneToOne
  @JoinColumn(name = "user_id")
  private User user;

  @NotNull
  private String key;

  @NotNull
  @CreatedDate
  private LocalDateTime createdDate;

  @NotNull
  private UserActionTokenEnum action;

  private LocalDateTime usedDate;

  @NotNull
  private LocalDateTime deletedDate;
}
