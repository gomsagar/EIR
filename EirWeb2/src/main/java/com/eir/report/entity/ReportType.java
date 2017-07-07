package com.eir.report.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

@Component
@Entity

@Table(name = "report_type", schema = "eir")
@EntityListeners(AuditingEntityListener.class)
public class ReportType {
	@Column(name = "report_type_id", nullable = false)
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="reportType_seq")
	@SequenceGenerator(
		name="reportType_seq",
		sequenceName="eir.reportType_sequence",
		allocationSize=1
	)
	String reportTypeId;
	
	@Column(name = "report_type_description", length = 45)
	

	String reportTypeDescription;
	
	
	public String getReportTypeId() {
		return reportTypeId;
	}
	public void setReportTypeId(String reportTypeId) {
		this.reportTypeId = reportTypeId;
	}
	public String getReportTypeDescription() {
		return reportTypeDescription;
	}
	public void setReportTypeDescription(String reportTypeDescription) {
		this.reportTypeDescription = reportTypeDescription;
	}
}
