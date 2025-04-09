class Start {

    public static void main(String[] args) {

        GraduateStudent g1 = new GraduateStudent("Efaz", 25, "24-5674-2", "Computer Science", "AI Research",
                "Dr. Anik kumar saha");

        GraduateStudent g2 = new GraduateStudent("Mahin", 28, "24-675-2", "Biology", "Genetics", "Dr. Samiul Islam");

        GraduateStudent GraduateStudents[] = new GraduateStudent[3];

        GraduateStudents[0] = g1;
        GraduateStudents[1] = g2;

        for (int i = 0; i < 2; i++) {
            if (GraduateStudents[i] != null) {
                System.out.println("Graduate Student " + (i + 1) + ":");
                GraduateStudents[i].displayGraduateStudentInfo();
                System.out.println();
            }
        }
    }
}