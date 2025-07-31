package com.wellsfargo.counselor.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Security {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long securityId;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String category; // e.g., "Stocks", "Bonds"

  @Column(nullable = false)
  private LocalDate purchaseDate;

  @Column(nullable = false)
  private Double purchasePrice;

  @Column(nullable = false)
  private Integer quantity;

  @ManyToOne
  @JoinColumn(name = "portfolio_id", nullable = false)
  private Portfolio portfolio;

  // Constructor
  public Security(String name, String category, LocalDate purchaseDate,
                  Double purchasePrice, Integer quantity) {
    this.name = name;
    this.category = category;
    this.purchaseDate = purchaseDate;
    this.purchasePrice = purchasePrice;
    this.quantity = quantity;
  }

  // Getters and Setters
  public Long getSecurityId() { return securityId; }
  public Portfolio getPortfolio() { return portfolio; }
  public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
  // ... (other getters/setters)
}
