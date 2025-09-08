def convert_gpa_to_letter(scores):

    grade_letters = []
    index = 0
    while index < len(scores):
        gpa = scores[index]
        if gpa == 4.0:
            grade_letters.append("A+")
        elif gpa > 3.7:
            grade_letters.append("A")
        elif gpa > 3.3:
            grade_letters.append("A-")
        elif gpa > 3.0:
            grade_letters.append("B+")
        elif gpa > 2.7:
            grade_letters.append("B")
        elif gpa > 2.3:
            grade_letters.append("B-")
        elif gpa > 2.0:
            grade_letters.append("C+")
        elif gpa > 1.7:
            grade_letters.append("C")
        elif gpa > 1.3:
            grade_letters.append("C-")
        elif gpa > 1.0:
            grade_letters.append("D+")
        elif gpa > 0.7:
            grade_letters.append("D")
        elif gpa > 0.0:
            grade_letters.append("D-")
        else:
            grade_letters.append("E")
        index += 1
    return grade_letters

# method name: numerical_letter_grade -> convert_gpa_to_letter
# parameter name: grades -> scores
# variable name: letter_grade -> grade_letters
# replaced for loop with while loop
# introduced index variable to iterate through scores list