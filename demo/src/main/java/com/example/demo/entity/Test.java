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
@Entity(name="test") // ���̺� ���� �ۼ�
@Builder // ������ ����� �� �ְ� ��
public class Test {

	@Id // �⺻Ű 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // �ڵ�����
    private Long id;

    @Column(nullable = false, length = 50) // �÷� �Ӽ� �Է�
    private String name;
    
    @Builder
    public Test(String name) {
        this.name = name;
    }
    
    public Test(){}
}
