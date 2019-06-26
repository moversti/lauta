package moversti.lauta;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lanka {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nimi;

	@ElementCollection
	private List<Postaus> postaukset = new ArrayList<>();

	public List<Postaus> getPostaukset() {
		return postaukset;
	}

	public void setPostaukset(List<Postaus> postaukset) {
		this.postaukset = postaukset;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public Long getId() {
		return id;
	}
}
