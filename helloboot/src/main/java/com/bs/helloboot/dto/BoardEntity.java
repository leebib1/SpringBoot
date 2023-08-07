package com.bs.helloboot.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="board")
@SequenceGenerator(name="seq_boardno",sequenceName="seq_boardno")
public class BoardEntity {
	@Id
	@GeneratedValue(generator = "seq_boardno",strategy=GenerationType.SEQUENCE)
	@Column(name="boardno")
	private long boardNo; //시퀀스 번호가 계속 증가해서 int범위를 넘어설 수 있기 때문에 보통 long 타입을 지정한다.
	@Column(name="boardtitle")
	private String boardTitle;
	@Column(name="boardwirter")
	private String boardWriter;
	@Column(name="boardcontent")
	private String boardContent;
	@Column(name="boarddate")
	private Date boardDate;
	@Column(name="boardreadcount")
	private int boardreadCount;
}
