package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity(name="test") // 테이블 명을 작성
@Builder // 빌더를 사용할 수 있게 함
public class Test {

	@Id // 기본키 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동생성
    private Long id;

    @Column(nullable = false, length = 50) // 컬럼 속성 입력
    private String name;
    
    @Builder
    public Test(String name) {
        this.name = name;
    }
    
    public Test(){}
}
