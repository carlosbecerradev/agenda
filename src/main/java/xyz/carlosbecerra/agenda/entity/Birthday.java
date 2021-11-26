package xyz.carlosbecerra.agenda.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "birthdays")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Birthday {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long birthdayId;

	@Column(nullable = false, unique = true)
	private String title;

	@Column(nullable = false)
	private Byte day;

	@Column(nullable = false)
	private Byte month;

	private Byte year;

	@Column(nullable = false)
	private Boolean enabled;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	@PrePersist
	protected void onPersist() {
		createdAt = LocalDateTime.now();
		updatedAt = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = LocalDateTime.now();
	}

}
