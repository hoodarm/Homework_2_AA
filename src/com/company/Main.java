package com.company;

public class Main
{

    public static void main(String[] args)
    {
        //using standard approach through parallel array arrangements
        String[] students = {"Alissa", "Ben", "Charlie", "Dianna"};
        String[] grades = {"B", "D", "B", "A"};
        String name = "Dianna";

        //Binary search
        System.out.println(BinaryGradeFinder(students, grades, name));

        //Sequential search
        System.out.println(SequentialGradeFinder(students, grades, name));

        //using classes and objects
        GradeFinder[] students2 = new GradeFinder[4];
        students2[0] = new GradeFinder("Alissa", "B");
        students2[1] = new GradeFinder("Ben", "D");
        students2[2] = new GradeFinder("Charlie", "B");
        students2[3] = new GradeFinder("Dianna", "A");
        String name2 = "Charlie";

        //Binary search
        System.out.println(BinaryClassGradeFinder(students2, name2));

        //Sequential search
        System.out.println(SequentialClassGradeFinder(students2, name2));
    }

    static String BinaryGradeFinder(String[] a, String[] b, String name)
    {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            String val = a[mid];
            if (val.equals(name))
            {
                return b[mid];
            }
            else if (val.compareTo(name) < 0)
            {
                lo = mid + 1;
            }
            else
                hi = mid - 1;
        }
        return ("Name not found");
    }

    static String BinaryClassGradeFinder(GradeFinder[] studentInfo, String name)
    {
        int lo = 0, hi = studentInfo.length - 1;
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            String val = studentInfo[mid].name;
            if (val.equals(name))
            {
                return studentInfo[mid].grade;
            }
            else if (val.compareTo(name) < 0)
            {
                lo = mid + 1;
            }
            else
                hi = mid - 1;
        }
        return ("Name not found");
    }

    static String SequentialGradeFinder(String[] a, String[] b, String name)
    {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i].equals(name))
            {
                return b[i];
            }
        }
        return ("Name not found");
    }

    static String SequentialClassGradeFinder(GradeFinder[] studentInfo, String name)
    {
        for (GradeFinder gradeFinder : studentInfo)
        {
            if (gradeFinder.name.equals(name))
            {
                return gradeFinder.grade;
            }
        }
        return ("Name not found");
    }
}

class GradeFinder
{
    String name;
    String grade;

    GradeFinder(String name, String grade)
    {
        this.name = name;
        this.grade = grade;
    }
}