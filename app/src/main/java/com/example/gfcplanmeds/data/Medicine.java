package com.example.gfcplanmeds.data;


public class Medicine {

    public String MedicineName;
    public String Dosage;
    public String ShouldBeTaken;
    public String TimesDay;
    public String TimesWeek;

    public Medicine(String medicineName, String dosage, String shouldBeTaken, String timesDay, String timesWeek) {
        MedicineName = medicineName;
        Dosage = dosage;
        ShouldBeTaken = shouldBeTaken;
        TimesDay = timesDay;
        TimesWeek = timesWeek;
    }

}
