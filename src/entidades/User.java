package entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;

	@Column(name="hash")
	private String hash;

	@Column(name="online")
	private Boolean online;

	@Column(name="status")
	private Boolean status;

	@Column(name="create_date")
	private Date criacao;

	@Column(name="expirate_date")
	private Date expirate;

	public int getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Boolean getOnline() {
		return online;
	}

	public void setOnline(Boolean online) {
		this.online = online;
	}

	public Boolean getStatus() {
		return status;
	}

	public Date getExpirate() {
		return expirate;
	}
	

}
