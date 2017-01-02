package com.liu.hibernate.beans;

import java.util.List;

import org.hibernate.Session;

import com.liu.hibernate.dao.AccommodationDao;
import com.liu.hibernate.dao.ApartmentDao;
import com.liu.hibernate.dao.StudentDao;

public class AccommodationInfoOfStudent {
	private List<Student> student;
	private List<Accommodation> accommodation;
	private List<Apartment> apartment;
	public AccommodationInfoOfStudent(Session session) {
		student = new StudentDao(session).listAllStudent();
		accommodation = new AccommodationDao(session).listAllAccommodation();
		apartment = new ApartmentDao(session).listAllAparment();
	}
	
	public void printInfo(){
		for(int i= 0;i<accommodation.size();i++)
			for(int j = 0;j<student.size();j++)
				for(int k = 0;k < apartment.size();k++){
					if(apartment.get(k).getId()==accommodation.get(i).getApartmentId()&&student.get(j).getId()==accommodation.get(i).getStudentId()){
						System.out.println(student.get(i).getSid()+","+student.get(i).getFirstname()+student.get(i).getLastname()+","+accommodation.get(i)+apartment.get(k));
					}
				}
	}
	
	
	
	
	
}
