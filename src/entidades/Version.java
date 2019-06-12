package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="version")
public class Version {
	
	@Id
	@Column(name="id")
	private int id;

	@Column(name="version")
	private String version;

	@Column(name="status")
	private int status;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
}
