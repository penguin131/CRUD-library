package myApp.model;

import javax.persistence.*;

@Entity
@Table(name = "BOOKS", schema = "DB_BOOKS")
public class BooksEntity {
	private int bookId;
	private String title;
	private int year;
	private float cost;
	private AuthorsEntity author;
	private PublishingEntity publishing;

	@Id
	@Column(name = "bookId", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	@Basic
	@Column(name = "title", length = 255)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@ManyToOne
	@JoinColumn(name = "author", nullable=false)
	public AuthorsEntity getAuthor() {
		return author;
	}

	public void setAuthor(AuthorsEntity author) {
		this.author = author;
	}

	@ManyToOne
	@JoinColumn(name = "publishing", nullable=false)
	public PublishingEntity getPublishing() {
		return publishing;
	}

	public void setPublishing(PublishingEntity publishing) {
		this.publishing = publishing;
	}

	@Column(name = "year")
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Column(name = "cost")
	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BooksEntity that = (BooksEntity) o;
		return bookId == that.bookId;
	}

	@Override
	public int hashCode() {
		int result = bookId;
		result = 31 * result + (title != null ? title.hashCode() : 0);
		return result;
	}
}
