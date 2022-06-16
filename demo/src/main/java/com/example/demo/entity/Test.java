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

@Getter  // getter �ڵ�����
@Setter  // setter �ڵ�����
@Entity(name="test") // ���̺� ���� �ۼ�
public class Test {

	@Id // �⺻Ű 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // �ڵ����� auto_increment
    private Long id;

    @Column(nullable = false, length = 50) // �÷� �Ӽ� �Է�
    private String name;
    
    // ������
    public Test(String name) {
        this.name = name;
    }
    
    public Test(){}
}
