/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author User
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="academic_title_hist")
public class AcademicTitleHistory {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="start_date")
    private LocalDate startDate;
    
    @Column(name="end_date")
    private LocalDate endDate;
    
    @ManyToOne
    @JoinColumn(name="academic_title")
    private AcademicTitle academicTitle;
    
    @ManyToOne
    @JoinColumn(name="scientific_field")
    private AcademicTitle scientificField;
    
    @ManyToOne
    @JoinColumn(name="member")
    private Member member;  

}
