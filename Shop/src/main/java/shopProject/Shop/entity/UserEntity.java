package shopProject.Shop.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Builder
@Table(name = "tbl_users")
public class UserEntity {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String userId;
	private String email;
	private String password;
	private String role;
	private String name;
	
	@CreationTimestamp
    @Column(updatable = false)
	private Timestamp createdAt;
	@UpdateTimestamp
    private Timestamp updatedAt;
	
	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}

	public String getUserId() {
	    return userId;
	}

	public void setUserId(String userId) {
	    this.userId = userId;
	}

	public String getEmail() {
	    return email;
	}

	public void setEmail(String email) {
	    this.email = email;
	}

	public String getPassword() {
	    return password;
	}

	public void setPassword(String password) {
	    this.password = password;
	}

	public String getRole() {
	    return role;
	}

	public void setRole(String role) {
	    this.role = role;
	}

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public Timestamp getCreatedAt() {
	    return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
	    this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
	    return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
	    this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
	    return "UserEntity{" +
	            "id=" + id +
	            ", userId='" + userId + '\'' +
	            ", email='" + email + '\'' +
	            ", password='" + password + '\'' +
	            ", role='" + role + '\'' +
	            ", name='" + name + '\'' +
	            ", createdAt=" + createdAt +
	            ", updatedAt=" + updatedAt +
	            '}';
	}

	
}
