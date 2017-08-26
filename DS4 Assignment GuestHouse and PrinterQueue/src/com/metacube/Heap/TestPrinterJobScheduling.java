package com.metacube.Heap;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestPrinterJobScheduling {
    PrinterJobScheduling scheduling; 
    @Test
    public void testPrinterSchedulingPositive() {
        scheduling = new PrinterJobScheduling();
        scheduling.addJobToScheduleQueue( new PrinterJob("AdmissionRequests",JobDepartment.ADMIN) );
        scheduling.addJobToScheduleQueue( new PrinterJob("GradReports",JobDepartment.GRADUATE) );
        scheduling.addJobToScheduleQueue( new PrinterJob("UGReports",JobDepartment.UNDERGRADUATE) );
        scheduling.addJobToScheduleQueue( new PrinterJob("SalarySlips",JobDepartment.ADMIN) );
        scheduling.addJobToScheduleQueue( new PrinterJob("LectureNotes",JobDepartment.PROFESSOR) );
        scheduling.addJobToScheduleQueue( new PrinterJob("ProjectSynopsis",JobDepartment.GRADUATE) );
        scheduling.addJobToScheduleQueue( new PrinterJob("ApplicationForm",JobDepartment.UNDERGRADUATE) );
        List<String> executionOrderedDocuments = scheduling.getExecutionOrderForCurrentJobs(); 
        assertArrayEquals(new String[]{"AdmissionRequests","SalarySlips","LectureNotes",
                "GradReports","ProjectSynopsis","UGReports","ApplicationForm"}, executionOrderedDocuments.toArray());
    }
    @Test
    public void testPrinterSchedulingNegative() {
        scheduling = new PrinterJobScheduling();
        boolean comparisonFlag = true;
        scheduling.addJobToScheduleQueue( new PrinterJob("AdmissionRequests",JobDepartment.ADMIN) );
        scheduling.addJobToScheduleQueue( new PrinterJob("GradReports",JobDepartment.GRADUATE) );
        scheduling.addJobToScheduleQueue( new PrinterJob("UGReports",JobDepartment.UNDERGRADUATE) );
        scheduling.addJobToScheduleQueue( new PrinterJob("SalarySlips",JobDepartment.ADMIN) );
        List<String> executionOrderedDocuments = scheduling.getExecutionOrderForCurrentJobs();
        String notExpected[] = new String[]{"AdmissionRequests","GradReports","UGReports","SalarySlips"};
        for(int stringIndex = 0; stringIndex < notExpected.length; stringIndex++ ){
            comparisonFlag = notExpected[stringIndex].equals(executionOrderedDocuments.get(stringIndex));
        }
        assertFalse(comparisonFlag);
    }
}