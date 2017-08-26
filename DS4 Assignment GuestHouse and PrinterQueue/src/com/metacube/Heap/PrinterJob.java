package com.metacube.Heap;

public class PrinterJob implements Comparable<Object>{
    private String documentToPrint;
    private JobDepartment jobSentByPriority;
    
    public PrinterJob(String documentToPrint,JobDepartment jobSentByPriority) {
        this.documentToPrint = documentToPrint;
        this.jobSentByPriority = jobSentByPriority;
    }
    public String getDocumentToPrint() {
        return documentToPrint;
    }
    public void setDocumentToPrint(String documentToPrint) {
        this.documentToPrint = documentToPrint;
    }
    public JobDepartment getJobSentByPriority() {
        return jobSentByPriority;
    }
    public void setJobSentByPriority(JobDepartment jobSentByPriority) {
        this.jobSentByPriority = jobSentByPriority;
    }
    @Override
    public int compareTo(Object job2) {
        PrinterJob job1 =(PrinterJob) job2;
        return (this.jobSentByPriority.compareTo(job1.getJobSentByPriority()));
    }
}
