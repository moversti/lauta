package moversti.lauta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Postaus {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	private Long lankaID;

	private String content;


	public Long getLankaID() {
		return lankaID;
	}

	public void setLankaID(Long lankaID) {
		this.lankaID = lankaID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


}
