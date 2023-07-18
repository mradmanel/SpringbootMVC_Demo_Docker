


	package com.sip.entities;

	import java.util.List;

	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;


	

	@Entity
	public class Provider {
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;
        
		@Column(name = "logo")
	    private String logo;
		
	    @Column(name = "name")
	    private String name;
	     
	    @Column(name = "email")
	    private String email;
     
	    @Column(name = "telephone")
	    private String telephone;
	    
	    @Column(name = "address")
	    private String address;
	    
	    public Provider() {}
       
	public Provider(long id, String logo, String name, String email, String telephone, String address) {
			super();
			this.id = id;
			this.logo = logo;
			this.name = name;
			this.email = email;
			this.telephone = telephone;
			this.address = address;
			
		}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getLogo() {
		return logo;
	}


	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;}


	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Article> getProduits() {
		return articles;
	}
	public void setProduits(List<Article> produits) {
		this.articles = produits;
	}

	@Override
	public String toString() {
		return "Provider [id=" + id + ", logo=" + logo + ", name=" + name + ", email=" + email + ", telephone="
				+ telephone + ", address=" + address + "]";
	}
	
	    @OneToMany(cascade=CascadeType.ALL, mappedBy = "provider")
	    private List<Article> articles;

}
