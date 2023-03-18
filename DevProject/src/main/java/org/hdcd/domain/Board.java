package org.hdcd.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of="boardNo")
@ToString
@Entity
@Table(name="board")
public class Board {
   
   @Id
   @SequenceGenerator(name="BOARD_SEQUENCE_GEN",sequenceName="seq_board",initialValue=1,allocationSize=1)
   @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="BOARD_SEQUENCE_GEN")
   private Long boardNo;
   
   @NotBlank
   @Column(length=200,nullable=false)
   private String title;
   
   @NotBlank
   @Column(length=50,nullable=false)
   private String writer;
   
   @Lob
   private String content;
   
   @CreationTimestamp
   private LocalDateTime regDate;
   
}