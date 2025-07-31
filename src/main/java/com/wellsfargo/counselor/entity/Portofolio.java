package com.wellsfargo.counselor.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column
    private Double totalValue; // Derived from securities (calculated in service layer)

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Security> securities;

    // Constructor
    public Portfolio(Client client) {
        this.client = client;
        this.totalValue = 0.0; // Initialize to 0
    }

    // Getters and Setters
    public Long getPortfolioId() { return portfolioId; }
    public Client getClient() { return client; }
    // ... (other getters/setters)
}
