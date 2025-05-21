def convert_gpas_to_letters(gpas):
    grade_mapping = [
        (4.0, "A+"),
        (3.7, "A"),
        (3.3, "A-"),
        (3.0, "B+"),
        (2.7, "B"),
        (2.3, "B-"),
        (2.0, "C+"),
        (1.7, "C"),
        (1.3, "C-"),
        (1.0, "D+"),
        (0.7, "D"),
        (0.0, "D-"),
        (-1.0, "E")  # Added -1.0 to handle the else case
    ]

    letter_grades = []
    index = 0
    while index < len(gpas):
        gpa = gpas[index]
        while gpa <= grade_mapping[index][0]:
            index += 1
        letter_grades.append(grade_mapping[index - 1][1])
        index += 1

    return letter_grades

# method name: numerical_letter_grade -> convert_gpas_to_letters
# parameter name: grades -> gpas
# variable name: letter_grade -> letter_grades
# replaced the for loop with a while loop and used a list of tuples for grade mapping
# added a -1.0 entry in grade_mapping to handle the else case
# used a nested while loop to find the correct grade based on GPA