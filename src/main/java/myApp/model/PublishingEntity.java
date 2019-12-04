package myApp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PUBLISHING", schema = "DB_BOOKS")
public class PublishingEntity {
	private int publishingId;
	private String name;
	@OneToMany (mappedBy = "publishing")
	private Set<BooksEntity> books = new HashSet<BooksEntity>();

	@Id
	@Column(name = "PublishingId", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getPublishingId() {
		return publishingId;
	}

	public void setPublishingId(int publishingId) {
		this.publishingId = publishingId;
	}

	@Basic
	@Column(name = "name", length = 255)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PublishingEntity that = (PublishingEntity) o;
		if (publishingId != that.publishingId) return false;
		return name.equals(that.name);
	}

	@Override
	public int hashCode() {
		int result = publishingId;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}
}
