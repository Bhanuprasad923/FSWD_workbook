package com.klu.constructorDI;

public class Course {
		private String coursename;
		private int duration;
		
		public Course(String coursename, int duration)
		{
			this.coursename=coursename;
			this.duration=duration;
			
		}

		public String getCoursename() {
			return coursename;
		}

		public void setCoursename(String coursename) {
			this.coursename = coursename;
		}

		public int getDuration() {
			return duration;
		}

		public void setDuration(int duration) {
			this.duration = duration;
		}
		
}
