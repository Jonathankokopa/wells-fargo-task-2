package com.wellsfargo.counselor.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long ClientId;

  @Column(nullable = false)
  private String Name;

  @Column(nullable = false)
  private String Email;

  @Column(nullable = false)
  private String RiskTolerance;

  @ManyToOne
  @JoinColumn(name = "advisor_id", nullable = false)
  private FinancialAdvisor financialAdvisor;

  @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
  private Portfolio portfolio;

  // Constructor
  public Client(String name, String email, String riskTolerance) {
    this.name = name;
    this.email = email;
    this.riskTolerance = riskTolerance;

  // Constructor
  public Client(String name, String email, String riskTolerance) {
    this.name = name;
    this.email = email;
    this.riskTolerance = riskTolerance;
  }

    // Getters and Setters
    public Long getClientId() { return clientId; }
    public FinancialAdvisor getFinancialAdvisor() { return financialAdvisor; }
    public void setFinancialAdvisor(FinancialAdvisor financialAdvisor) {
      this.financialAdvisor = financialAdvisor;
  }
