package com.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.configuration.HibernateUtil;
import com.model.Student;

public class ServiceDaoImpl implements serviceImpl {

	@Override
	public void insert() {
		int rollno;
		String stname;
		String Address;
		
		Scanner sc=new Scanner(System.in);
		SessionFactory  sessionFactory	=HibernateUtil.getSessionFacotry();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		System.out.println("Enter a rollno");
		rollno=sc.nextInt();
		System.out.println("Enter a String name");
		stname=sc.next();
		System.out.println("Enter Address");
		Address=sc.next();
		Student stu1=new Student();
stu1.setRollno(rollno);
stu1.setStname(stname);
stu1.setAddress(Address);

session.save(stu1);
		
		tx.commit();
		
		
	}

	@Override
	public void update() {

		 
		 String stname;
		 String Address;
		Scanner sc=new Scanner(System.in);
		
		SessionFactory  sessionFactory	=HibernateUtil.getSessionFacotry();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();

		System.out.println("Enter a name");
		stname=sc.next();
		System.out.println("Enter a adddress");
		Address=sc.next();
		
		
		Query q=	session.createQuery("update Student set stname=:n,Address=:a where rollno=:rno ");
		q.setParameter("n", stname);
		q.setParameter("a", Address);
		q.setParameter("rno", 223);
		int update=q.executeUpdate();
		System.out.println(update);
		tx.commit();
	}

	@Override
	public void delete() {
		int rollno;
		
		SessionFactory  sessionFactory	=HibernateUtil.getSessionFacotry();
		Scanner sc=new Scanner(System.in);
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		System.out.println("Enter a rollno");
		rollno=sc.nextInt();
	Query q=	session.createQuery("delete from Student where rollno=:rno");
	q.setParameter("rno", rollno);
int delete=	q.executeUpdate();
System.out.println(delete);
tx.commit();
		
	}

	@Override
	public void select() {
		SessionFactory  sessionFactory	=HibernateUtil.getSessionFacotry();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=	session.createQuery("from Student");
		List<Student> list = q.getResultList();
		for(Student st:list ) {
			
			System.out.println(st.getRollno());
			System.out.println(st.getStname());
			System.out.println(st.getAddress());
			
		}
		
	}

}
