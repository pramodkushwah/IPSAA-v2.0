package com.synlabs.ipsaa.entity.student;

import com.synlabs.ipsaa.entity.common.BaseEntity;
import com.synlabs.ipsaa.enums.PaymentMode;
import com.synlabs.ipsaa.enums.PaymentStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class StudentFeePaymentRecord extends BaseEntity
{

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private Student student;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private StudentFeePaymentRequest request;

  @Temporal(TemporalType.DATE)
  private Date paymentDate;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 20)
  private PaymentStatus paymentStatus;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private PaymentMode paymentMode;

  @Column(length = 200)
  private String txnid;

  @Column(precision = 16, scale = 2, nullable = false)
  private BigDecimal paidAmount;

  private Boolean confirmed = false;

  @Override
  public String toString()
  {
    return "{" +
        "admission_number" + (student == null ? null : student.getAdmissionNumber()) +
        "paymentDate=" + paymentDate +
        ", paymentStatus=" + paymentStatus +
        ", paymentMode=" + paymentMode +
        ", txnid='" + txnid + '\'' +
        ", paidAmount=" + paidAmount +
        ", confirmed=" + confirmed +
        '}';
  }

  public Boolean getConfirmed()
  {
    return confirmed;
  }

  public void setConfirmed(Boolean confirmed)
  {
    this.confirmed = confirmed;
  }

  public Student getStudent()
  {
    return student;
  }

  public void setStudent(Student student)
  {
    this.student = student;
  }

  public StudentFeePaymentRequest getRequest()
  {
    return request;
  }

  public void setRequest(StudentFeePaymentRequest request)
  {
    this.request = request;
  }

  public Date getPaymentDate()
  {
    return paymentDate;
  }

  public void setPaymentDate(Date paymentDate)
  {
    this.paymentDate = paymentDate;
  }

  public PaymentStatus getPaymentStatus()
  {
    return paymentStatus;
  }

  public void setPaymentStatus(PaymentStatus paymentStatus)
  {
    this.paymentStatus = paymentStatus;
  }

  public PaymentMode getPaymentMode()
  {
    return paymentMode;
  }

  public void setPaymentMode(PaymentMode paymentMode)
  {
    this.paymentMode = paymentMode;
  }

  public String getTxnid()
  {
    return txnid;
  }

  public void setTxnid(String txnid)
  {
    this.txnid = txnid;
  }

  public BigDecimal getPaidAmount()
  {
    return paidAmount;
  }

  public void setPaidAmount(BigDecimal paidAmount)
  {
    this.paidAmount = paidAmount;
  }

}
