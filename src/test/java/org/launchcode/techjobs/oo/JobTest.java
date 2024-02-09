package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job testJob1 = new Job();
        Job testJob2 = new Job();
        assertNotEquals(testJob1.getId(), testJob2.getId());

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job(null, new Employer(null), new Location(null), new PositionType("Full-time"), new CoreCompetency("Java"));
        Job job2 = new Job("Data analyst", new Employer("GM"), new Location("Michigan"), new PositionType("Full-time"), new CoreCompetency("Java"));
        assertNotEquals(job1, job2);


    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job("Data analyst", new Employer("GM"), new Location("Michigan"), new PositionType("Full-time"), new CoreCompetency("Java"));
        String expected = System.lineSeparator() + "ID: " + job.getId() + System.lineSeparator() + "Name: Data analyst" + System.lineSeparator() + "Employer: GM" + System.lineSeparator() + "Location: Michigan" + System.lineSeparator() + "Position Type: Full-time" + System.lineSeparator() + "Core Competency: Java" + System.lineSeparator();
        assertEquals(expected, job.toString());

    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job = new Job("Data analyst", new Employer("GM"), new Location("Michigan"), new PositionType("Full-time"), new CoreCompetency("Java"));
        String expected= System.lineSeparator() +
                "ID: " + job.getId() + System.lineSeparator() +
                "Name: Data analyst" + System.lineSeparator() +
                "Employer: GM" + System.lineSeparator() +
                "Location: Michigan" + System.lineSeparator() +
                "Position Type: Full-time" + System.lineSeparator() +
                "Core Competency: Java" + System.lineSeparator();

        assertEquals(expected, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("", new Employer("Twitter"), new Location("Washington D.C."), new PositionType(""), new CoreCompetency("React"));
        String expected = System.lineSeparator() +
                "ID: " + job.getId() +System.lineSeparator() +
                "Name: Data not available"+System.lineSeparator() +
                "Employer: Twitter"+System.lineSeparator() +
                "Location: Washington D.C."+System.lineSeparator() +
                "Position Type: Data not available"+System.lineSeparator() +
                "Core Competency: React"+ System.lineSeparator();
        assertEquals(expected, job.toString());
    }
}