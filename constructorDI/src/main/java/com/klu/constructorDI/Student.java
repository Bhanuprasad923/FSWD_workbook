package com.klu.constructorDI;

public class Student {
	  private int id;
	  private String name;
	  private double fee;
	  private boolean active;
	  private Integer age;
	  private Double marks;
	  private Course course;
	  public Student(int id,String name,double fee,boolean active, Integer age, Double marks,Course course) {
	    
	    this.id=id;
	    this.name=name;
	    this.fee=fee;
	    this.active=active;
	    this.age=age;
	    this.marks=marks;
	    this.course=course;
	    
	  }
	  
	  public void display() {
	    System.out.println("The IDs is: "+id);
	    System.out.println("The name is: "+name);
	    System.out.println("The fees is: "+fee);
	    System.out.println("The active is: "+active);
	    System.out.println("The age is: "+age);
	    System.out.println("The marks is: "+marks);
	    System.out.println("The course name is: "+course.getCoursename());
	    System.out.println("The course duration is: "+course.getDuration());
	  }
	  

}