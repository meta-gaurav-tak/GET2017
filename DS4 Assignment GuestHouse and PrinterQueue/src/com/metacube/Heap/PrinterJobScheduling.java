package com.metacube.Heap;

import java.util.ArrayList;
import java.util.List;

public class PrinterJobScheduling {
    
	private BinaryHeap<PrinterJob> printQueue;
	
	public PrinterJobScheduling() {
        printQueue = new BinaryHeap<PrinterJob>(); 
    }
    public BinaryHeap<PrinterJob> getPrintQueue() {
		return printQueue;
	}
	public void setPrintQueue(BinaryHeap<PrinterJob> printQueue) {
		this.printQueue = printQueue;
	}
	
	//to add jobs to printers execution queue
	public void addJobToScheduleQueue(PrinterJob job) {
		this.getPrintQueue().insert(job);
	}
	
	// to return the execution order of jobs based on priority of department 
	public List<String> getExecutionOrderForCurrentJobs() {
		List<String> jobsInExecutionSequence = new ArrayList<String>();
		if(this.getPrintQueue().getArraySize() == 0) {
			System.out.println("No jobs on Queue");
		} else {
			int totaljobs = this.getPrintQueue().getArraySize();
			for(int i=0;i < totaljobs; i++) {
			    try{
				PrinterJob job = (PrinterJob) this.getPrintQueue().delete();
				jobsInExecutionSequence.add(job.getDocumentToPrint());
			    }catch(HeapEmptyException e) {
			        return jobsInExecutionSequence;
			    }
				
			}
		}
		return jobsInExecutionSequence;
	}
	
	/*public static void main( String args[]) {
		PrinterJobScheduling scheduling = new PrinterJobScheduling();
		PrinterJob j1 = new PrinterJob("AdmissionRequests",JobDepartment.ADMIN);
		PrinterJob j2 = new PrinterJob("GradReports",JobDepartment.GRADUATE);
		PrinterJob j3 = new PrinterJob("UGReports",JobDepartment.UNDERGRADUATE);
		PrinterJob j4 = new PrinterJob("SalarySlips",JobDepartment.ADMIN);
		PrinterJob j5 = new PrinterJob("LectureNotes",JobDepartment.PROFESSOR);
		PrinterJob j6 = new PrinterJob("ProjectSynopsis",JobDepartment.GRADUATE);
		PrinterJob j7 = new PrinterJob("ApplicationForm",JobDepartment.UNDERGRADUATE);
		
		scheduling.addJobToScheduleQueue(j1);
		scheduling.addJobToScheduleQueue(j2);
		scheduling.addJobToScheduleQueue(j3);
		scheduling.addJobToScheduleQueue(j4);
		scheduling.addJobToScheduleQueue(j5);
		scheduling.addJobToScheduleQueue(j6);
		scheduling.addJobToScheduleQueue(j7);
		
		
		int jobOrderSequenceCode = 1;
		for(String job : scheduling.getExecutionOrderForCurrentJobs() ) {
			System.out.println(jobOrderSequenceCode++ +". "+job);
		}
	}*/

}
